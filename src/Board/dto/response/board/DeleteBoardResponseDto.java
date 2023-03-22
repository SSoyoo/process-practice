package Board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import Board.entity.Board;
import Board.entity.Comment;
import Board.entity.Like;

public class DeleteBoardResponseDto {
	
	private int boardNumber;
	private String writerProfileImageUrl;
	private String writerNickname;
	private String writeDate;
	private String title;
	private String content;
	private String boardImageUrl;
	private List<Comment>commentList;
	private int commentCount;
	private List<Like>likeList;
	private int likeCount;
	private int viewCount;
	
	public DeleteBoardResponseDto(Board board){
		
		this.boardNumber = board.getBoardNumber();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writerNickname = board.getWriterNickname();
		this.writeDate = board.getWriteDate();
		this.title = board.getTitle();
		this.content =board.getContent();
		this.boardImageUrl = board.getBoardImageUrl();
		this.commentList = board.getCommentList();
		this.commentCount = commentList.size();
		this.likeList = board.getLikeList();
		this.likeCount = likeList.size();
		this.viewCount = board.getViewCount();
		
		
	}
	
	public static List<DeleteBoardResponseDto> copyList(List<Board> boardList){
		
		List<DeleteBoardResponseDto> result = new ArrayList<>();
		
		for(Board board : boardList) {
			DeleteBoardResponseDto item = new DeleteBoardResponseDto(board);
			result.add(item);
		}
		
		return result;
	}
	

}
