package trainReservation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Cost {
	
	private String depatureStation;
	private String arrivalStation;
	private int cost;

}
