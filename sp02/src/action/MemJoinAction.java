/**
 * 
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemJoinAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		String[] phone={"010","011","016","018","019"};
		
		ModelAndView jm=new ModelAndView();
		jm.setViewName("member/mem_join");
		jm.addObject("p", phone);//p키에 phone문자열 배열 저장
		return jm;
	}

}
