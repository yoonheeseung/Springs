package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.MemDAO;

public class MemLoginOKAction implements Controller {

	private MemDAO memService;

	public void setMemService(MemDAO memService) {
		this.memService = memService;
	}// 스프링 setter DI 의존관계를 설정

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		//세션객체를 생성,세션객체는 서버에서 실행되고 보안이 강력
		//로그인 인증 처리를 할때 세션객체를 사용하지만 속도는 느리다.
		//쿠키는 사용자 컴에서 실행되고, 속도는 빠르다.
		//하지만 쿠키는 보안이 취약하다는 단점이 있다.
		//로그인 인증처리를 쿠키에서 하면 안된다.

		String login_id = request.getParameter("login_id").trim();
		String login_pwd = request.getParameter("login_pwd").trim();

		MemBean dm = this.memService.loginCheck(login_id);

		if (dm == null) {
			out.println("<script>");
			out.println("alert('가입 회원이 아닙니다!)");
			out.println("history.back()");
			out.println("</script>");
		} else {
			if (!dm.getMem_pwd().equals(login_pwd)) {
				out.println("<script>");
				out.println("alert('비번이 다릅니다!')");
				out.println("history.go(-1)");
				out.println("</script>");
			} else {
				session.setAttribute("id", dm.getMem_id());
				//id키에 회원아이디 저장
				session.setAttribute("name", dm.getMem_name());
				ModelAndView main=new ModelAndView();
				main.setViewName("redirect:/index.do");
				return main;//로그인 인증 후 index.do로 이동
			}
		}
		return null;
	}
}
