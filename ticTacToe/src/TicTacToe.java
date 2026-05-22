import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerMoves = new ArrayList<>();
    static ArrayList<Integer> computerMoves = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(board);

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            while (true) {
                System.out.print("Enter your move (1-9): ");
                int playerPos = sc.nextInt();
                while (playerPos < 1 || playerPos > 9) {
                    System.out.print("Enter a valid move (1-9): ");
                    playerPos = sc.nextInt();
                }

                while (playerMoves.contains(playerPos) || computerMoves.contains(playerPos)) {
                    System.out.print("Invalid move. Try again: ");
                    playerPos = sc.nextInt();
                }

                changeCell(playerPos, board, Player.PLAYER);
                String msg = checkWinner();
                if (!msg.isEmpty()) {
                    System.out.println(msg);
                    break;
                }

                int compPos = random.nextInt(1, 10);
                while (playerMoves.contains(compPos) || computerMoves.contains(compPos)) {
                    compPos = random.nextInt(1, 10);
                }

                changeCell(compPos, board, Player.COMPUTER);

                printBoard(board);
                msg = checkWinner();
                if (!msg.isEmpty()) {
                    System.out.println(msg);
                    break;
                }
            }
            printBoard(board);

            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = sc.next().toLowerCase();

            if (playAgain.equalsIgnoreCase("y")) {
                resetBoard(board);
                printBoard(board);
            } else {
                System.out.println("Thanks for playing!");
                break;
            }
        }
        sc.close();
    }

    public enum Player {
        PLAYER, COMPUTER
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void changeCell(int pos, char[][] board, Player currentUser) {
        char symbol = ' ';

        if (currentUser.equals(Player.PLAYER)) {
            symbol = 'X';
            playerMoves.add(pos);
        } else if (currentUser.equals(Player.COMPUTER)) {
            symbol = 'O';
            computerMoves.add(pos);
        }

        switch (pos) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }
    }

    public static List<List<Integer>> winPatterns() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> leftCross = Arrays.asList(3, 5, 7);
        List<Integer> rightCross = Arrays.asList(1, 5, 9);

        return Arrays.asList(topRow, midRow, botRow, leftCol, midCol, rightCol, leftCross, rightCross);
    }

    public static String checkWinner() {
        List<List<Integer>> winningCombinations = winPatterns();

        for (List<Integer> combination : winningCombinations) {
            if (playerMoves.containsAll(combination)) {
                return "You won!";
            } else if (computerMoves.containsAll(combination)) {
                return "Computer won!";
            }
        }

        if (playerMoves.size() + computerMoves.size() == 9) {
            return "It's a draw!";
        }
        return "";
    }

    public static void resetBoard(char[][] board) {
        playerMoves.clear();
        computerMoves.clear();

        char[][] blank = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        for (int i = 0; i < board.length; i++) {
            board[i] = blank[i].clone();
        }
    }
}