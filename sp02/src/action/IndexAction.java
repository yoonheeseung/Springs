package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Controller 어노테이션(@)을 사용하면 implements Controller
//을 하지 않아도 쉽게 스프링 컨트롤 클래스를 만들 수 있다.
public class IndexAction {
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	//redirect로 이동하는 것은 get방식으로 접근하는 것이다.
	//그러므로 get방식일때 호출되는 어느테이션이다.
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		session=request.getSession();//세션객체 생성
		
		String id=(String)session.getAttribute("id");
		//세션키에서 세션 아이디값을 구함.
		if(id==null){
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			return "index";
			//index.jsp 뷰페이지로 이동
		}
		return null;
	}

}
