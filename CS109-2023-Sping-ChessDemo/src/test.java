import controller.AigameController;
import controller.GameController;
import model.Chessboard;
import model.PlayerColor;
import view.ChessGameFrame;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
            AigameController gameController = new AigameController(mainFrame.getChessboardComponent(), new Chessboard(), PlayerColor.RED);
            mainFrame.setVisible(true);
        });

    }
}
