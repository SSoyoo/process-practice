package Board.dto.request;

import lombok.Data;

@Data
public class PostBoardDto {
	
	private String title;
	private String content;
	private String boardImageUrl;
	private String WriterEmail;
	
	public boolean validData() {
		
		return 
				this.title.isBlank()||
				this.content.isBlank();
	}
	
	public boolean auth() {
		
		boolean result = this.WriterEmail.isBlank();
		return result;
	}


}
