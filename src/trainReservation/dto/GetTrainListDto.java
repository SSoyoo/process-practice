package trainReservation.dto;

import java.time.LocalTime;
import java.util.Scanner;

import lombok.Data;

@Data

public class GetTrainListDto {
	
	private String departureStaion;
	private String arrivalStation;
	private String departureTime;
	private int numberOfPeople;
	
	public GetTrainListDto() {

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("출발역: ");
		this.departureStaion = scanner.nextLine();
		
		System.out.println("도착역: ");
		this.arrivalStation = scanner.nextLine();
		
		System.out.println("출발시간: ");
		this.departureTime = scanner.nextLine();
		
		System.out.println("인원수: ");
		this.numberOfPeople = scanner.nextInt();
	}
	
	public boolean isEmpty() {

		return	this.arrivalStation.isBlank() || 
				this.departureStaion.isBlank() || 
				this.departureTime.isBlank(); 
			
		}
	
	public boolean isSameStation() {
		return this.arrivalStation.equals(this.departureStaion);
		
		
	}
	
	public boolean isEqualDapartureStation(String stationname) {
		
		return this.departureStaion.equals(stationname);
		
	}
	
public boolean isEqualArrivalStation(String stationname) {
		
		return this.arrivalStation.equals(stationname);
		
	}
	
	
	
	
	}
	


