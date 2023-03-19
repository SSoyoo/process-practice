package Board.service;

import Board.dto.request.SignUpDto;
import Board.dto.response.ResponseDto;
import Board.entity.User;
import Board.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public ResponseDto<Boolean> userSignUp(SignUpDto signUpDto){
		
		
		String email = signUpDto.getEmail();
		String password = signUpDto.getPassword();
		String passwordCheck = signUpDto.getPasswordCheck();
		
		boolean hasEmail = userRepository.existByEmail(email);
		
		
		if(hasEmail) {
			return new ResponseDto<Boolean>(false, "존재하는 이메일입니다", false);
		}
		
		if(!password.equals(passwordCheck)) {
			return new ResponseDto<Boolean>(false, "비밀번호가 일치하지 않습니다", false);
		}
		
		User user = new User(signUpDto);
		userRepository.addUser(user);
		return new ResponseDto<Boolean>(true, "회원가입 완료", true);
		
		
	}
	
	
	
	

}
