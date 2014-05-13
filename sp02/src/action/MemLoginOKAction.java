package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.MemDAO;

public class MemLoginOKAction implements Controller {

	private MemDAO memService;
	
	
	public void setMemService(MemDAO memService) {
		this.memService = memService;
	}//스프링 setter DI 의존관계를 설정


	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        	response.setContentType("text/html;charset=utf-8");
        	PrintWriter out=response.getWriter();
        	
        	String login_id=request.getParameter("login_id").trim();
        	String login_pwd=request.getParameter("login_pwd").trim();
        	
        	MemBean dm=this.memService.loginCheck(login_id);
        	
        	if(dm !=null){
        		out.println("<script>");
        		out.println("alert('로그인성공');");
        		out.println("history.go(-1);");
        		out.println("</script>");
        	}
        	
        	return null;
	}
}
