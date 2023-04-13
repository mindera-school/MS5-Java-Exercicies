package Game.Board.Pieces;

public class King extends Piece {

    private static boolean isKingFirstMove = true;

    public King(String icon) {
        super("King", icon, 0);
    }

    public static King createWhiteKing() {
        return new King("♔");
    }

    public static King createBlackKing() {
        return new King("♚");
    }

    @Override
    public boolean movePiece(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if(currentHorizontal == horizontal && currentVertical - 1 == vertical){
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }

        if (horizontal == currentHorizontal - 1 && vertical == currentVertical) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        if (horizontal == currentHorizontal - 1 && vertical == currentVertical + 1) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        if (horizontal == currentHorizontal && vertical == currentVertical + 1) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        if (horizontal == currentHorizontal + 1 && vertical == currentVertical + 1) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        if (horizontal == currentHorizontal + 1 && vertical == currentVertical) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        if (horizontal == currentHorizontal + 1 && vertical == currentVertical - 1) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        if (horizontal == currentHorizontal - 1 && vertical == currentVertical - 1) {
            this.capturePiece(Board.getBoard()[vertical][horizontal].getPiece());
            Board.movePiece(this, horizontal, vertical);
            return true;
        }
        System.out.println("Illegal move");
        return false;
    }

    public void castling(int vertical, int horizontal) {

        int currentVertical = Board.getVertical(this);
        int currentHorizontal = Board.getHorizontal(this);

        if (isKingFirstMove) {
            for (int i = currentVertical + 1; i < vertical; i++) {
                if (Board.getBoard()[i][currentHorizontal].getPiece() == null) {
                    if (currentHorizontal == 7 && horizontal == currentHorizontal && vertical == 6)
                        Board.getBoard()[vertical][currentHorizontal].setPiece(King.createBlackKing());
                    Board.getBoard()[vertical - 1][currentHorizontal].setPiece(Rook.createBlackRook());
                    isKingFirstMove = false;
                    if (currentHorizontal == 0 && horizontal == currentHorizontal && vertical == 6)
                        Board.getBoard()[vertical][currentHorizontal].setPiece(King.createWhiteKing());
                    Board.getBoard()[vertical - 1][currentHorizontal].setPiece(Rook.createWhiteRook());
                    isKingFirstMove = false;
                }
            }
            for (int i = currentVertical + 1; i > vertical; i--) {
                if (Board.getBoard()[i][currentHorizontal].getPiece() == null) {
                    if (currentHorizontal == 7 && horizontal == currentHorizontal && vertical == 2)
                        Board.getBoard()[vertical][currentHorizontal].setPiece(King.createBlackKing());
                    Board.getBoard()[vertical + 1][currentHorizontal].setPiece(Rook.createBlackRook());
                    isKingFirstMove = false;
                    if (currentHorizontal == 0 && horizontal == currentHorizontal && vertical == 2)
                        Board.getBoard()[vertical][currentHorizontal].setPiece(King.createWhiteKing());
                    Board.getBoard()[vertical + 1][currentHorizontal].setPiece(Rook.createWhiteRook());
                    isKingFirstMove = false;
                }
            }
        }
    }
}
