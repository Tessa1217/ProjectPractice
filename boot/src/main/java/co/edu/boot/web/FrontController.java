package co.edu.boot.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.boot.common.Command;
import co.edu.boot.home.Home;
import co.edu.boot.notice.command.NoticeInput;
import co.edu.boot.notice.command.NoticeInputForm;
import co.edu.boot.notice.command.NoticeList;
import co.edu.boot.notice.command.NoticeSearchList;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		map.put("/noticeInputForm.do", new NoticeInputForm());
		map.put("/noticeInput.do", new NoticeInput());
		map.put("/noticeList.do", new NoticeList());
		map.put("/noticeSearchList.do", new NoticeSearchList());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String page = uri.substring(contextPath.length());

		Command cmd = map.get(page);
		String viewPage = cmd.exec(req, resp);

		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) {
				resp.setContentType("text/html; charset=UTF-8");
				viewPage = viewPage.substring(5);
				resp.getWriter().append(viewPage);
				return;
			} else {
				// viewPage = viewPage + ".tiles";
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			}
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, resp);

	}

}
