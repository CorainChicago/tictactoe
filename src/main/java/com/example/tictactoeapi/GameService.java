package com.example.tictactoeapi;

import org.springframework.stereotype.Component;

@Component
public class GameService {
	
	public Boolean isBoardValid(String board){
		if(board.length() > 0 && board.length() != 9){
			return false;
		}
		long countX = board.chars().filter(num -> num == 'x').count();
		long countO = board.chars().filter(num -> num == 'o').count();
		long countSpace = board.chars().filter(num -> num == ' ').count();
		
		long totalCount = countX+countO+countSpace;
		if(totalCount == 0 ||(countSpace > 0 && (countX == countO || countX == countO +1)) ){
			return true;
		}
		return false;
	}

	public String addMove(String board) {
		int space = board.indexOf(' ');
		StringBuilder updatedBoard = new StringBuilder(board);
		if(space > -1){
			updatedBoard .setCharAt(space, 'o');
		 return updatedBoard.toString();
		}
		return "    o    ";
	}
	
}
