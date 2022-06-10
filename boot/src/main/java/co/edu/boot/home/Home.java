package co.edu.boot.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.boot.common.Command;

public class Home implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "home/home";
	}

}
