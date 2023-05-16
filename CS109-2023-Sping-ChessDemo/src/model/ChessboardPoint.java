package model;

/**
 * This class represents positions on the checkerboard, such as (0, 0), (0, 7), and so on
 * Where, the upper left corner is (0, 0), the lower left corner is (7, 0), the upper right corner is (0, 7), and the lower right corner is (7, 7).
 */
public class ChessboardPoint {
    private final int row;
    private final int col;


    public ChessboardPoint(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    //0是无水，1是左边，2是右边，3是河岸
    public int checkWater(){
        if(this.row == 3||this.row == 4||this.row == 5){
            if (this.col==1||this.col==2){
                return 1;
            }
        }
        if(this.row == 3||this.row == 4||this.row == 5){
            if (this.col==4||this.col==5){
                return 2;
            }
        }
        if (row==2&&(col==1||col==2||col==4||col==5)){return 3;}
        if (row==6&&(col==1||col==2||col==4||col==5)){return 3;}
        if ((row==3||row==4||row==5)&&(col==0||col==3||col==6)){return 3;}

        return 0;
    }



    @Override
    public int hashCode() {
        return row + col;
    }

    @Override
    @SuppressWarnings("ALL")
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ChessboardPoint temp = (ChessboardPoint) obj;
        return (temp.getRow() == this.row) && (temp.getCol() == this.col);
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ") " + "on the chessboard is clicked!";
    }
}
