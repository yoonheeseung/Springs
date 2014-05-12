package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfoBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.InfoDAO;

public class InfoOKController implements Controller {
	private InfoDAO iService;

	public void setiService(InfoDAO iService) {
		this.iService = iService;
	}//스프링에서 setter DI 의존관계를 설정함. setter()메서드를 통해서
	//iService객체를 만들어 줌.

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name=request.getParameter("name").trim();
		String addr=request.getParameter("addr").trim();
		
		InfoBean ib=new InfoBean();
		ib.setName(name);
		ib.setAddr(addr);
		
		this.iService.insertB(ib);//저장메서드 호출
		//System.out.println("저장성공");
		ModelAndView listM=new ModelAndView();
		listM.setViewName("redirect:/info_list.do");
		
		return listM;//info_list.do로 이동한다.
	}

}
