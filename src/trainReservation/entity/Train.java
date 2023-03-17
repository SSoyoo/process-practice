package trainReservation.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor


public class Train {
	
	//열차번호, 출발역, 출발시간, 도착역, 도착시간, 소요시간, 열차종류, 정차역리스트, 좌석리스트

	private String trainNumber;
	
	private String depatureStation;
	private String depatureTime;
	
	private String arrivalStation;
	private String arrivalTime;
	
	private int takeMinute;
	private String trainType;
	
	private List<StopStation> stopStations; // 정차역에 관한 정보를 담은 객체들의 리스트니까 제네릭타입은 Stopstation
	private List<Seat> seats;
	@Override
	public String toString() {
		return "Train [trainNumber=" + trainNumber + "\n" +", depatureStation=" + depatureStation + "\n" +", depatureTime="
				+ depatureTime + "\n" +", arrivalStation=" + arrivalStation + "\n" +", arrivalTime=" + arrivalTime + "\n" + ", takeMinute="
				+ takeMinute + "\n" +", trainType=" + trainType + "\n" + ", stopStations=" + stopStations + "\n" + ", seats=" + seats + "]";
	}
	
	
	
	
	
}
