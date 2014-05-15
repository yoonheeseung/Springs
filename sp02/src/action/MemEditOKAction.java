package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemDAO;

@Controller
public class MemEditOKAction {
	private MemDAO memService;

	public void setMemService(MemDAO memService) {
		this.memService = memService;
		//스프링 용어로 setter DI 의존관계를 주입했다.
	}
	
	@RequestMapping(value="/mem_edit_ok.do",method=RequestMethod.POST)
	//post방식일때 처리하는 스프링 어노테이션
	public String edit_ok(@ModelAttribute MemBean em, HttpServletRequest request,
			                              HttpServletResponse response,
			                              HttpSession session) throws Exception{
		
		/*
		 * @ModelAttribute 스프링 어노테이션은 mem_edit.jsp의
		 *  파라미터 이름과 MemBean.java의 변수명이 같을 때 이 어노테이션
		 *  을 사용하면 쉽게 값을 가져와 setter()메서드를 호출해서
		 *  저장이 된다.
		 */
		response.setContentType("text/html;charset=utf-8");
		//웹상에 출력되는 한글을 아깨지게 하기위해서 언어코딩
		//타입을 설정
		PrintWriter out=response.getWriter();
		session=request.getSession();
		
		String id=(String)session.getAttribute("id");
		//세션키의 아이디 값을 가져와 저장
		if(id==null){
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='mem_login.do'");
			out.println("</script>");
		}else{
			em.setMem_id(id);//아이디를 저장
			
			int re=this.memService.editM(em);
			
			if(re==1){
				out.println("<script>");
				out.println("alert('정보수정이 성공했습니다!')");
				out.println("location='mem_edit.do'");
				out.println("</script>");
//				return "redirect:/mem_edit.do";	
			}else{
				out.println("<script>");
				out.println("alert('정보수정이 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		return null;
	}
	
	
	
	
}
