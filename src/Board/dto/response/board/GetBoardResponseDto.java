package Board.dto.response.board;

import java.util.List;

import Board.entity.Board;
import Board.entity.Comment;
import Board.entity.Like;
import lombok.Data;

@Data
public class GetBoardResponseDto {
	
	private int boardNumber;
	private String title;
	private String content;
	private String boardImageUrl;
	private String writerEmail;
	private String writerProfileImageUrl;
	private String writerNickname;
	private String writeDate;
	private int viewCount;
	private int likeCount;
	private List<Like> likeList;
	private int commentCount;
	private List<Comment> commentList;
	
	public GetBoardResponseDto(Board board) {
		this.boardNumber = board.getBoardNumber();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.boardImageUrl = board.getBoardImageUrl();
		this.writerEmail = board.getWriterEmail();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writerNickname = board.getWriterNickname();
		this.writeDate = board.getWriteDate();
		this.viewCount = board.getViewCount();
		this.likeCount = board.getLikeList().size();
		this.likeList = board.getLikeList();
		this.commentCount = board.getCommentList().size();
		this.commentList = board.getCommentList();
	}
	
	

}
