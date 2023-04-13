package Game;

import Game.Board.Pieces.Board;
import Game.Board.Pieces.Piece;
import Game.Player.Player;
import Menu.Menu;
import User.LogIn;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static Player whitePlayer;
    private static Player blackPlayer;

    public static Player gameScript() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\033[0;37m" + "White Player: " + "\033[39m" + "\033[49m");
        while (true) {
            try {
                Game.setWhitePlayer(new Player(LogIn.loginProcedure()));
                if (Game.getWhitePlayer().getUser() != null) {
                    break;
                }
                System.out.println("\033[0;31m" + "You need to create an account first if you haven't yet!" + "\033[39m" + "\033[49m" + "\033[0;36m" + " Go back to menu?(Y/N)" + "\033[39m" + "\033[49m");
                if (scanner.next().equals("Y")) {
                    Menu.mainMenu();
                }
            } catch (java.io.IOException e) {
                System.out.println("Couldn't login :(");
            }
        }
        System.out.println("\033[0;37m" + "Black Player" + "\033[39m" + "\033[49m");
        while (true) {
            try {
                Game.setBlackPlayer(new Player(LogIn.loginProcedure()));
                if (Game.getBlackPlayer().getUser() != null) {
                    break;
                }
                System.out.println("\033[0;31m" + "You need to create an account first if you haven't yet!" + "\033[39m" + "\033[49m" + "\033[0;36m" + " Go back to menu?(Y/N)" + "\033[39m" + "\033[49m");
                if (scanner.next().equals("Y")) {
                    Menu.mainMenu();
                }
            } catch (java.io.IOException e) {
                System.out.println("Couldn't login :(");
            }
        }
        if (Game.getWhitePlayer().getUser().getUserName().equals(Game.getBlackPlayer().getUser().getUserName())) {
            System.out.println("You can't play against yourself!");
            gameScript();
        }
        Board.createBoard();
        Board.printBoard();
        Player winner = null;
        while (true) {
            while (true) {
                if (play(whitePlayer)) {
                    break;
                }
            }
            Board.printBoard();
            if (endGame() != null) {
                winner = endGame();
                break;
            }

            while (true) {
                if (play(blackPlayer)) {
                    break;
                }
            }
            Board.printBoard();
            if (endGame() != null) {
                winner = endGame();
                break;
            }
        }
        System.out.println("\n" +
                " ██╗       ██╗██╗███╗  ██╗███╗  ██╗███████╗██████╗ \n" +
                " ██║  ██╗  ██║██║████╗ ██║████╗ ██║██╔════╝██╔══██╗\n" +
                " ╚██╗████╗██╔╝██║██╔██╗██║██╔██╗██║█████╗  ██████╔╝\n" +
                "  ████╔═████║ ██║██║╚████║██║╚████║██╔══╝  ██╔══██╗\n" +
                "  ╚██╔╝ ╚██╔╝ ██║██║ ╚███║██║ ╚███║███████╗██║  ██║\n" +
                "   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚══╝╚══════╝╚═╝  ╚═╝");
        System.out.println(winner.getUser().getUserName());
        Player loser = null;
        if (winner.equals(Game.getWhitePlayer())) {
            loser = Game.getBlackPlayer();
        } else {
            loser = Game.getWhitePlayer();
        }
        try {
            updatePoints(winner, loser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return winner;
    }

    public static void updatePoints(Player playerWinner, Player playerLoser) throws IOException {
        int indexWinner = 0;
        int indexLoser = 0;
        File file = new File("src/User/File/Names");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        String userNameWinner = playerWinner.getUser().getUserName();
        String userNameLoser = playerLoser.getUser().getUserName();
        String[] allfile = new String[20];
        for (int i = 0; br.readLine() != null; i++) {
            line = br.readLine();
            allfile[i] = line;
        }

        for (int i = 0; i < allfile.length; i++) {
            if (allfile[i].contains(userNameWinner)) {
                String[] rightLine = allfile[i].split("\s");
                String points = String.valueOf(Integer.parseInt(rightLine[5]) + counterPointsWinner(playerWinner));
                rightLine[5] = points;
                String updatedLine = Arrays.toString(rightLine);
                allfile[i] = updatedLine.substring(1, updatedLine.length() - 1);
                indexWinner = i;
                break;
            }
        }

        for (int i = 0; i < allfile.length; i++) {
            if (allfile[i].contains(userNameLoser)) {
                String[] rightLine = allfile[i].split("\s");
                String points = String.valueOf(Integer.parseInt(rightLine[5]) + counterPointsLoser(playerLoser));
                rightLine[5] = points;
                String updatedLine = Arrays.toString(rightLine);
                allfile[i] = updatedLine.substring(1, updatedLine.length() - 1);
                indexLoser = i;
                break;
            }
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        allfile[indexWinner] = allfile[indexWinner].replaceAll(",", "");
        allfile[indexLoser] = allfile[indexLoser].replaceAll(",", "");

        bufferedWriter.write(".\n");
        for (String s : allfile) {
            if (s == null) {
                break;
            }
            bufferedWriter.write("\n");
            bufferedWriter.write(s);
            bufferedWriter.write("\n");
        }
        bufferedWriter.close();
    }


    public static int counterPointsWinner(Player player) {

        return 500 + player.getPoints() * (-(player.getMoves() * 2));
    }

    public static int counterPointsLoser(Player player) {

        return 200 + player.getPoints() * (-(player.getMoves() * 2));
    }

    public static boolean play(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("From: ");
        String choiceFrom = scanner.next();
        if (choiceFrom.length() != 2) {
            System.out.println("\033[0;31m" + "Not a valid coordinate" + "\033[39m" + "\033[49m");
            return false;
        }
        if(Board.letterToInt(choiceFrom.substring(0, 1)) < 0 || Board.letterToInt(choiceFrom.substring(0, 1)) > 7 ){
            System.out.println("Letter doesn't exist");
            return false;
        }
        if((Integer.parseInt(choiceFrom.substring(1, 2)) - 1) < 0 || (Integer.parseInt(choiceFrom.substring(1, 2)) - 1) > 7){
            System.out.println("Number doesn't exist");
            return false;
        }
        Piece pieceToMove = Board.getBoard()[Board.letterToInt(choiceFrom.substring(0, 1))][Integer.parseInt(choiceFrom.substring(1, 2)) - 1].getPiece();
        if (player.getPlayerPieces().contains(pieceToMove)) {
            System.out.print("To: ");
            String choiceTo = scanner.next();
            if (choiceTo.length() != 2) {
                System.out.println("\033[0;31m" + "Not a valid coordinate" + "\033[39m" + "\033[49m");
                return false;
            }
            Piece pieceToCapture = Board.getBoard()[Board.letterToInt(choiceTo.substring(0, 1))][Integer.parseInt(choiceTo.substring(1, 2)) - 1].getPiece();
            if (pieceToMove.checkCapturePiece(pieceToCapture) || pieceToCapture == null) {
                if (pieceToMove.movePiece(Board.letterToInt(choiceTo.substring(0, 1)), Integer.parseInt(choiceTo.substring(1, 2)) - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            System.out.println("\033[0;31m" + "No piece of yours in that coordinate" + "\033[39m" + "\033[49m");
        }
        return false;
    }


    public static Player getWhitePlayer() {
        return whitePlayer;
    }

    public static Player getBlackPlayer() {
        return blackPlayer;
    }


    public static void setWhitePlayer(Player player) {
        whitePlayer = player;
    }

    public static void setBlackPlayer(Player player) {
        blackPlayer = player;
    }

    public static Player endGame() {
        for (int i = 0; i < getWhitePlayer().getCapturedPieces().size(); i++) {
            if (getWhitePlayer().getCapturedPieces().get(i).getName().equals("King")) {
                return whitePlayer;
            }
        }
        for (int i = 0; i < getBlackPlayer().getCapturedPieces().size(); i++) {
            if (getBlackPlayer().getCapturedPieces().get(i).getName().equals("King")) {
                return blackPlayer;
            }
        }
        return null;
    }

}
