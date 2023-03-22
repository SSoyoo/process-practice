package Board.repository;

import java.util.ArrayList;
import java.util.List;

import Board.entity.Board;

public class BoardRepository {
	
	private List<Board>boardTable= new ArrayList<>();
	
	public static int index =0 ;
	
	public Board findByBoardNumber(int boardNumber) {
		
		Board board = null;
		
		for(Board item : boardTable) {
			if(item.getBoardNumber() == boardNumber) {
				board = item;
			}
		}
		return board;
	}
	
	public Board save (Board board) {
		
		boolean isExist = false;
		
		for(int i = 0 ; i<boardTable.size() ; i++) {
			
			Board item = boardTable.get(i);
			if(item.getBoardNumber() == board.getBoardNumber()) {
				boardTable.set(i, board);
				isExist = true;
				break;
			}
		}
		
		boardTable.add(board);
		return board;
	}
	
	public List<Board> getBoardTable(){
		return boardTable;
	}
	
	public List<Board> deleteBoard(Board board){
		
		boardTable.remove(board);
		return boardTable;
		
	}
	

}
