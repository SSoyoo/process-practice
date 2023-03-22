package Board.controller;

import java.util.List;

import Board.dto.request.PatchBoardDto;
import Board.dto.request.PostBoardDto;
import Board.dto.response.ResponseDto;
import Board.dto.response.board.DeleteBoardResponseDto;
import Board.dto.response.board.GetBoardListResponseDto;
import Board.dto.response.board.GetBoardResponseDto;
import Board.dto.response.board.PatchBoardResponseDto;
import Board.dto.response.board.PostBoardResponseDto;
import Board.service.BoardService;

public class BoardController {
	
	private BoardService boardService;
	
	public BoardController() {
		boardService = new BoardService();
	}
	
	public void postBoard(PostBoardDto postBoardDto){
	
		
		if(postBoardDto.validData()) {
			System.out.println("모든 값을 입력하세요");
			return;
		}
		
		if(postBoardDto.auth()) {
			System.out.println("이메일을 입력하세요");
			return;
		}
		
		ResponseDto<PostBoardResponseDto> response = boardService.postBoard(postBoardDto);
		System.out.println(response);
		
	}

	public void getBoardList() {
		ResponseDto<List<GetBoardListResponseDto>> reponse = boardService.getBoardList();
		System.out.println(reponse);
		
	}
	
	public void getBoard(int boardNumber) {
		
		ResponseDto<GetBoardResponseDto> response = boardService.getBoard(boardNumber);
		System.out.println(response);
		}
	
	public void patchBoard(PatchBoardDto patchBoardDto) {
		
		
		if(patchBoardDto.validData()) {
			System.out.println("전부입력하세요");
			return;
		}
		
		if(patchBoardDto.auth()) {
			System.out.println("존재하지 않는 이메일입니다");
			return;
		}
		
		ResponseDto<PatchBoardResponseDto> response = boardService.patchBoard(patchBoardDto);
		System.out.println(response);
		
	}
	
	public void deleteBoard(int boardNumber , String email) {
		
		if(email.isBlank()) {
			System.out.println("메일을 입력하세요");
			return;
		}
		ResponseDto<List<DeleteBoardResponseDto>> response = boardService.deleteBoard(boardNumber ,email);
		System.out.println(response);
	}
	
	
		
	}
	
	

