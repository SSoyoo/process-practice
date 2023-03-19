package Board.controller;

import Board.dto.request.SignUpDto;
import Board.dto.response.ResponseDto;
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
	

}
