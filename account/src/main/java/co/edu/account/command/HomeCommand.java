package co.edu.account.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.account.common.Command;

public class HomeCommand implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "home/home";
	}

}
