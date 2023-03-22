package Board.entity;

import Board.dto.request.SignUpDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	private String email;
	private String password;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	
	public User(SignUpDto signUpDto) {
		
		this.email = signUpDto.getEmail();
		this.password = signUpDto.getPassword();
		this.nickname = signUpDto.getNickname();
		this.phoneNumber = signUpDto.getPhoneNumber();
		this.address = signUpDto.getAddress();
		this.addressDetail = signUpDto.getAddressDetail();
	}
	

}
