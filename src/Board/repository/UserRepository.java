package Board.repository;

import java.util.ArrayList;
import java.util.List;

import Board.dto.request.SignInDto;
import Board.dto.request.SignUpDto;
import Board.entity.User;

public class UserRepository {

	public static List<User> userTable = new ArrayList<>();

	public boolean existByEmail(String email) {

		boolean result = false;
		
		
		for (User user : userTable) {
			if (user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;

	}
	
	public User addUser(User user) {
		userTable.add(user);
		return user;
	}
	
	public User findByEmail(String email) {
		
		User user = null;
		
		for(User item : userTable) {
			if(item.getEmail().equals(email)){
				user = item;
				break;
			}
					
		}
		return user;
	}
	
}
