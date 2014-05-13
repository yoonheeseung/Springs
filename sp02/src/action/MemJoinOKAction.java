package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import model.MemBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemDAO;

@Controller
// Controller 어노테이션(@)을 사용하면 implements Controller
// 자바 코드를 하지 않아도 스프링 컨트롤 클래스를 만들 수 있다.
public class MemJoinOKAction {

	/*
	 * mem_join.jsp 파라미터이름과 MemBean 클래스의 변수이름이 같으면 스프링의 @ModelAttribute 어노테이션을
	 * 사용하면 알아서 일대일 매핑이 되어져서 저장이 된다.
	 */
	private MemDAO memService;// 디비 연동을 해주는 변수

	public void setMemService(MemDAO memService) {
		this.memService = memService;
	}// setter DI 의존관계를 설정

	@RequestMapping(value = "/mem_join_ok.do", method = RequestMethod.POST)
	// method=POST방식으로 넘어오는 것을 처리하는 어노테이션
	public String m_join_ok(@ModelAttribute MemBean m,
			HttpServletResponse response) throws SQLException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 웹상에 보이는 한글을 안 깨지게 한다.
		PrintWriter out = response.getWriter();

		MemBean db_id = this.memService.findId(m.getMem_id());
		// 디비로 부터 중복아이디를 검색
		if (db_id != null) {
			out.println("<script>");
			out.println("alert('중복아이디가 존재합니다!');");
			out.println("history.back()");
			out.println("</script>");
		} else {
			memService.insertM(m);// 저장메서드 호출
			return "redirect:/mem_login.do";
			// 로그인 페이지로 이동
		}
		return null;
	}
}
