package Game.Board.Pieces;
import Game.Game;
import Game.Player.Player;
import Game.Spot;


public class Board {
    private static Spot[][] board = new Spot[8][8];

    private static String[] letters ={"A","B","C","D","E","F","G","H"};

    public static void createBoard() {
        buildBoardSpots();
        placeRooks();
        placePawns();
        placeKnights();
        placeBishops();
        placeKingQueen();
    }

    public static void printBoard() {
        if(Game.getBlackPlayer()!=null) {
            System.out.println("USER: " + Game.getBlackPlayer().getUser().getUserName() + " " + Game.getBlackPlayer().getUser().getRank());
            printCaptured(Game.getWhitePlayer());
        }
        System.out.print("\033[1;37m");
        System.out.println("   1  2  3  4  5  6  7  8");
        System.out.print("\033[0m");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\033[1;37m");
            System.out.print(letters[i] + " ");
            System.out.print("\033[0m");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].printSpot();
                if (j == 7) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        if(Game.getWhitePlayer()!=null) {
            printCaptured(Game.getBlackPlayer());
            System.out.println("USER: " + Game.getWhitePlayer().getUser().getUserName() + " " + Game.getWhitePlayer().getUser().getRank());
        }
    }

    public static void placePawns() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 1) {
                    Pawn blackPawn = Pawn.createBlackPawn();
                    board[i][j].setPiece(blackPawn);
                    Game.getBlackPlayer().getPlayerPieces().add(blackPawn);
                }
                if (i == 6) {
                    Pawn whitePawn = Pawn.createWhitePawn();
                    board[i][j].setPiece(whitePawn);
                    Game.getWhitePlayer().getPlayerPieces().add(whitePawn);
                }
            }
        }
    }

    public static void placeRooks() {
        Rook firstBRook = Rook.createBlackRook();
        Rook secondBRook = Rook.createBlackRook();
        Rook firstWRook = Rook.createWhiteRook();
        Rook secondWRook = Rook.createWhiteRook();
        board[0][0].setPiece(firstBRook);
        board[0][7].setPiece(secondBRook);
        board[7][0].setPiece(firstWRook);
        board[7][7].setPiece(secondWRook);
        Game.getWhitePlayer().getPlayerPieces().add(firstWRook);
        Game.getWhitePlayer().getPlayerPieces().add(secondWRook);
        Game.getBlackPlayer().getPlayerPieces().add(firstBRook);
        Game.getBlackPlayer().getPlayerPieces().add(secondBRook);
    }

    public static void placeKnights() {
        Knight firstBKnight = Knight.createBlackKnight();
        Knight secondBKnight = Knight.createBlackKnight();
        Knight firstWKnight = Knight.createWhiteKnight();
        Knight secondWKnight = Knight.createWhiteKnight();

        board[0][1].setPiece(firstBKnight);
        board[0][6].setPiece(secondBKnight);
        board[7][6].setPiece(firstWKnight);
        board[7][1].setPiece(secondWKnight);

        Game.getWhitePlayer().getPlayerPieces().add(firstWKnight);
        Game.getWhitePlayer().getPlayerPieces().add(secondWKnight);
        Game.getBlackPlayer().getPlayerPieces().add(firstBKnight);
        Game.getBlackPlayer().getPlayerPieces().add(secondBKnight);
    }

    public static void placeBishops() {
        Bishop firstBBishop = Bishop.createBlackBishop();
        Bishop secondBBishop = Bishop.createBlackBishop();
        Bishop firstWBishop = Bishop.createWhiteBishop();
        Bishop secondWBishop = Bishop.createWhiteBishop();

        board[0][2].setPiece(firstBBishop);
        board[0][5].setPiece(secondBBishop);
        board[7][2].setPiece(firstWBishop);
        board[7][5].setPiece(secondWBishop);

        Game.getBlackPlayer().getPlayerPieces().add(firstBBishop);
        Game.getBlackPlayer().getPlayerPieces().add(secondBBishop);
        Game.getWhitePlayer().getPlayerPieces().add(firstWBishop);
        Game.getWhitePlayer().getPlayerPieces().add(secondWBishop);

    }

    public static void placeKingQueen() {
        Queen bQueen = Queen.createBlackQueen();
        King bKing = King.createBlackKing();
        Queen wQueen = Queen.createWhiteQueen();
        King wKing = King.createWhiteKing();

        board[0][3].setPiece(bQueen);
        board[0][4].setPiece(bKing);
        board[7][3].setPiece(wQueen);
        board[7][4].setPiece(wKing);

        Game.getBlackPlayer().getPlayerPieces().add(bQueen);
        Game.getBlackPlayer().getPlayerPieces().add(bKing);
        Game.getWhitePlayer().getPlayerPieces().add(wQueen);
        Game.getWhitePlayer().getPlayerPieces().add(wKing);

    }

    public static void buildBoardSpots() {
        for (int i = 0; i < board.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < board[i].length; j++) {
                    if (j % 2 != 0) {
                        board[i][j] = new Spot("\033[0;100m", null);
                    } else {
                        board[i][j] = new Spot("\u001B[47m", null);
                    }
                }
            } else {
                for (int j = 0; j < board[i].length; j++) {
                    if (j % 2 != 0) {
                        board[i][j] = new Spot("\u001B[47m", null);
                    } else {
                        board[i][j] = new Spot("\033[0;100m", null);
                    }
                }
            }

        }
    }

    public static Spot[][] getBoard() {
        return board;
    }

    public static int getVertical(Piece piece) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getPiece() == null) {
                    continue;
                }
                if (board[i][j].getPiece().equals(piece)) {
                    return i;
                }
            }
        }
        System.out.println("Piece isn't on the board");
        return 0;
    }


    public static int getHorizontal(Piece piece) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getPiece() == null) {
                    continue;
                }
                if (board[i][j].getPiece().equals(piece)) {
                    return j;
                }
            }
        }
        System.out.println("Piece isn't on the board");
        return 0;
    }

    public static int letterToInt(String letter) {
        switch (letter.toUpperCase()){
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            default:
                return 8;
        }
    }

    public static void movePiece(Piece piece,int horizontal, int vertical) {
        Player ownTeam = null;
        board[getVertical(piece)][getHorizontal(piece)].setPiece(null);
        board[vertical][horizontal].setPiece(piece);
        if(Game.getWhitePlayer().getPlayerPieces().contains(piece)){
            ownTeam = Game.getWhitePlayer();
        }else{
            ownTeam = Game.getBlackPlayer();
        }
        ownTeam.addMoves(1);
    }



    public static void printCaptured(Player player){
        if(player == null){
            return;
        }
        System.out.println("  -----------------------");
        System.out.print("   ");
        for (int i = 0; i <player.getCapturedPieces().size(); i++) {
            System.out.print(player.getCapturedPieces().get(i).getIcon()+" ");
            if(i==8){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("  -----------------------");
    }

}
