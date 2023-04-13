package Game.Board.Pieces;

public class Rook extends Piece {

    public Rook(String icon) {
        super("Rook", icon, 5);
    }

    public static Rook createWhiteRook() {
        return new Rook("♖");
    }

    public static Rook createBlackRook() {
        return new Rook("♜");
    }

    @Override
    public boolean movePiece(int vertical, int horizontal) {
        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        //check vertical up
        if (horizontal == currentHorizontal && vertical < currentVertical) {
        for (int i = currentVertical - 1; i > vertical; i--) {
            if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return false;
            }
        }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return  true;
        }

        //check vertical down
        if (vertical > currentVertical && horizontal == currentHorizontal) {
        for (int i=currentVertical +1; i < vertical ; i++) {
            if (Board.getBoard()[i][currentHorizontal].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return false;
            }
        }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }


        //check horizontal right
        if (vertical == currentVertical && currentHorizontal < horizontal) {
        for (int i = currentHorizontal + 1; i < horizontal; i++) {
            if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return false;
            }
        }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }

        //check horizontal left
        if (vertical == currentVertical && currentHorizontal > horizontal) {
        for (int i = currentHorizontal - 1; i > horizontal; i--) {
            if (Board.getBoard()[currentVertical][i].getPiece() != null) {
                System.out.println("There is something blocking the path!");
                return false;
            }
        }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
             return true;
        }

        System.out.println("Illegal move!");
        return false;
    }
}
