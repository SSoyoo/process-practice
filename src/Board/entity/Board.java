package Board.entity;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Board.dto.request.PatchBoardDto;
import Board.dto.request.PostBoardDto;
import Board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	
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
	
	public Board(User user, PostBoardDto postBoardDto) {
		
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		this.boardNumber = ++BoardRepository.index;
		this.boardImageUrl = postBoardDto.getBoardImageUrl();
		this.writerEmail = postBoardDto.getWriterEmail();
		this.writerNickname = user.getNickname();
		this.writerProfileImageUrl = user.getProfileImageUrl();
		this.writeDate = simpleDateFormat.format(now);
		this.title = postBoardDto.getTitle();
		this.content = postBoardDto.getContent();
		this.viewCount = 0;
		this.likeList = new ArrayList<>();
		this.commentList = new ArrayList<>();
		
	}
	
	public void increaseViewCount() {
		this.viewCount++;
	}
	
	public void patchBoard(PatchBoardDto patchBoardDto) {
		
		this.title = patchBoardDto.getTitle();
		this.content = patchBoardDto.getContent();
		this.boardImageUrl = patchBoardDto.getBoardImageUrl();
		
	}
	

}
