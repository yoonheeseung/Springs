package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class MemLoginAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		ModelAndView loginM=new ModelAndView("member/mem_login");
		
		return loginM;
		//jsp/member/mem_login.jsp뷰페이지로 실행.
	}

}
