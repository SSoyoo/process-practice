package Board.service;

import java.util.List;

import Board.dto.request.PatchBoardDto;
import Board.dto.request.PostBoardDto;
import Board.dto.response.ResponseDto;
import Board.dto.response.board.DeleteBoardResponseDto;
import Board.dto.response.board.GetBoardListResponseDto;
import Board.dto.response.board.GetBoardResponseDto;
import Board.dto.response.board.PatchBoardResponseDto;
import Board.dto.response.board.PostBoardResponseDto;
import Board.entity.Board;
import Board.entity.User;
import Board.repository.BoardRepository;
import Board.repository.UserRepository;


public class BoardService {
	private BoardRepository boardRepository;
	private UserRepository userRepository;
	
	public BoardService() {
		boardRepository = new BoardRepository();
		userRepository = new UserRepository();
	}

	public ResponseDto<PostBoardResponseDto> postBoard(PostBoardDto postBoardDto){
		
		
		PostBoardResponseDto data = null; // 게시글 생성 후, 반환될 responsedto의 data
		
		String email = postBoardDto.getWriterEmail();
		
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return new ResponseDto<>(false, "존재하지 않는 이메일", null);
		}
		
		Board board = new Board(user, postBoardDto);
		boardRepository.save(board);
		
		data = new PostBoardResponseDto(board);
		return new ResponseDto(true,"성공",data);
		
		
	}
	
	public ResponseDto<List<GetBoardListResponseDto>> getBoardList(){
		
		List<GetBoardListResponseDto> data = null;
		List<Board> boardList = boardRepository.getBoardTable();
		data = GetBoardListResponseDto.copyList(boardList);
		return new ResponseDto<List<GetBoardListResponseDto>>(true, "전체 글 조회",data);
		
		
	}
	
	public ResponseDto<GetBoardResponseDto> getBoard(int boardNumber){
		
		GetBoardResponseDto data = null; 
		
		Board board = boardRepository.findByBoardNumber(boardNumber);
		
		if(board == null) {
			return new ResponseDto(false, "일치하는 게시글이 없습니다",null);
		}
		
		board.increaseViewCount();
		boardRepository.save(board);
		
		data = new GetBoardResponseDto(board);
		
		return new ResponseDto(true, "게시글 조회", data);
		
	}
	
	
	public ResponseDto<PatchBoardResponseDto> patchBoard(PatchBoardDto patchBoardDto){
		
		PatchBoardResponseDto data = null;
		
		String email = patchBoardDto.getEmail();
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			return new ResponseDto(false, "존재하지 않는 이메일입니다", null);
		}
		
		Board board = boardRepository.findByBoardNumber(patchBoardDto.getBoardNumber());
		
		if(board == null) {
			return new ResponseDto(false, "존재하지 않는 게시글입니다", null);
		}
		
		
		if(!board.getWriterEmail().equals(email)) {
			return new ResponseDto<PatchBoardResponseDto>(false, "이메일 불일치", null);
			
		}
		
		board.patchBoard(patchBoardDto);
		
		boardRepository.save(board);
		
		data = new PatchBoardResponseDto(board);
		
		return new ResponseDto<PatchBoardResponseDto>(true, "수정완료",data);
		
	}
	
	public ResponseDto<List<DeleteBoardResponseDto>>deleteBoard (int BoardNumber, String email){
		
		List<DeleteBoardResponseDto> data = null;
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			return new ResponseDto<>(false, "존재하지 않는 이메일입니다", null);
		}
		
		Board board = boardRepository.findByBoardNumber(BoardNumber);
		
		if(board ==null) {
			return new ResponseDto<>(false, "존재하지 않는 게시글입니다", null);
		}
		boolean isSameEmail = board.getWriterEmail().equals(email);
		
		if(!isSameEmail) {
			return new ResponseDto<>(false, "이메일이 일치하지 않습니다", null);
		}
		
		List<Board> deletedList = boardRepository.deleteBoard(board);
		data = DeleteBoardResponseDto.copyList(deletedList);
		
		return new ResponseDto<>(true, "삭제성공", data);
		
		
		
	}
	
}
