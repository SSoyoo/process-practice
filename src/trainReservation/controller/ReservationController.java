package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

public class ReservationController {

	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	private ReservationService reservationService;

	private GetTrainListDto getTrainListDto;
	private GetReservationDto getReservationDto;
	private PostReservationDto postReservationDto;

	public ReservationController() {

		reservationService = new ReservationService();

	}

	public void reservation() {

		while (true) {

			getTrainListDto = new GetTrainListDto();
			LocalTime departureTime = null;

			if (getTrainListDto.isEmpty()) {
				System.out.println("모두 입력하세요");
				continue;
			}
			try {
				departureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeFormatter);
			} catch (Exception excption) {
				System.out.println("'시간:분' 을 'HH:mm' 형식으로 입력하세요");
				continue;

			}

			if (getTrainListDto.getNumberOfPeople() <= 0) {
				System.out.println("인원을 정확히 입력하세요");
				continue;
			}

			if (getTrainListDto.isSameStation()) {
				System.out.println("출발역과 도착역이 같습니다.");
				continue;
			}

			List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto);
			System.out.println(possibleTrains);

			postReservation();
			break;

		}

	}

	public void postReservation() {

		while (true) {

			postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
			
			ReservationInfo reservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
			if(reservationInfo == null) continue;
			
			System.out.println(reservationInfo);
			break;
		}
	}
	public void getReservation() {
		while(true) {
			getReservationDto = new GetReservationDto();
			String reservationNumber = getReservationDto.getReservationNumber();
			if(reservationNumber.isBlank()) {
				System.out.println("예약번호를 입력하세요");
				continue;
			}
			ReservationInfo reservationInfo = reservationService.getReservation(getReservationDto);
			String message =
					reservationInfo == null ? "해당하는 예약번호가 없습니다"
											: reservationInfo.toString();
		}
		}
	}
	

	
	
	

