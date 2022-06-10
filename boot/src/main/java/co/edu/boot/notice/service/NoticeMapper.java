package co.edu.boot.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.edu.boot.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	List<NoticeVO> noticeSelectList(); // 전체 조회
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);
	NoticeVO noticeSelect(NoticeVO vo); // 상세 보기
	int noticeInsert(NoticeVO vo); // 삽입
	int noticeUpdate(NoticeVO vo); // 수정
	int noticeDelete(NoticeVO vo); // 삭제
	int noticeHitUpdate(int id); // 조회수 조회
}
