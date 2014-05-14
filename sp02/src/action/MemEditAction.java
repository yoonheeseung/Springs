package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemBean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemDAO;

@Controller
public class MemEditAction {
	private MemDAO memService;

	public void setMemService(MemDAO memService) {
		this.memService = memService;
	}

	@RequestMapping(value = "/mem_edit.do", method = RequestMethod.GET)
	public String edit(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model em)
			throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		session=request.getSession();
		
		String id = (String)session.getAttribute("id");

		if (id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='./mem_login.do'");
			out.println("</script>");
		} else {
			
			String[] phone={"010","011","016","018","019"};
			
			MemBean dm = this.memService.findId(id);
			
			// 아이디에 해당하는 회원정보를 디비로 부터 가져온다.
			em.addAttribute("dm", dm);//회원정보
			em.addAttribute("ph",dm.getMem_phone01());//해당회원 전화번호 앞자리
            em.addAttribute("p",phone);//전화번호 앞자리 리스트
            
			return "member/mem_edit";
			// jsp/member/mem_edit.sjp 뷰 페이지가 실행
		}
		return null;
	}
}
