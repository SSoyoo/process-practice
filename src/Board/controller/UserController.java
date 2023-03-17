package Board.controller;

import Board.dto.request.SignUpDto;

public class UserController {
	
	public void vaildData(SignUpDto signUpDto) {
		
		if(signUpDto.vaildData()) {
			System.out.println("모두입력하세요");
			return;
		}
		
		
		
		
	}

}
