package Board.service;

import Board.dto.request.SignInDto;
import Board.dto.request.SignUpDto;
import Board.dto.response.ResponseDto;
import Board.dto.response.user.SignInResponseDto;
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
	
	
	public ResponseDto<SignInResponseDto> userSignIn(SignInDto signInDto){
		
		
		SignInResponseDto data = null;
		String email = signInDto.getEmail();
		String password = signInDto.getPassword();
		
		User user = userRepository.findByEmail(email);
		
		if(user == null) {
			return new ResponseDto<SignInResponseDto>(false, "로그인실패", null);
					
		}
		
		if(!password.equals(user.getPassword())) {
			return new ResponseDto<SignInResponseDto>(false, "로그인실패", null);
		}
		
		data = new SignInResponseDto(user);
		
		return new ResponseDto(true, "로그인성공", data);
		
	}
	
	
	
	

}
