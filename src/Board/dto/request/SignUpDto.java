package Board.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SignUpDto {
	
	private String email;
	private String password;
	private String passwordCheck;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	
	public boolean vaildData() { // 입력값이 하나라도 빈값인지 검사
		
		return 
				this.email.isBlank() ||
				this.password.isBlank() ||
				this.passwordCheck.isBlank() ||
				this.nickname.isBlank() ||
				this.phoneNumber.isBlank() ||
				this.address.isBlank() ||
				this.addressDetail.isBlank();
		
	}
	
	

}
