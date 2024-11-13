import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

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

        System.out.println("Pick your option.'0' or 'X' <<remember '0' goes first>>");
        // todo add option for user to pick naught or cross

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your position: (from 1-9)");
            int userInput = scan.nextInt();

            placePieces(gameBoard, userInput, "player");

            Random random = new Random();
            int cpuInput = random.nextInt(9) + 1;
            placePieces(gameBoard, cpuInput, "cpu");
            printGameBoard(gameBoard);
            checkWinner();
        }
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

    public static String checkWinner() {
        // win conditions
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List crossLeftToRight = Arrays.asList(1, 5, 9);
        List crossRightToLeft = Arrays.asList(7, 5, 3);

        List<List> winningCondition = new ArrayList<>();
        winningCondition.add(topRow);
        winningCondition.add(midRow);
        winningCondition.add(botRow);
        winningCondition.add(leftCol);
        winningCondition.add(midCol);
        winningCondition.add(rightCol);
        winningCondition.add(crossLeftToRight);
        winningCondition.add(crossRightToLeft);

        for (List list : winningCondition) {
            if (playerPositions.containsAll(list)) {
                return "Congratulations... You have won the game!!";
            } else if (cpuPositions.containsAll(list)) {
                return "Too Bad So Sad:( CPU has won the game";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Tied game.";
            }
        }
        return "";
    }
}