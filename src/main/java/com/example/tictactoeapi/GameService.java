package com.example.tictactoeapi;

import org.springframework.stereotype.Component;

@Component
public class GameService {

	long countX;
	long countO;
	long countSpaces;

	public Boolean isBoardValid(String board) {
		countX = board.chars().filter(num -> num == 'x').count();
		countO = board.chars().filter(num -> num == 'o').count();
		countSpaces = board.chars().filter(num -> num == ' ').count();

		if (correctSizeAndCharacterTypes(board) && validGameBeingPlayed(board) && noOneWon(board)) {
			return true;
		}
		return false;
	}

	private boolean noOneWon(String board) {
		// check if 3 across is one type of character
		for (int i = 0; i < board.length(); i = i + 3) {
			if (board.charAt(i) == (board.charAt(i + 1)) && board.charAt(i + 1) == (board.charAt(i + 2))) {
				return false;
			}
		}
		// 3 down
		for (int i = 0; i < 3; i = i++) {
			if (board.charAt(i) == (board.charAt(i + 3)) && board.charAt(i + 3) == (board.charAt(i + 6))) {
				return false;
			}
		}

		if (board.charAt(0) == (board.charAt(4)) && board.charAt(4) == (board.charAt(8))) {
			return false;
		}

		if (board.charAt(2) == (board.charAt(4)) && board.charAt(4) == (board.charAt(6))) {
			return false;
		}

		return false;
	}

	public String addMove(String board) {
		int space = board.indexOf(' ');
		StringBuilder updatedBoard = new StringBuilder(board);
		if (space > -1) {
			updatedBoard.setCharAt(space, 'o');
			return updatedBoard.toString();
		}
		return board + "o";
	}

	private Boolean correctSizeAndCharacterTypes(String board) {
		if (board.length() <= 9 && board.length() == countX + countO + countSpaces) {
			return true;
		}
		return false;
	}

	private Boolean validGameBeingPlayed(String board) {
		if (countO + countX < 9 && (countX == countO || countX == countO + 1)) {
			return true;
		}
		return false;
	}

}
