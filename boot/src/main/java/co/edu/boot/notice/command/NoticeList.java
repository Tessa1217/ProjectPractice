package co.edu.boot.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.boot.common.Command;
import co.edu.boot.notice.service.NoticeService;
import co.edu.boot.notice.serviceImpl.NoticeServiceImpl;
import co.edu.boot.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		NoticeService dao = new NoticeServiceImpl(); 
		List<NoticeVO> list = new ArrayList<NoticeVO>(); 
		list = dao.noticeSelectList();
		req.setAttribute("list", list);
		return "notice/noticeList";
	}

}
