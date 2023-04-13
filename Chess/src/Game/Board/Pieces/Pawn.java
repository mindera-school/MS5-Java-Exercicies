package Game.Board.Pieces;


import Game.Game;
import Game.Player.Player;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Pawn extends Piece {

    private boolean isFirstMove = true;

    public Pawn(String icon) {
        super("Pawn", icon, 1);
    }

    public static Pawn createWhitePawn() {
        return new Pawn("♙");
    }

    public static Pawn createBlackPawn() {
        return new Pawn("♟");
    }

    @Override
    public boolean movePiece(int vertical, int horizontal) {
        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (Board.getBoard()[vertical][horizontal].getPiece() == null) {
            if (isFirstMove) {
                if (Game.getWhitePlayer().getPlayerPieces().contains(this)) {
                    if (vertical == currentVertical - 2) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                    if (vertical == currentVertical - 1) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                } else {
                    if (vertical == currentVertical + 2 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                    if (vertical == currentVertical + 1 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        isFirstMove = false;
                        return true;
                    }
                }
            } else {
                if (Game.getWhitePlayer().getPlayerPieces().contains(this)) {
                    if(vertical == 0) {
                        Board.movePiece(this, horizontal, vertical);
                        Board.getBoard()[vertical][horizontal].setPiece(exchangePiece());
                        return true;
                    }
                    if (vertical == currentVertical - 1 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        return true;
                    }
                }
                if (Game.getBlackPlayer().getPlayerPieces().contains(this)) {
                    if(vertical == 7) {
                        Board.movePiece(this, horizontal, vertical);
                        Board.getBoard()[vertical][horizontal].setPiece(exchangePiece());
                        return true;
                    }
                    if (vertical == currentVertical + 1 && currentHorizontal == horizontal) {
                        Board.movePiece(this, horizontal, vertical);
                        return true;
                    }
                }
            }
            }
        if (Board.getBoard()[vertical][horizontal].getPiece() != null) {
            if (Math.abs(currentVertical - vertical) == 1 && Math.abs(currentHorizontal - horizontal) == 1 && Math.abs(currentVertical - vertical) == Math.abs(currentHorizontal - horizontal)) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                if(vertical == 0 || vertical == 7) {
                    Board.getBoard()[vertical][horizontal].setPiece(exchangePiece());
                }
                return true;
            }

            return true;
        }
        System.out.println("Illegal move!");
        return false;
    }


    public Piece exchangePiece(){
            Player ownTeam = null;
            Player otherTeam = null;
            Piece promotedPiece = null;
            while (true) {
                if (Game.getWhitePlayer().getPlayerPieces().contains(this)) {
                    ownTeam = Game.getWhitePlayer();
                    otherTeam = Game.getBlackPlayer();
                } else {
                    ownTeam = Game.getBlackPlayer();
                    otherTeam = Game.getWhitePlayer();
                }
                Scanner scanner = new Scanner(System.in);

                System.out.println("What piece you want to promote to?: ");
                String pieceName = scanner.next();
                try {
                    promotedPiece = otherTeam.getCapturedPieces().stream().filter(e -> e.getName().equals(pieceName)).findFirst().get();
                    System.out.println(promotedPiece.getIcon());
                    ownTeam.getPlayerPieces().add(promotedPiece);
                    otherTeam.getCapturedPieces().remove(promotedPiece);
                    break;
                }catch ( NoSuchElementException e){
                    System.out.println("Piece hasn't been captured yet. Choose another piece!");
                }
            }
            return promotedPiece;
    }
}
