package com.example.tictactoeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicTacToeController {
	
	@Autowired
	private GameService service;
	
	@RequestMapping("/")
    public ResponseEntity<?> play(@RequestParam(value="board", required=true) String board) {
        if(service.isBoardValid(board.toLowerCase())){
        	String returnBoard = service.addMove(board.toLowerCase());
        	return new ResponseEntity<>(returnBoard,HttpStatus.OK);
        }else{
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
