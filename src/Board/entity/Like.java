package Board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Like {
	
	private String userEmail;
	private String userProfileImageUrl;
	private String userNickname;

}
