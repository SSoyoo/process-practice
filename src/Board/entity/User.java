package Board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data 
@AllArgsConstructor

public class User {
	
	private String email;
	private String password;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	
	

}
