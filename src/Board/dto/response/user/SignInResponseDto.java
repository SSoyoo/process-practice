package Board.dto.response.user;

import java.util.UUID;

import Board.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignInResponseDto {
	
	private String email;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	private String token;
	
	public SignInResponseDto(User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.phoneNumber = user.getPhoneNumber();
		this.address = user.getAddress();
		this.addressDetail = user.getAddressDetail();
		this.profileImageUrl = user.getProfileImageUrl();
		this.token = UUID.randomUUID().toString();
	}

}
