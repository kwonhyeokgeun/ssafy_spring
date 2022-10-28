package com.mycom.myboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.dao.BoardDao;
import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;


//controller의 요청에 의해 필요한 파라미터는 받고 원하는 결과 데이터를 만들어서 리턴해 준다.
//Business logic의 핵심은 바로 service layer에서 !!

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao dao;
	
	private final int SUCCESS=1;
	private final int FAIL=-1;
	//C:\Users\SSAFY\Documents\workspace-sts-3.9.14.RELEASE\BoardFileUploadSprintMVCMybatis\src\main\webapp\resources\static
	private final String uploadPath="C:" + File.separator + "Users" + File.separator + "SSAFY"+ File.separator +"Documents"+ File.separator +"workspace-sts-3.9.14.RELEASE"+ File.separator +"BoardFileUploadSprintMVCMybatis"
			+ File.separator +"src"+ File.separator +"main"+ File.separator +"webapp"+ File.separator +"resources"+ File.separator +"static";
	private final String uploadFolder="upload";
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
			//현재 게시글을 현재 사용자가 읽었는지 확인
			//안읽었으면 신규로 게시글 읽었다는 insert 하고 +1
			//읽었으면 무시
			int userReadCount=dao.boardUserReadCount(boardParamDto);
			if(userReadCount==0) {
				dao.boardUserReadInsert(boardParamDto.getBoardId(), boardParamDto.getUserSeq()); //읽은 표시해주기
				dao.boardReadCountUpdate(boardParamDto.getBoardId()); //조회수 1 늘리기
			}
			
			//db에서 게시글 정보 가져옴
			BoardDto boardDto = dao.boardDetail(boardParamDto);
			//게시글 작성자와 현재 조회하는 사람이 동일한지 여부 확인 필요
			if(boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			}else {
				boardDto.setSameUser(false);
			}
			
			//해당 게시글에 대한 첨부파일 정보 추가
			List<BoardFileDto> fileList = dao.boardDetailFileList(boardParamDto.getBoardId());
			boardDto.setFileList(fileList);
			
			
			
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardUpdate(BoardDto boardDto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			int ret = dao.boardUpdate(boardDto); //게시글 수정
			
			File uploadDir = new File(uploadPath +File.separator + uploadFolder); //업로드된 파일이저장될 폴더
			if(!uploadDir.exists())  //해당 폴더가 없으면
				uploadDir.mkdir();
			
			//기존의 첨부된 물리적인 파일 삭제
			List<String> fileUrlList = dao.boardFileUrlDeleteList(boardDto.getBoardId());
			for(String fileUrl : fileUrlList) {
				File file = new File(uploadPath +File.separator + fileUrl);
				if(file.exists()) {
					file.delete();
				}
			}
			
			//db에서 첨부파일 삭제
			dao.boardFileDelete(boardDto.getBoardId());
			
			//새로 추가된 첨부파일 추가
			List<MultipartFile> fileList = request.getFiles("file"); //파일 리스트 받아옴
			
			for(MultipartFile partFile : fileList) {
				int boardId = boardDto.getBoardId();
				String fileName = partFile.getOriginalFilename(); //첨부된 원래파일명 //이 이름으로는 바로 저정하지 않고  UUID를 이용해서 중복불가한 파일이름을 만듬
				
				UUID uuid = UUID.randomUUID(); //대체될 랜덤으로 생성된 파일 이름
				String extension = FilenameUtils.getExtension(fileName); //파일확장자만 추출
				
				//실제 저장할 파일 전체 이름은
				String savingFileName = uuid+"."+extension;
				
				File destFile = new File(uploadPath +File.separator + uploadFolder + File.separator + savingFileName);
				
				partFile.transferTo(destFile);
				
				//테이블에 첨부파일 정보 저장
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(partFile.getSize());
				boardFileDto.setFileContentType(partFile.getContentType());
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);
				
				dao.boardFileInsert(boardFileDto);
				
			}
			
			boardResultDto.setResult(SUCCESS);
			
			
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
			List<String> fileUrlList = dao.boardFileUrlDeleteList(boardId);
			for(String fileUrl : fileUrlList) {
				File file = new File(uploadPath + File.separator, fileUrl);                
				if(file.exists()) {
					file.delete();
				}
			}


			dao.boardFileDelete(boardId);
			dao.boardReadCountDelete(boardId);
			dao.boardDelete(boardId);        
			boardResultDto.setResult(SUCCESS);
			
		}catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	@Transactional //DB transaction 정책 // 
	public BoardResultDto boardInsert(BoardDto boardDto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();
		//게시글 테이블에 등록
		//물리적인 파일 저장
		//여러개의 파일이 기본
		//Multipart의 각 part별로 파일을 구분해서 물리적으로 저장 => 파일 업로드 경로를 테이블에 저장
		try {
			int ret = dao.boardInsert(boardDto);
			System.out.println("generated key : " + boardDto.getBoardId());
			
			File uploadDir = new File(uploadPath +File.separator + uploadFolder); //업로드된 파일이저장될 폴더
			if(!uploadDir.exists())  //해당 폴더가 없으면
				uploadDir.mkdir();
			
			List<MultipartFile> fileList = request.getFiles("file"); //파일 리스트 받아옴
			
			//String str=null; //에러 발생시키기
			//str.length();
			
			for(MultipartFile partFile : fileList) {
				int boardId = boardDto.getBoardId();
				String fileName = partFile.getOriginalFilename(); //첨부된 원래파일명 //이 이름으로는 바로 저정하지 않고  UUID를 이용해서 중복불가한 파일이름을 만듬
				
				UUID uuid = UUID.randomUUID(); //대체될 랜덤으로 생성된 파일 이름
				String extension = FilenameUtils.getExtension(fileName); //파일확장자만 추출
				
				//실제 저장할 파일 전체 이름은
				String savingFileName = uuid+"."+extension;
				
				File destFile = new File(uploadPath +File.separator + uploadFolder + File.separator + savingFileName);
				
				partFile.transferTo(destFile);
				
				//테이블에 첨부파일 정보 저장
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(partFile.getSize());
				boardFileDto.setFileContentType(partFile.getContentType());
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);
				
				dao.boardFileInsert(boardFileDto);
				
			}
			
			boardResultDto.setResult(SUCCESS);
			
			
		}catch(IOException e) {
			//만약 파일 저장작업중 오류가 발생하면 이곳 IOException이 발생
			//2가지 작업 필요
			//#1 예외 발생 이전 저장 파일 삭제 => 직접 물리적인 파일 삭제 작업 수행
			//#2 이전 테이블에 등록된 작업 취소 => Spring의 @Transaction을 이용하기 위해 RuntimeException 계열의 예외를 발생(throw new RuntimeException())
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

}
