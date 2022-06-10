package co.edu.boot.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.boot.common.Command;
import co.edu.boot.notice.service.NoticeService;
import co.edu.boot.notice.serviceImpl.NoticeServiceImpl;
import co.edu.boot.notice.vo.NoticeVO;

public class NoticeSearchList implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String key = req.getParameter("key");
		String val = req.getParameter("val");
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> searchList = new ArrayList<NoticeVO>();
		ObjectMapper mapper = new ObjectMapper(); 
		searchList = dao.noticeSearchList(key, val);
		String jsonData = "";
		try {
			jsonData = mapper.writeValueAsString(searchList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonData);
		return "ajax:" + jsonData;
	}

}
