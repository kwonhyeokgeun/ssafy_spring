package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.BoardDto;
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
	
	//수정
	int boardUpdate(BoardDto boardDto);
	
	//삭제
	int boardDelete(int boardId);
	
	//추가
	int boardInsert(BoardDto boardDto);
	
	
	
}
