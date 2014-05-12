package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InfoBean;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.InfoDAO;

public class InfoListController implements Controller {

	private InfoDAO iService;
	
	public void setiService(InfoDAO iService) {
		this.iService = iService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	  
		  List<InfoBean> glist = this.iService.getIList();

			
			ModelAndView lm=new ModelAndView("./jsp/info/info_list.jsp");
			//생성자에서 뷰페이지 경로를 작업
			lm.addObject("list",glist);//list키에 ilist목록값을 저장
		return lm;
	}

}
