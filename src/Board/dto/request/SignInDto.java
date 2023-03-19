package Board.dto.request;

import lombok.Data;

@Data
public class SignInDto {
	
	private String email;
	private String password;
	
	public boolean vaildData() {
		return 
				this.email.isBlank() ||
				this.password.isBlank();
	}

}
