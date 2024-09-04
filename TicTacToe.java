package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        //printBoard(board);
        // 1) How are we going to place the elements;
        // 2) Current player be like X and O
        // 3) Winning Situation - All items fill in the diagonal
        // 4) Where you want to play the other move
        // 5) Non-Winning Situations

        char player = 'X';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameover) {
            printBoard(board);
            System.out.print("Player " + player + " Enter : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameover = haveWon(board, player);
                if (gameover) {
                    System.out.println("Player " + player + " has won. ");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Move");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char[][] board, char player) {
         //check rows
        for (int row = 0; row < board.length; row++) {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
                return true;
            }
        }
        //check columns
        for (int columns = 0; columns < board.length; columns++) {
            if(board[0][columns]==player && board[1][columns]==player && board[2][columns]==player) {
                return true;
            }
        }

        //check diagonals
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

    private static void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

}
