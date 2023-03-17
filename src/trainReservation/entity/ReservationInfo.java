package trainReservation.entity;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString


public class ReservationInfo {
	
	private String reservationNumber;
	private String trainNumber;
	private List<String> seatList;
	private String departureStation;
	private String departureTime;
	private String arrivalStation;
	private String arrivaltime;
	private int totalCost;
	
	public ReservationInfo(String trainNumber, List<String> seatList, String departureStation, String departureTime,
			String arrivalStation, String arrivaltime, int totalCost) {
		
		this.reservationNumber = UUID.randomUUID().toString();
		this.trainNumber = trainNumber;
		this.seatList = seatList;
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivaltime = arrivaltime;
		this.totalCost = totalCost;
	}

	

}


