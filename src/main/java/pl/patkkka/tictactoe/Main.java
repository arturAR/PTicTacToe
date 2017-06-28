package pl.patkkka.tictactoe;

import java.util.Scanner;

/**
 * Created by patrycja on 28.06.17.
 */
public class Main {
    public static void main(String[] args) {
        char[] players = {'X','O'};

        Scanner s = new Scanner(System.in);
        System.out.println("Who goes first? (X or O)");
        String input = s.nextLine();
        char firstPlayer = input.charAt(0);

        //creating board
        //TODO - configurable dimensions
        char [][] board = new char[3][3];

        System.out.println("Please insert row and column values, " +
                "where you want to put your character (separated by space) and press Enter");
        int x = s.nextInt();
        int y = s.nextInt();

        board[x][y] = firstPlayer;

        for (int i=0; i < board.length; i++){
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] == '\u0000'){
                    System.out.print("-");
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }

        //TODO - more actions than first possible
    }
}
