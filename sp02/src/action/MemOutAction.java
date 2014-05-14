package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemOutAction {

	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public String logout(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		session.invalidate();// 세션만료

		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!')");
		out.println("location='mem_login.do'");
		out.println("</script>");

		return null;
	}
}
