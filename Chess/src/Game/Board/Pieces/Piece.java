package Game.Board.Pieces;
import Game.*;
import Game.Player.Player;

public abstract class Piece{
    private String name;
    private String icon;
    private int points;

    public Piece(String name, String icon, int points) {
        this.name = name;
        this.icon = icon;
        this.points = points;
    }

    public abstract boolean movePiece(int vertical, int horizontal);

    public boolean checkCapturePiece(Piece otherPiece) {
        Player ownTeam = null;
        Player otherTeam = null;
        if(Game.getWhitePlayer().getPlayerPieces().contains(this)){
            ownTeam = Game.getWhitePlayer();
        }else{
            ownTeam = Game.getBlackPlayer();
        }

        if(ownTeam.getPlayerPieces().contains(otherPiece)){
            System.out.println("One of your pieces is occupying the position you have chosen!");
            return false;
        }else{
            return true;
        }

    }

    public void capturePiece(Piece otherPiece){
        if(otherPiece == null){
            return;
        }
        Player ownTeam = null;
        Player otherTeam = null;
        if(Game.getWhitePlayer().getPlayerPieces().contains(this)){
            ownTeam = Game.getWhitePlayer();
            otherTeam = Game.getBlackPlayer();
        }else{
            ownTeam = Game.getBlackPlayer();
            otherTeam = Game.getWhitePlayer();
        }
        ownTeam.getCapturedPieces().add(otherPiece);
        ownTeam.addPoints(otherPiece.points);
        otherTeam.getPlayerPieces().remove(otherPiece);
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

}
