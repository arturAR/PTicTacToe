package pl.patkkka;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.patkkka.tictactoe.Board;
import pl.patkkka.tictactoe.exceptions.IllegalMoveException;
import pl.patkkka.tictactoe.exceptions.PositionOccupiedException;

/**
 * Created by patrycja on 29.06.17.
 */
@Test
public class BoardTest {
    Board b;

//    @Test
//    public void printBoardTest(){
//        Board b = new Board(4,3);
//        b.printBoard();
//    }

    @BeforeMethod
    public void beforeActions(){
        this.b = new Board(4,3);
    }

//    @Test
//    public void addLegalMoveTest(){
//
//        try {
//            b.addMove(4,"X");
//        } catch (IllegalMoveException e) {
//            e.printStackTrace();
//        } catch (PositionOccupiedException e) {
//            e.printStackTrace();
//        }
//
//        b.printBoard();
//    }

    @Test(expectedExceptions = IllegalMoveException.class)
    public void addIllegalMoveTest() throws IllegalMoveException, PositionOccupiedException {
        b.addMove(13,"X");
    }

    @Test(expectedExceptions = PositionOccupiedException.class)
    public void addMoveToOccupiedFieldTest() throws IllegalMoveException, PositionOccupiedException {
        b.addMove(4,"X");
        b.addMove(4,"O");
    }

}
