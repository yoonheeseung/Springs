package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemDELAction {

	@RequestMapping(value = "/mem_del")
	// get or post에 상관없이 호출, .do를 생략해도 된다.
	public String mem_del(HttpSession session,
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		session = request.getSession();

		String id = (String) session.getAttribute("id");
		if (id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='mem_login.do'");
			out.println("</script>");
		} else {
			return "member/mem_del";
		}
		return null;
	}
}
