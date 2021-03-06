# TicTacToe

# About
This project is Tic-tac-toe game (also known as noughts and crosses or Xs and Os) for two players.
Each player has its own character: X or O and places it on the board in empty cell.
The player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
When board is full and there is no winner - there is a draw.

# How to run the game
    1. To execute: mvn exec:java -Dexec.mainClass="com.javaAcademy.tictactoe.Main"
    2. To test: mvn test 

# Requirements list

    +1. It is "best of three", though I can quit mid-way through.
    +2. Characters: O (naught) and X (cross)
    +3. Players have names and scores.
    +4. Winner has better score.
    +4a. Draw is possible.
        Interactive:
    +5. it should accept players instructions about each move
    +6. it should ask who begins
    +7. it informs about session result,
    +7a. who’s turn it is now
    +8. Match gives points: win 3, draw 1, loss 0.
    +8a. 3 matches == game.
    +9. Game works with square or rectangular board.
    +10. Player wins, if he has unbroken line of his characters, in a row, in a column or diagonally.
    +/-11. Winning is announced in a message: Wygrywa O. O: 1 X: 0 (numbers are current points).
        Game is configurable:
    +12. Board dimensions: 3x3, 4x4, 99x101, etc. (user provides)
    +13. Winning condition has variable number of characters: 3, 4, 5, etc. (user provides)
    14. Game messages should have configurable target: console (System.out) or logs (for the sake of this exercise it’s OK to make it System.err), or external printer.
    +15. before game starts it asks who goes first, O or X
    16. We are bi-lingual: Polish and English are fine. In future we want to add more languages: messages are to be read from a file for chosen language. Choosing the language depends on configuration variable.

# TO DO list
    
	- testy
	- możliwe przerwanie gry dla parametru q
	- refactoring !!!! lepszy podział obowiązków między klasy
	- sprawdzenie przyjmowanych parametrów
	- poprawa wydajności sprawdzenia wygranej(możliwa zmiana implementacji areny do mapy)
	- internacjolizacja(czytanie i obsługa wszystkich parametrów)
	- obsługa tury - przyda się przy sieciowej wersji
	- wersja sieciowa
	- obsługa wyjątków

# For review & questions & doubts

