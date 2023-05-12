package model;

/**
 * This class store the real chess information.
 * The Chessboard has 9*7 cells, and each cell has a position for chess
 */
public class Chessboard {
    private Cell[][] grid;

    public Chessboard() {
        this.grid =
                new Cell[Constant.CHESSBOARD_ROW_SIZE.getNum()][Constant.CHESSBOARD_COL_SIZE.getNum()];//9*7

        initGrid();
        initPieces();
    }

    private void initGrid() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void initPieces() {
        grid[2][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Elephant", 8));
        grid[6][0].setPiece(new ChessPiece(PlayerColor.RED, "Elephant", 8));
        grid[0][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Lion", 7));
        grid[8][6].setPiece(new ChessPiece(PlayerColor.RED, "Lion", 7));
        grid[0][6].setPiece(new ChessPiece(PlayerColor.BLUE, "Tiger", 6));
        grid[8][0].setPiece(new ChessPiece(PlayerColor.RED, "Tiger", 6));
        grid[2][2].setPiece(new ChessPiece(PlayerColor.BLUE, "Leopard", 5));
        grid[6][4].setPiece(new ChessPiece(PlayerColor.RED, "Leopard", 5));
        grid[2][4].setPiece(new ChessPiece(PlayerColor.BLUE, "Wolf", 4));
        grid[6][2].setPiece(new ChessPiece(PlayerColor.RED, "Wolf", 4));
        grid[1][1].setPiece(new ChessPiece(PlayerColor.BLUE, "Dog", 3));
        grid[7][5].setPiece(new ChessPiece(PlayerColor.RED, "Dog", 3));
        grid[1][5].setPiece(new ChessPiece(PlayerColor.BLUE, "Cat", 2));
        grid[7][1].setPiece(new ChessPiece(PlayerColor.RED, "Cat", 2));
        grid[2][0].setPiece(new ChessPiece(PlayerColor.BLUE, "Rat", 1));
        grid[6][6].setPiece(new ChessPiece(PlayerColor.RED, "Rat", 1));
        grid[0][2].setPiece(new ChessPiece(PlayerColor.BLUE,"Traps",0));
        grid[0][4].setPiece(new ChessPiece(PlayerColor.BLUE,"Traps",0));
        grid[1][3].setPiece(new ChessPiece(PlayerColor.BLUE,"Traps",0));
        grid[7][3].setPiece(new ChessPiece(PlayerColor.RED,"Traps",0));
        grid[8][2].setPiece(new ChessPiece(PlayerColor.RED,"Traps",0));
        grid[8][4].setPiece(new ChessPiece(PlayerColor.RED,"Traps",0));
        grid[0][3].setPiece(new ChessPiece(PlayerColor.BLUE,"Dens",0));
        grid[8][3].setPiece(new ChessPiece(PlayerColor.RED,"Dens",0));

    }

    private ChessPiece getChessPieceAt(ChessboardPoint point) {
        return getGridAt(point).getPiece();
    }

    private Cell getGridAt(ChessboardPoint point) {
        return grid[point.getRow()][point.getCol()];
    }

    private int calculateDistance(ChessboardPoint src, ChessboardPoint dest) {
        return Math.abs(src.getRow() - dest.getRow()) + Math.abs(src.getCol() - dest.getCol());
    }

    private ChessPiece removeChessPiece(ChessboardPoint point) {
        ChessPiece chessPiece = getChessPieceAt(point);
        getGridAt(point).removePiece();
        return chessPiece;
    }

    private void setChessPiece(ChessboardPoint point, ChessPiece chessPiece) {
        getGridAt(point).setPiece(chessPiece);
    }

    public void moveChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isValidMove(src, dest)) {
            throw new IllegalArgumentException("Illegal chess move!");
        }
        setChessPiece(dest, removeChessPiece(src));
    }

    public void captureChessPiece(ChessboardPoint src, ChessboardPoint dest) {
        if (!isValidCapture(src, dest)) {
            throw new IllegalArgumentException("Illegal chess capture!");
        }
        // TODO: Finish the method. (no problem so far)
        removeChessPiece(dest);
        setChessPiece(dest, removeChessPiece(src));

    }

    public Cell[][] getGrid() {
        return grid;
    }

    public PlayerColor getChessPieceOwner(ChessboardPoint point) {
        return getGridAt(point).getPiece().getOwner();
    }

    public boolean isValidMove(ChessboardPoint src, ChessboardPoint dest) {
        if (getChessPieceAt(src) == null || getChessPieceAt(dest) != null) {
            return false;
        }
        if (dest.checkWater()==1||dest.checkWater()==2) {
            return getChessPieceAt(src).getRank() == 1;
        }
        if ((getChessPieceAt(src).getRank()==7||getChessPieceAt(src).getRank()==6)&&src.checkWater()==3){


            if (src.getCol()==0&&dest.getCol()==3&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()+1].getPiece()==null&& grid[src.getRow()][src.getCol()+2].getPiece()==null){
                    return true;
                }
            }
            if (src.getCol()==3&&dest.getCol()==0&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()-1].getPiece()==null&& grid[src.getRow()][src.getCol()-2].getPiece()==null){
                    return true;
                }
            }
            if (src.getCol()==3&&dest.getCol()==6&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()+1].getPiece()==null&& grid[src.getRow()][src.getCol()+2].getPiece()==null){
                    return true;
                }
            }
            if (src.getCol()==6&&dest.getCol()==3&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()-1].getPiece()==null&& grid[src.getRow()][src.getCol()-2].getPiece()==null){
                    return true;
                }
            }
            if (src.getRow()==2&&dest.getRow()==6&&src.getCol()==dest.getCol()){
                if (grid[src.getRow()+1][src.getCol()].getPiece()==null&& grid[src.getRow()+2][src.getCol()].getPiece()==null&&
                        grid[src.getRow()+3][src.getCol()].getPiece()==null){
                    return true;
                }
            }
            if (src.getRow()==6&&dest.getRow()==2&&src.getCol()==dest.getCol()){
                if (grid[src.getRow()-1][src.getCol()].getPiece()==null&& grid[src.getRow()-2][src.getCol()].getPiece()==null&&
                        grid[src.getRow()-3][src.getCol()].getPiece()==null){
                    return true;
                }
            }

        }
        return calculateDistance(src, dest) == 1;
    }


    public boolean isValidCapture(ChessboardPoint src, ChessboardPoint dest) {
        // TODO:Fix this method (parts finished)
        //正常抓捕、河里不能抓岸上
        //无特殊走法的（猫狗狼豹象）

        if (getChessPieceAt(src) == null || getChessPieceAt(dest) == null) {
            return false;
        }
        //虎与狮过河吃
        if ((getChessPieceAt(src).getRank()==7||getChessPieceAt(src).getRank()==6)&&src.checkWater()==3){
            if (src.getCol()==0&&dest.getCol()==3&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()+1].getPiece()==null&& grid[src.getRow()][src.getCol()+2].getPiece()==null){
                    return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
                }
            }
            if (src.getCol()==3&&dest.getCol()==0&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()-1].getPiece()==null&& grid[src.getRow()][src.getCol()-2].getPiece()==null){
                    return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
                }
            }
            if (src.getCol()==3&&dest.getCol()==6&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()+1].getPiece()==null&& grid[src.getRow()][src.getCol()+2].getPiece()==null){
                    return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
                }
            }
            if (src.getCol()==6&&dest.getCol()==3&&src.getRow()==dest.getRow()){
                if (grid[src.getRow()][src.getCol()-1].getPiece()==null&& grid[src.getRow()][src.getCol()-2].getPiece()==null){
                    return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
                }
            }
            if (src.getRow()==2&&dest.getRow()==6&&src.getCol()==dest.getCol()){
                if (grid[src.getRow()+1][src.getCol()].getPiece()==null&& grid[src.getRow()+2][src.getCol()].getPiece()==null&&
                        grid[src.getRow()+3][src.getCol()].getPiece()==null){
                    return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
                }
            }
            if (src.getRow()==6&&dest.getRow()==2&&src.getCol()==dest.getCol()){
                if (grid[src.getRow()-1][src.getCol()].getPiece()==null&& grid[src.getRow()-2][src.getCol()].getPiece()==null&&
                        grid[src.getRow()-3][src.getCol()].getPiece()==null){
                    return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
                }
            }

        }



        //正常四周吃
        if (calculateDistance(src, dest) == 1){
            //水不能吃岸上 岸上也不能吃水里
            if ((src.checkWater()==0||src.checkWater()==3)&&(dest.checkWater()==1||dest.checkWater()==2)){
                return false;
            }
            if ((src.checkWater()==1||src.checkWater()==2)&&(dest.checkWater()==0||dest.checkWater()==3)){
                return false;
            }
            //老鼠水中吃
            if ((dest.getRow()==0&&dest.getCol()==2)||(dest.getRow()==0&&dest.getCol()==4)
                    ||(dest.getRow()==1&&dest.getCol()==3)||(dest.getRow()==7&&dest.getCol()==3)
                    ||(dest.getRow()==8&&dest.getCol()==2)||(dest.getRow()==8&&dest.getCol()==4)){
                return true;
            }

            if ((dest.checkWater()==1||dest.checkWater()==2)&&(src.checkWater()==1||src.checkWater()==2)){
                return true;
            }


            return getChessPieceAt(src).canCapture(getChessPieceAt(dest));
        }

        return false;
    }
    public void setBlueTrapsChessAt(ChessboardPoint point){
        grid[point.getRow()][point.getCol()].setPiece(new ChessPiece(PlayerColor.BLUE,"Traps",0));
    }
    public void setRedTrapsChessAt(ChessboardPoint point){
        grid[point.getRow()][point.getCol()].setPiece(new ChessPiece(PlayerColor.RED,"Traps",0));
    }
}
