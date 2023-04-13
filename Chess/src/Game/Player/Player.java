package Game.Player;
import Game.Board.Pieces.*;
import User.Users;
import java.util.ArrayList;

public class Player {
    private Users user;

    private int points;

    private int moves;

    private String rank;
    private ArrayList<Piece> playerPieces = new ArrayList<>();
    private ArrayList<Piece> capturedPieces = new ArrayList<>();

    public Player(Users user) {
        this.user = user;
    }

    public void addMoves(int moves) {
        this.moves += moves;
    }

    public void addPoints(int points){
        this.points += points;
    }

    public ArrayList<Piece> getCapturedPieces() {
        return capturedPieces;
    }

    public ArrayList<Piece> getPlayerPieces() {
        return playerPieces;
    }

    public int getPoints() {
        return points;
    }

    public Users getUser() {
        return user;
    }

    public int getMoves() {
        return moves;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
