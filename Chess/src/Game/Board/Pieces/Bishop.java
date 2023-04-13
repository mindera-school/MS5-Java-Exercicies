package Game.Board.Pieces;

public class Bishop extends Piece {
    public Bishop(String icon) {
        super("Bishop", icon, 3);
    }

    public static Bishop createWhiteBishop() {
        return new Bishop("♗");
    }

    public static Bishop createBlackBishop() {
        return new Bishop("♝");
    }

    public boolean movePiece(int vertical, int horizontal) {
            int currentVertical = Board.getVertical(this);
            int currentHorizontal = Board.getHorizontal(this);


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
                    saverDiagLDwn--;
                }
                this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
                Board.movePiece(this, horizontal, vertical);
                return true;
            }
           return false;
    }
    
}
