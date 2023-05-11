package listener;

import model.ChessboardPoint;
import view.AnimalComponent.TigerChessComponent;
import view.CellComponent;
import view.AnimalComponent.ElephantChessComponent;

public interface GameListener {

    void onPlayerClickCell(ChessboardPoint point, CellComponent component);


    void onPlayerClickChessPiece(ChessboardPoint point, ElephantChessComponent component);
    void onPlayerClickChessPiece(ChessboardPoint point, TigerChessComponent component);
}
