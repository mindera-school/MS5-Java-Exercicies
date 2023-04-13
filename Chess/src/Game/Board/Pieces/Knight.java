package Game.Board.Pieces;

import Game.Game;

public class Knight extends Piece {
    public Knight(String icon) {
        super("Knight", icon, 3);
    }

    public static Knight createWhiteKnight() {
        return new Knight("♘");
    }

    public static Knight createBlackKnight() {
        return new Knight("♞");
    }

    public boolean movePiece(int vertical, int horizontal) {

            int currentVertical = Board.getVertical(this);
            int currentHorizontal = Board.getHorizontal(this);

            if (vertical == currentVertical - 2 && horizontal == currentHorizontal - 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical - 1 && horizontal == currentHorizontal - 2) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical + 1 && horizontal == currentHorizontal - 2) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical + 2 && horizontal == currentHorizontal - 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical + 2 && horizontal == currentHorizontal + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical + 1 && horizontal == currentHorizontal + 2) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical - 1 && horizontal == currentHorizontal + 2) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            if (vertical == currentVertical - 2 && horizontal == currentHorizontal + 1) {
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
            System.out.println("Illegal move!");
            return false;
    }


}
