package trainReservation.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Data;
import trainReservation.entity.Seat;
@Data
public class PostReservationDto {
	
	private String inputTrainNumber;
	private List<String>seats;
	
	
	public PostReservationDto(int numberOfPeople) {
		
		Scanner scanner = new Scanner(System.in);
		this.seats = new ArrayList<>();
	
	
		while(true) {
		System.out.println("탑승할 열차번호: ");
		this.inputTrainNumber = scanner.nextLine();
		
		if(this.inputTrainNumber.isBlank()) {
			System.out.println("열차 번호 입력하세요");
			continue;
		}
		break;
		
	}
	
		
		while(this.seats.size()<numberOfPeople) {
			
			System.out.println("좌석번호: ");
			String seat = scanner.nextLine();
			
			if(seat.isBlank()) {
				System.out.println("좌석번호를 입력하세요");
				continue;
			}
			this.seats.add(seat);
			break;
		}
	
}
	
}