package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.MemDAO;

public class MemDElOKAction implements Controller {
	private MemDAO memService;

	public void setMemService(MemDAO memService) {
		this.memService = memService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");

		if (id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='mem_login.do'");
			out.println("<script>");
		} else {
			String del_pwd = request.getParameter("del_pwd").trim();
			String del_cont = request.getParameter("del_cont").trim();

			MemBean db_pwd = this.memService.findId(id);

			if (db_pwd.getMem_pwd().equals(del_pwd)) {
				MemBean dm=new MemBean();
				dm.setMem_id(id);
				dm.setMem_delcont(del_cont);
				
				this.memService.deleteM(dm);//삭제메서드 호출
				
				session.invalidate();//세션을 만료
				
				out.println("<script>");
				out.println("alert('탈퇴했습니다.')");
				out.println("location='mem_login.do'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('비번이 다릅니다.')");
				out.println("history.go(-1)");
				out.println("</script>");
			}
		}

		return null;
	}

}
