package co.edu.account.controller;

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

import co.edu.account.command.HomeCommand;
import co.edu.account.command.SelectAccount;
import co.edu.account.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new HomeCommand());
		map.put("/selectList.do", new SelectAccount());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String page = uri.substring(contextPath.length());

		Command cmd = map.get(page);
		String viewPage = cmd.exec(req, resp);

		if (!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, resp);
	}

}
