package Board.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchBoardDto {
	
	private int boardNumber;
	private String title;
	private String content;
	private String boardImageUrl;
	private String email;

	
	public boolean validData() { 
		return
			this.title.isBlank()||
			this.content.isBlank();
	}
	
	public boolean auth() {
		return this.email.isBlank();
	}
}
