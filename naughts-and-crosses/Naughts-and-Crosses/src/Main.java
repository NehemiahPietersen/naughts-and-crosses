import java.util.Random;
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

        Scanner scan = new Scanner(System.in);
        System.out.println("Pick your option.'0' or 'X' <<remember '0' goes first>>");
        // todo add option for user to pick naught or cross
        System.out.println("Enter your position: (from 1-9)");
        int userInput = scan.nextInt();

        placePieces(gameBoard, userInput, "player");

        Random random = new Random();
        int cpuInput = random.nextInt(9) + 1;
        placePieces(gameBoard, cpuInput, "cpu");
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

    public static void placePieces(char[][] gameBoard, int userInput, String user) {
        char symbol = 'x';

        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = '0';
        }

        switch (userInput) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}