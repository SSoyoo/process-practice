package Board.dto.response.board;

import java.util.List;
import Board.entity.Board;
import Board.entity.Comment;
import Board.entity.Like;
import lombok.ToString;
@ToString

public class PostBoardResponseDto {
	
	private int boardNumber;
	private String boardImageUrl;
	private String writerEmail;
	private String writerNickname;
	private String writerProfileImageUrl;
	private String writeDate;
	private String title;
	private String content;
	private int viewCount;
	private List<Like> likeList;
	private List<Comment> commentList;

	public PostBoardResponseDto(Board board) {
		
		this.boardNumber = board.getBoardNumber();
		this.boardImageUrl = board.getBoardImageUrl();
		this.writerEmail = board.getWriterEmail();
		this.writerNickname = board.getWriterNickname();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writeDate = board.getWriteDate();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.viewCount = board.getViewCount();
		this.likeList = board.getLikeList();
		this.commentList = board.getCommentList();
	}

}
