package trainReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Cost;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;

public class ReservationService {

	public ReservationService() {
		initData();
	}
	
	private static List<Train> trains = new ArrayList<>();
	private static List<Cost> costs = new ArrayList<>();
	private static List<Train> possibleTrains = new ArrayList<>();
	private static List<ReservationInfo> reservationInfos = new ArrayList<>();

	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	
//	예약가능한 열차리스트를 반환하는 프로세스
	public List<Train> getPossibleTrainList(GetTrainListDto getTrainListDto) {

		for (Train train : trains) {

			List<StopStation> stopStations = train.getStopStations();
			int departureStationIndex = -1;

			for (int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				
				StopStation stopStation = stopStations.get(stopStationIndex);
				String stopStationName = stopStation.getStationName();

				LocalTime userDepatureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeFormatter);
				LocalTime trainDeptureTime = LocalTime.parse(stopStations.get(stopStationIndex).getDepatureTime(),
						timeFormatter);

				if (trainDeptureTime.isBefore(userDepatureTime)) {
					continue;
				}

				departureStationIndex = stopStationIndex;

				break;

			}

			if (departureStationIndex == -1) {
				continue;
			}

			Boolean isPossible = false;

			for (int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {

				String stopStationName = stopStations.get(stopStationIndex).getStationName();

				if (!getTrainListDto.getArrivalStation().equals(stopStationName)) {
					continue;
				}

				if (stopStationIndex <= departureStationIndex) {
					break;
				}

				isPossible = true;
			}

			if (!isPossible)
				continue;

			List<Seat> seats = train.getSeats();
			int countEmptySeat = 0;
			for (Seat seat : seats) {
				if (!seat.isSeatStatus()) {
					countEmptySeat++;
				}
			}

			if (countEmptySeat < getTrainListDto.getNumberOfPeople()) {
				continue;
			}
			possibleTrains.add(train);

		}
		return possibleTrains;

	}

//	좌석을 예약하고 예약정보를 반환하는 프로세스
	
	public ReservationInfo postReservation(PostReservationDto postReservationDto, GetTrainListDto getTrainListDto) {
		
		Train train = null;
		
		for(Train item : trains) {
		
			
			if(postReservationDto.getInputTrainNumber().equals(item.getTrainNumber())) {
				train = item;
				break;
			}
		}
		
			if(train == null) {
				System.out.println("존재하지 않는 열차번호입니다");
				return null;
			}
			
		
			
			boolean designationState = true;
			List<Seat> seats = train.getSeats();
			List<String> inputSeatNumbers = postReservationDto.getSeats();
			
			for(int i = 0 ; i<seats.size() ; i++) {
				Seat seat = seats.get(i);
				for(String seatNumber : inputSeatNumbers) {
					if(!seat.getSeatNumber().equals(seatNumber)) continue;
					if(seat.isSeatStatus()) {
						designationState = false;
						break;
					}
					seat.setSeatStatus(true);
					break;
				}
				if(!designationState) break;
			}
			
			if(!designationState) {
				System.out.println("좌석배정에 실패했습니다.");
				return null;
			}
			
//			가격계산 
			
			int totalCost = 0;
			
			for(Cost costItem : costs) {
				
				boolean isSameDepatureStation = getTrainListDto.isEqualDapartureStation(costItem.getDepatureStation());
				boolean isSameArrivalStation = getTrainListDto.isEqualArrivalStation(costItem.getArrivalStation());
				
				if(!isSameDepatureStation && !isSameArrivalStation) {
					continue;
				}
				
				totalCost = costItem.getCost() * getTrainListDto.getNumberOfPeople();
				
			}
			
			String departureTime ="";
			String arrivalTime ="";
			
			for(StopStation stopStation: train.getStopStations()) {
				
				boolean isEqualDepartureStation =
						getTrainListDto.isEqualDapartureStation(stopStation.getStationName());
				
				boolean isEqualArrivalStation = 
						getTrainListDto.isEqualArrivalStation(stopStation.getArrivalTime());
				
				if(isEqualDepartureStation) departureTime = stopStation.getDepatureTime();
				if(isEqualArrivalStation) arrivalTime = stopStation.getArrivalTime();
			}
			
		
			ReservationInfo reservationInfo = new ReservationInfo(
					postReservationDto.getInputTrainNumber(),
					postReservationDto.getSeats(),
					getTrainListDto.getDepartureStaion(),
					getTrainListDto.getDepartureTime(),
					getTrainListDto.getArrivalStation(),
					train.getArrivalTime(),
					totalCost
					
					);
			
			reservationInfos.add(reservationInfo);
			return reservationInfo;
		}
		
		
		public ReservationInfo getReservation(GetReservationDto dto) {
			
			ReservationInfo reservationInfo = null;
			String reservationNumber = dto.getReservationNumber();
			
			for(ReservationInfo item : reservationInfos) {
				
				boolean isEqualReservationNumber =
						reservationNumber.equals(item.getReservationNumber());
				if(!isEqualReservationNumber) continue;
				
				reservationInfo = item;
				return null;
			}
			return reservationInfo;
	
		}
		

	

	private static void initData() {
		
		costs.add(new Cost("부산역", "서울역", 30000));
		costs.add(new Cost("부산역", "대전역", 20000));
		costs.add(new Cost("부산역", "대구역", 10000));
		costs.add(new Cost("대구역", "서울역", 20000));
		costs.add(new Cost("대구역", "대전역", 10000));
		costs.add(new Cost("대전역", "서울역", 10000));

		costs.add(new Cost("서울역", "부산역", 30000));
		costs.add(new Cost("서울역", "대구역", 20000));
		costs.add(new Cost("서울역", "대전역", 10000));
		costs.add(new Cost("대전역", "부산역", 20000));
		costs.add(new Cost("대전역", "대구역", 10000));
		costs.add(new Cost("대구역", "부산역", 10000));
		
		// 열차의 리스트
		List<StopStation> stopStations = new ArrayList(); // 첫번째 열차 생성을 위한 정차역 리스트
		List<Seat> seats = new ArrayList(); // 첫번재 열차 생성을 위한 좌석리스트
		Train train ;
		stopStations = new ArrayList(); // 두번째 열차 생성을 위한 정차역 리스트
		stopStations.add(new StopStation("서울역", "06:00", "06:00"));
		stopStations.add(new StopStation("대전역", "06:45", "07:00"));
		stopStations.add(new StopStation("대구역", "07:45", "08:00"));
		stopStations.add(new StopStation("부산역", "09:00", "09:00"));

		seats.add(new Seat(1, "A1", false));
		seats.add(new Seat(1, "B1", false));
		seats.add(new Seat(1, "A2", false));
		seats.add(new Seat(1, "B2", false));
		seats.add(new Seat(2, "A1", false));
		seats.add(new Seat(2, "B1", false));
		seats.add(new Seat(2, "A2", false));
		seats.add(new Seat(2, "B2", false));

//		첫번째 기차 생성
		train = new Train("KTX101", "서울역", "06:00", "부산역", "09:00", 180, "KTX", stopStations, seats);
		trains.add(train); // 첫번째기차를 기차리스트에 추가

		stopStations = new ArrayList();

		stopStations.add(new StopStation("부산역", "09:00", "09:00"));
		stopStations.add(new StopStation("대구역", "09:45", "10:00"));
		stopStations.add(new StopStation("대전역", "10:45", "11:00"));
		stopStations.add(new StopStation("서울역", "12:00", "12:00"));

		seats = new ArrayList(); // 두번째 열차 생성을 위한 좌석 리스트

		seats.add(new Seat(1, "A1", false));
		seats.add(new Seat(1, "B1", false));
		seats.add(new Seat(1, "A2", false));
		seats.add(new Seat(1, "B2", false));
		seats.add(new Seat(2, "A1", false));
		seats.add(new Seat(2, "B1", false));
		seats.add(new Seat(2, "A2", false));
		seats.add(new Seat(2, "B2", false));

		// 두번째 기차 생성
		train = new Train("KTX102", "부산역", "09:00", "서울역", "12:00", 180, "KTX", stopStations, seats);
		trains.add(train);

	}
}
