package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;


//dao layer는 controller, service를 바라보고 코드를 작성하지 않음. DB등 persistance를 보고 작성함


@Mapper
public interface BoardDao {
	//limit, offset
	List<BoardDto> boardList(BoardParamDto boardParamDto);
	int boardListTotalCount();
	
	
	//searchWord
	List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
	int boardListSearchWordTotalCount(BoardParamDto boardParamDto);
	
	//상세
	BoardDto boardDetail(BoardParamDto boardParamDto);
	List<BoardFileDto> boardDetailFileList(int boardId); // 특정 게시글에 첨부된 첨부파일 정보
	
	//수정
	int boardUpdate(BoardDto boardDto);
	List<String> boardFileUrlDeleteList(int boardId); // 첨부파일 리스트
	
	//삭제
	int boardDelete(int boardId); //게시글 db 삭제
	int boardFileDelete(int boardId);   //첨부파일 db 삭제
	
	//추가
	int boardInsert(BoardDto boardDto); //게시글 등록
	int boardFileInsert(BoardFileDto dto); //첨부파일 등록
	
	//조회수 관련
	//1 user 1 view 조건으로  readCount 처리
	int boardUserReadCount(BoardParamDto boardParamDto); //2개의 파라미터 mybatis mat에 대응
	int boardUserReadInsert(@Param("boardId") int boardId, @Param("userSeq")int userSeq); //두개의 파라미터 mybatis map 대응 <-@Param
	
	int boardReadCountUpdate(int boardId); //게시글 조회수 1증가
	int boardReadCountDelete(int boardId);
	
	
}
