package trainReservation.dto;

import java.util.Scanner;

import lombok.Data;
@Data
public class GetReservationDto {

	private String reservationNumber;

	public GetReservationDto() {
		

		Scanner scanner = new Scanner(System.in);
		this.reservationNumber = scanner.nextLine();
	
	}
}
