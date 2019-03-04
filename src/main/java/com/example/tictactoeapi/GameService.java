package com.example.tictactoeapi;

import org.springframework.stereotype.Component;

@Component
public class GameService {
	
	long countX;
	long countO;
	long countSpaces;
	
	
	public Boolean isBoardValid(String board){
		countX = board.chars().filter(num -> num == 'x').count();
		countO = board.chars().filter(num -> num == 'o').count();
		countSpaces = board.chars().filter(num -> num == ' ').count();
		
		if(correctSizeAndCharacters(board) && validGameBeingPlayed(board)){
			return true;
		}
		return false;
	}

	public String addMove(String board) {
		int space = board.indexOf(' ');
		StringBuilder updatedBoard = new StringBuilder(board);
		if(space > -1){
			updatedBoard.setCharAt(space, 'o');
		 return updatedBoard.toString();
		} 
		return board + "o";
	}
	
	private Boolean correctSizeAndCharacters(String board){
		if(board.length() <= 9 && board.length() == countX+countO+countSpaces){
			return true;
		}
		return false;
	}
	
	private Boolean validGameBeingPlayed(String board){
		if (countX == countO || countX == countO+1){
			return true;
		}
		return false;
	}
	
}
