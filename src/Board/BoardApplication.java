package Board;

import java.util.Scanner;

import Board.controller.BoardController;
import Board.controller.UserController;
import Board.dto.request.PatchBoardDto;
import Board.dto.request.PostBoardDto;
import Board.dto.request.SignInDto;
import Board.dto.request.SignUpDto;


public class BoardApplication {
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN = "POST /sign-in";
	private static final String POST_BOARD = "POST /board";
	private static final String GET_BOARD = "GET /board";
	private static final String GET_BOARD_LIST = "GET /board/list";
	private static final String PATCH_BOARD = "PATCH /board";
	private static final String DELETE_BOARD = "DELETE /board";
	
	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();

	
	
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
			
			}else if(endPoint.equals(POST_BOARD)) {
				
				PostBoardDto postBoardDto = new PostBoardDto();
				
				System.out.println("제목: ");
				postBoardDto.setTitle(scanner.nextLine());
				
				System.out.println("내용: ");
				postBoardDto.setContent(scanner.nextLine());
				
				System.out.println("이메일: ");
				postBoardDto.setWriterEmail(scanner.nextLine());
				
				boardController.postBoard(postBoardDto);
				
				
			}else if(endPoint.equals(GET_BOARD_LIST)) {
				boardController.getBoardList();
				
			}else if(endPoint.equals(GET_BOARD)) {
				
				int boardNumber = 0;
				
				try {
					System.out.println("게시물 번호:");
					boardNumber = scanner.nextInt();
				}catch (Exception e) {
					System.out.println("정수로 입력하세요");
					continue;
				}
				
				boardController.getBoard(boardNumber);
			}
			
			else if(endPoint.equals(PATCH_BOARD)) {
			
				PatchBoardDto patchBoardDto = new PatchBoardDto();
				
				try {
					System.out.println("게시물 번호:");
					patchBoardDto.setBoardNumber(scanner.nextInt());
					
				}catch (Exception e) {
					System.out.println("정수로 입력하세요");
					continue;
				}
				scanner.nextLine();
				
				System.out.println("제목: ");
				patchBoardDto.setTitle(scanner.nextLine());
				
				System.out.println("내용: ");
				patchBoardDto.setContent(scanner.nextLine());
				
				System.out.println("이미지: ");
				patchBoardDto.setBoardImageUrl(scanner.nextLine());
				
				System.out.println("이메일: ");
				patchBoardDto.setEmail(scanner.nextLine());
				
				boardController.patchBoard(patchBoardDto);
			}else if(endPoint.equals(DELETE_BOARD)) {
				
				int boardNumber = 0;
				String email;
			
				try {
					System.out.println("게시물 번호:");
					boardNumber=scanner.nextInt();
					
				}catch (Exception e) {
					System.out.println("정수로 입력하세요");
					continue;
				}
				scanner.nextLine();
				
				System.out.println("아이디: ");
				email = scanner.nextLine();
				
				boardController.deleteBoard(boardNumber, email);
				
			}
			
			
		}
		
	}
}
