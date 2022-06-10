package co.edu.boot.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	
	private int id;
	private String writer;
	private String title;
	private String subject;
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date wdate;
	private int hit;
	private String fileName;
	private String dirFileName;
	
}
