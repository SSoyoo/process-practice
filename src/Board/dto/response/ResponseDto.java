package Board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto <D> {
	
	private boolean status;
	private String message;
	private D data;
	

	
	
	
}
