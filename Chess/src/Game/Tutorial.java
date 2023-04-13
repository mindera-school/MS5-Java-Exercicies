package Game;

import Game.Board.Pieces.*;
import Menu.Menu;

import java.util.Scanner;

public class Tutorial {

    public static void showTutorial() {

        Scanner sc = new Scanner(System.in);
        System.out.println("To see the tutorial press 1");
        if (sc.nextInt() == 1) {
            pawnMovement();
            sc.nextInt();
            knightMovement();
            sc.nextInt();
            rookMovement();
            sc.nextInt();
            bishopMovement();
            sc.nextInt();
            queenMovement();
            sc.nextInt();
            kingMovement();
            System.exit(0);
        }
    }

    public static void pawnMovement() {

        Board board1 = new Board();
        board1.buildBoardSpots();
        Board.getBoard()[1][3].setPiece(Pawn.createBlackPawn());
        Board.getBoard()[1][4].setPiece(Pawn.createBlackPawn());
        Board.getBoard()[2][3] = new Spot("\u001B[44m", null);
        Board.getBoard()[2][4] = new Spot("\u001B[43m", null);
        Board.getBoard()[3][3] = new Spot("\u001B[44m", null);
        board1.printBoard();
        System.out.println("\u001B[34m" + "Movement rules:" + "\u001B[0m");
        System.out.println("If it is a pawn's first move, it can move forward one or two squares. \n" +
                "If a pawn has already moved, then it can move forward just one square at a time.");
        System.out.println();
    }

    public static void knightMovement() {

        Board board2 = new Board();
        board2.buildBoardSpots();
        Board.getBoard()[3][4].setPiece(Knight.createBlackKnight());
        Board.getBoard()[4][6] = new Spot("\u001B[42m", null);
        Board.getBoard()[5][5] = new Spot("\u001B[42m", null);
        Board.getBoard()[5][3] = new Spot("\u001B[42m", null);
        Board.getBoard()[4][2] = new Spot("\u001B[42m", null);
        Board.getBoard()[2][2] = new Spot("\u001B[42m", null);
        Board.getBoard()[1][3] = new Spot("\u001B[42m", null);
        Board.getBoard()[1][5] = new Spot("\u001B[42m", null);
        Board.getBoard()[2][6] = new Spot("\u001B[42m", null);
        board2.printBoard();
        System.out.println("\u001B[32m" + "Movement rules:" + "\u001B[0m");
        System.out.println("The knight moves in an L-shape ");
        System.out.println();
    }

    public static void rookMovement() {

        Board board3 = new Board();
        board3.buildBoardSpots();
        for (int i = 0; i <= 7; i++) {
            Board.getBoard()[3][i] = new Spot("\u001B[46m", null);
            Board.getBoard()[i][4] = new Spot("\u001B[46m", null);
        }
        Board.getBoard()[3][4] = new Spot("\u001B[47m", Rook.createBlackRook());
        board3.printBoard();
        System.out.println("\u001B[36m" + "Movement rules:" + "\u001B[0m");
        System.out.println("It can move as many squares as it likes horizontally or vertically ");
        System.out.println();
    }

    public static void bishopMovement() {

        Board board5 = new Board();
        board5.buildBoardSpots();
        Board.getBoard()[7][0] = new Spot("\u001B[41m", null);
        Board.getBoard()[6][1] = new Spot("\u001B[41m", null);
        Board.getBoard()[5][2] = new Spot("\u001B[41m", null);
        Board.getBoard()[4][3] = new Spot("\u001B[41m", null);
        Board.getBoard()[2][3] = new Spot("\u001B[41m", null);
        Board.getBoard()[1][2] = new Spot("\u001B[41m", null);
        Board.getBoard()[0][1] = new Spot("\u001B[41m", null);
        Board.getBoard()[3][4] = new Spot("\u001B[47m", Bishop.createBlackBishop());
        Board.getBoard()[0][7] = new Spot("\u001B[41m", null);
        Board.getBoard()[1][6] = new Spot("\u001B[41m", null);
        Board.getBoard()[2][5] = new Spot("\u001B[41m", null);
        Board.getBoard()[4][5] = new Spot("\u001B[41m", null);
        Board.getBoard()[5][6] = new Spot("\u001B[41m", null);
        Board.getBoard()[6][7] = new Spot("\u001B[41m", null);
        Board.getBoard()[0][1] = new Spot("\u001B[41m", null);
        board5.printBoard();
        System.out.println("\u001B[31m" + "Movement rules:" + "\u001B[0m");
        System.out.println("A bishop can move diagonally as many squares as it likes.");
        System.out.println();
    }

    public static void queenMovement() {

        Board board3 = new Board();
        board3.buildBoardSpots();
        for (int i = 0; i <= 7; i++) {
            Board.getBoard()[3][i] = new Spot("\u001B[43m", null);
            Board.getBoard()[i][4] = new Spot("\u001B[43m", null);
        }
        Board.getBoard()[3][4] = new Spot("\u001B[47m", Queen.createBlackQueen());
        Board.getBoard()[7][0] = new Spot("\u001B[43m", null);
        Board.getBoard()[6][1] = new Spot("\u001B[43m", null);
        Board.getBoard()[5][2] = new Spot("\u001B[43m", null);
        Board.getBoard()[4][3] = new Spot("\u001B[43m", null);
        Board.getBoard()[2][3] = new Spot("\u001B[43m", null);
        Board.getBoard()[1][2] = new Spot("\u001B[43m", null);
        Board.getBoard()[0][1] = new Spot("\u001B[43m", null);
        Board.getBoard()[0][7] = new Spot("\u001B[43m", null);
        Board.getBoard()[1][6] = new Spot("\u001B[43m", null);
        Board.getBoard()[2][5] = new Spot("\u001B[43m", null);
        Board.getBoard()[4][5] = new Spot("\u001B[43m", null);
        Board.getBoard()[5][6] = new Spot("\u001B[43m", null);
        Board.getBoard()[6][7] = new Spot("\u001B[43m", null);
        Board.getBoard()[0][1] = new Spot("\u001B[43m", null);
        board3.printBoard();
        System.out.println("\u001B[33m" + "Movement rules:" + "\u001B[0m");
        System.out.println("It can move as many squares as it likes horizontally, vertically or diagonally");
        System.out.println();
    }

    public static void kingMovement() {

        Board board3 = new Board();
        board3.buildBoardSpots();
        Board.getBoard()[3][4] = new Spot("\u001B[47m", King.createBlackKing());
        for (int i = 3; i <= 5; i++) {
            Board.getBoard()[4][i] = new Spot("\u001B[45m", null);
            Board.getBoard()[2][i] = new Spot("\u001B[45m", null);
        }
        Board.getBoard()[3][3] = new Spot("\u001B[45m", null);
        Board.getBoard()[3][5] = new Spot("\u001B[45m", null);
        board3.printBoard();
        System.out.println("\u001B[35m" + "Movement rules:" + "\u001B[0m");
        System.out.println("The king can only move one square in any direction");
    }
}
