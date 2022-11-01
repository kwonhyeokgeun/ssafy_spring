package com.mycom.myboard.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

public interface BoardService {

	//목록
	BoardResultDto boardList(BoardParamDto boardParamDto);
	BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
	
	//상세
	BoardResultDto boardDetail(BoardParamDto boardParamDto);
	
	//수정
	BoardResultDto boardUpdate(BoardDto boardDto, MultipartHttpServletRequest request);
	
	//삭제
	BoardResultDto boardDelete(int boardId);
	
	//추가
	BoardResultDto boardInsert(BoardDto boardDto,MultipartHttpServletRequest request);
}
