import controller.AdvanceAi;
import controller.AigameController;
import model.Chessboard;
import model.PlayerColor;
import view.ChessGameFrame;

import javax.swing.*;

public class AdvanceAiTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
            AdvanceAi gameController = new AdvanceAi(mainFrame.getChessboardComponent(), new Chessboard(), PlayerColor.RED);
            mainFrame.setVisible(true);
        });
    }
}
