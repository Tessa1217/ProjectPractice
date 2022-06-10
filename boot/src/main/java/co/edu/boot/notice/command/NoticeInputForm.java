package co.edu.boot.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.boot.common.Command;

public class NoticeInputForm implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		return "notice/noticeInputForm";
	}

}
