package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class InfoWriteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView im=new ModelAndView();
		im.setViewName("./jsp/info/info_write.jsp");
		return im;
		//jsp폴더의 info폴더의 info_write.jsp 뷰페이지 가 실행
	}

}
