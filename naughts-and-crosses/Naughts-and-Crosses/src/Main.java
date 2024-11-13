import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Rows and columns
        char[][] gameBoard = {
                { ' ', '|', ' ', '|', ' ' }, // row 1
                { '-', '+', '-', '+', '-' }, // row 2
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' }
        };

        printGameBoard(gameBoard);
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}