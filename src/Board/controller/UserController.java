package Board.controller;

import Board.dto.request.SignInDto;
import Board.dto.request.SignUpDto;
import Board.dto.response.ResponseDto;
import Board.dto.response.user.SignInResponseDto;
import Board.service.UserService;

public class UserController {
	
	private UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public void signUp(SignUpDto signUpDto) {
		
		if(signUpDto.vaildData()) {
			System.out.println("값을 모두 입력하세요");
			return;
		}
		
		ResponseDto<Boolean> response = userService.userSignUp(signUpDto);
		System.out.println(response);
	
	
	}
	
	public void signIn(SignInDto signInDto) {
		
		if(signInDto.vaildData()) {
			System.out.println("값을 모두 입력하세요");
			return;
			
		}
		ResponseDto<SignInResponseDto> response = userService.userSignIn(signInDto);
		System.out.println(response);
	}
	

}
