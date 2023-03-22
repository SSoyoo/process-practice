package Board.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Comment {

	private String writerProfileImageUrl;
	private String writerNickname;
	private Date writeDatetime;
	private String content;
}
