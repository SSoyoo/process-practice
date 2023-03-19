package Board;

import java.util.Scanner;

import Board.controller.UserController;
import Board.dto.request.SignInDto;
import Board.dto.request.SignUpDto;


public class BoardApplication {
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN = "POST /sign-in";
	private static UserController userController = new UserController();

	
	
	public static void main(String[] args) {
		
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("URL End point : ");
			String endPoint = scanner.nextLine();
			
			if(endPoint.equals(SIGN_UP)) {
				
				SignUpDto signUpDto = new SignUpDto();
				
				System.out.println("이메일주소: ");
				signUpDto.setEmail(scanner.nextLine());
				
				System.out.println("비밀번호: ");
				signUpDto.setPassword(scanner.nextLine());
				
				System.out.println("비밀번호 확인: ");
				signUpDto.setPasswordCheck(scanner.nextLine());
				
				System.out.println("닉네임");
				signUpDto.setNickname(scanner.nextLine());
				
				System.out.println("휴대폰번호: ");
				signUpDto.setPhoneNumber(scanner.nextLine());
				
				System.out.println("주소: ");
				signUpDto.setAddress(scanner.nextLine());
				
				System.out.println("상세주소: ");
				signUpDto.setAddressDetail(scanner.nextLine());
				
				System.out.println(signUpDto);
				
				userController.signUp(signUpDto);
			
				
			}else if(endPoint.equals(SIGN_IN)) {
				
				SignInDto signInDto = new SignInDto();
				
				System.out.println("이메일: ");
				signInDto.setEmail(scanner.nextLine());
				
				System.out.println("비밀번호 : ");
				signInDto.setPassword(scanner.nextLine());
				
				userController.signIn(signInDto);
			}
			
			
		}
		
	}
}
