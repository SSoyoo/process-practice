package trainReservation.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Seat {
	
	private int carNumber;
	private String seatNumber;
	@Setter boolean seatStatus;

}
