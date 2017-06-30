package com.javaAcademy.tictactoe.model;

import com.javaAcademy.tictactoe.config.PlayerCharacters;
import com.javaAcademy.tictactoe.exceptions.IllegalMoveException;
import com.javaAcademy.tictactoe.exceptions.PositionOccupiedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by patrycja on 29.06.17.
 */
public class Board {
    private Map<Integer,String> board = new HashMap<Integer, String>();
    private int dimX;
    private int dimY;
    private int fieldsNo;

    public Board() {
        this.dimX = 3;
        this.dimY = 3;
        this.fieldsNo = dimX * dimY;
        clearBoard();
    }

    public Board(int dimX, int dimY) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.fieldsNo = dimX * dimY;
        clearBoard();
    }

    private void clearBoard() {
        board.clear();
        for (int i = 0; i<fieldsNo; i++){
            board.put(i,String.valueOf(i));
        }
    }

    public void printBoard() {
        for (int i = 0; i< dimX; i++){
            for (int j = 0; j< dimY; j++){
                System.out.print(board.get(i*dimY + j));
                System.out.print('\t');
            }
            System.out.println();
        }
    }

    public void addMove(int position, String character) throws IllegalMoveException, PositionOccupiedException {
        checkIfMoveIsLegal(position);
        checkIfPositionIsEmpty(position);
        board.put(position,character);
    }

    private void checkIfPositionIsEmpty(int position) throws PositionOccupiedException {
        if(PlayerCharacters.CHARS.contains(board.get(position))){
            throw new PositionOccupiedException("This position is occupied");
        }
    }

    private void checkIfMoveIsLegal(int position) throws IllegalMoveException {
        if(board.containsKey(position)){
            return;
        }
        throw new IllegalMoveException("This move is out of board");
    }

    public List<Integer> getFieldsByChar(String character) {
        return this.board.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), character))
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean checkIfBoardFull(){
        for (String field: board.values()){
            if(PlayerCharacters.CHARS.contains(field)){
                continue;
            }
            //other character than player char
            return false;
        }
        return true;
    }

}
