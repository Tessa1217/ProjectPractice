package co.edu.boot.notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.edu.boot.common.Command;
import co.edu.boot.notice.service.NoticeService;
import co.edu.boot.notice.serviceImpl.NoticeServiceImpl;
import co.edu.boot.notice.vo.NoticeVO;

public class NoticeInput implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		NoticeService dao = new NoticeServiceImpl(); 
		NoticeVO vo = new NoticeVO(); 
		String saveDir = "c:\\Temp\\"; // 실제 저장 디렉토리
		int maxSize = 1024*1024*1024; // 파일 최대 사이즈
		String originalFile = "";
		String dirFile = ""; 
		try {
			// Parameter: request, 저장 디렉토리, 파일 최대 사이즈, 인코딩 타입, 저장 이름
			System.out.println("파일 저장 중입니다...");
			MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			
			dirFile = multi.getFilesystemName("fileName");
			vo.setDirFileName(dirFile);
			
			originalFile = multi.getOriginalFileName("fileName");
			vo.setFileName(originalFile);
			
			// vo 값 세팅 
			vo.setWriter(multi.getParameter("writer"));
			vo.setWdate(Date.valueOf(multi.getParameter("wdate")));
			vo.setTitle(multi.getParameter("title"));
			vo.setSubject(multi.getParameter("subject"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int insert = dao.noticeInsert(vo);
		if (insert > 0) {
			req.setAttribute("message", "정상 입력되었습니다.");
		} else {
			req.setAttribute("message", "정상 입력되지 않았습니다");
		}
		return "notice/noticeMessage";
	}

}
