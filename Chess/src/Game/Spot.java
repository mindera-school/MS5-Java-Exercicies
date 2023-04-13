package Game;
import Game.Board.Pieces.*;

public class Spot {
    private String spotColor;
    private Piece piece;

    public Spot(String spotColor, Piece piece) {
        this.spotColor = spotColor;
        this.piece = piece;
    }

    public void printSpot(){

        if(this.piece ==null){
            System.out.print(spotColor);
            System.out.print("   ");
            System.out.print("\033[39m" + "\033[49m");
        }
        else{
            System.out.print(spotColor);
            System.out.print(" ");
            System.out.print(this.piece.getIcon());
            System.out.print(" ");
            System.out.print("\033[39m" + "\033[49m");

        }
    }

    public void setPiece(Piece piece) {

        this.piece = piece;
    }

    public Piece getPiece() {

        return piece;
    }
}
