package com.mycom.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.dao.BoardDao;
import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;


//controller의 요청에 의해 필요한 파라미터는 받고 원하는 결과 데이터를 만들어서 리턴해 준다.
//Business logic의 핵심은 바로 service layer에서 !!

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao dao;
	
	private final int SUCCESS=1;
	private final int FAIL=-11;
	
	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			List<BoardDto> list = dao.boardList(boardParamDto);
			int count=dao.boardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
			int count=dao.boardListSearchWordTotalCount(boardParamDto);
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;

	}

	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			//db에서 게시글 정보 가져옴
			BoardDto boardDto = dao.boardDetail(boardParamDto);
			//게시글 작성자와 현재 조회하는 사람이 동일한지 여부 확인 필요
			if(boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			}else {
				boardDto.setSameUser(false);
			}
			
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardUpdate(BoardDto boardDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret = dao.boardUpdate(boardDto);
			if( ret==1 ) {
				boardResultDto.setResult(SUCCESS);
			}else {
				boardResultDto.setResult(FAIL);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDelete(int boardId) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret = dao.boardDelete(boardId);

			if( ret==1 ) {
				boardResultDto.setResult(SUCCESS);
			}else {
				boardResultDto.setResult(FAIL);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardInsert(BoardDto boardDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret = dao.boardInsert(boardDto);

			if( ret==1 ) {
				boardResultDto.setResult(SUCCESS);
			}else {
				boardResultDto.setResult(FAIL);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

}
