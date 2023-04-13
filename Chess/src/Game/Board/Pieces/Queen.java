package Game.Board.Pieces;

public class Queen extends Piece {
    public Queen(String icon) {

        super("Queen", icon, 9);
    }

    public static Queen createWhiteQueen() {

        return new Queen("♕");
    }

    public static Queen createBlackQueen() {

        return new Queen("♛");
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


        if (!(Math.abs(currentVertical - vertical) == Math.abs(currentHorizontal - horizontal))) {
            System.out.println("Illegal movement");
            return false;
        }

        //Diagonal para o lado superior direito
        if (currentVertical - vertical == -(currentHorizontal - horizontal)) {
            int saverDiagRight = currentHorizontal + 1;
            for (int i = currentVertical - 1; i > vertical; i--) {
                if (Board.getBoard()[i][saverDiagRight].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
                saverDiagRight++;
            }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }

        //Diagonal para o lado superior esquerdo
        if (currentVertical - vertical == currentHorizontal - horizontal) {
            int saverDiagLeft = currentHorizontal - 1;
            for (int i = currentVertical - 1; i > vertical; i--) {
                if (Board.getBoard()[i][saverDiagLeft].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
                saverDiagLeft--;
            }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }

        //Diagonal para o lado inferior direito
        if (-(currentVertical - vertical) == -(currentHorizontal - horizontal)) {
            int saverDiagRDwn = currentHorizontal + 1;
            for (int i = currentVertical + 1; i < vertical; i++) {
                if (Board.getBoard()[i][saverDiagRDwn].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
                saverDiagRDwn++;
            }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }

        //Diagonal para o lado superior esquerdo
        if (-(currentVertical - vertical) == currentHorizontal - horizontal) {
            int saverDiagLDwn = currentHorizontal - 1;
            for (int i = currentVertical + 1; i < vertical; i++) {
                if (Board.getBoard()[i][saverDiagLDwn].getPiece() != null) {
                    System.out.println("There is something blocking the path!");
                    return false;
                }
                saverDiagLDwn++;
            }
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }

            System.out.println("Illegal move!");
            return false;
    }
}
