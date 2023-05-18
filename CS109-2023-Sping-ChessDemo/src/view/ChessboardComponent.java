package view;


import controller.GameController;
import model.*;
import view.AnimalComponent.*;
import view.PalcesComponent.DensComponent;
import view.PalcesComponent.TrapsComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import static model.Constant.CHESSBOARD_COL_SIZE;
import static model.Constant.CHESSBOARD_ROW_SIZE;

/**
 * This class represents the checkerboard component object on the panel
 */
public class ChessboardComponent extends JComponent {
    private final CellComponent[][] gridComponents = new CellComponent[CHESSBOARD_ROW_SIZE.getNum()][CHESSBOARD_COL_SIZE.getNum()];
    private final int CHESS_SIZE;
    private final Set<ChessboardPoint> riverCell = new HashSet<>();

    public GameController getGameController() {
        return gameController;
    }

    private GameController gameController;

    public ChessboardComponent(int chessSize) {
        CHESS_SIZE = chessSize;
        int width = CHESS_SIZE * 7;
        int height = CHESS_SIZE * 9;
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);// Allow mouse events to occur
        setLayout(null); // Use absolute layout.
        setSize(width, height);
        System.out.printf("chessboard width, height = [%d : %d], chess size = %d\n", width, height, CHESS_SIZE);

        initiateGridComponents();
    }


    /**
     * This method represents how to initiate ChessComponent
     * according to Chessboard information
     */
    public void initiateChessComponent(Chessboard chessboard) {
        Cell[][] grid = chessboard.getGrid();
        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                // TODO: Implement the initialization checkerboard

                if (grid[i][j].getPiece() != null) {
                    ChessPiece chessPiece = grid[i][j].getPiece();
                    System.out.println(chessPiece.getOwner());
                    if(grid[i][j].getPiece().getName().equals("Elephant")){
                        gridComponents[i][j].add(
                                new ElephantChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Tiger")){
                        gridComponents[i][j].add(
                                new TigerChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Cat")){
                        gridComponents[i][j].add(
                                new CatChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Rat")){
                        gridComponents[i][j].add(
                                new RatChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Dog")){
                        gridComponents[i][j].add(
                                new DogChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Wolf")){
                        gridComponents[i][j].add(
                                new WolfChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Leopard")){
                        gridComponents[i][j].add(
                                new LeopardChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    if(grid[i][j].getPiece().getName().equals("Lion")){
                        gridComponents[i][j].add(
                                new LionChessComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }if(grid[i][j].getPiece().getName().equals("Traps")){
                        gridComponents[i][j].add(
                                new TrapsComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }if(grid[i][j].getPiece().getName().equals("Dens")){
                        gridComponents[i][j].add(
                                new DensComponent(
                                        chessPiece.getOwner(),
                                        CHESS_SIZE));
                    }
                    }

            }

            }
        }
    public void removeAllPieceComponent(){
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                if(gridComponents[i][j].getComponents().length != 0){
                    if(gridComponents[i][j].getComponents()[0].getName().equals("Elephant")){
                        removeChessComponentAtGridOfElephant(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Lion")){
                        removeChessComponentAtGridOfLion(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Tiger")){
                        removeChessComponentAtGridOfTiger(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Leopard")){
                        removeChessComponentAtGridOfLeopard(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Wolf")){
                        removeChessComponentAtGridOfWolf(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Dog")){
                        removeChessComponentAtGridOfDog(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Cat")){
                        removeChessComponentAtGridOfCat(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Rat")){
                        removeChessComponentAtGridOfRat(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Traps")){
                        removeChessComponentAtGridOfTraps(new ChessboardPoint(i,j));
                    }else if(gridComponents[i][j].getComponents()[0].getName().equals("Dens")){
                        removeChessComponentAtGridOfDens(new ChessboardPoint(i,j));
                    }
                }
            }
        }
    }

    public void initiateGridComponents() {

        riverCell.add(new ChessboardPoint(3,1));
        riverCell.add(new ChessboardPoint(3,2));
        riverCell.add(new ChessboardPoint(4,1));
        riverCell.add(new ChessboardPoint(4,2));
        riverCell.add(new ChessboardPoint(5,1));
        riverCell.add(new ChessboardPoint(5,2));

        riverCell.add(new ChessboardPoint(3,4));
        riverCell.add(new ChessboardPoint(3,5));
        riverCell.add(new ChessboardPoint(4,4));
        riverCell.add(new ChessboardPoint(4,5));
        riverCell.add(new ChessboardPoint(5,4));
        riverCell.add(new ChessboardPoint(5,5));

        for (int i = 0; i < CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < CHESSBOARD_COL_SIZE.getNum(); j++) {
                ChessboardPoint temp = new ChessboardPoint(i, j);
                CellComponent cell;
                if (riverCell.contains(temp)) {
                    cell = new CellComponent(Color.CYAN, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                } else {
                    cell = new CellComponent(Color.LIGHT_GRAY, calculatePoint(i, j), CHESS_SIZE);
                    this.add(cell);
                }
                gridComponents[i][j] = cell;
            }
        }


    }

    public void registerController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setChessComponentAtGrid(ChessboardPoint point, ElephantChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, CatChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, TigerChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, DogChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, RatChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, LionChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, WolfChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setChessComponentAtGrid(ChessboardPoint point, LeopardChessComponent chess) {
        getGridComponentAt(point).add(chess);
    }
    public void setTrapsAtGrid(ChessboardPoint point, TrapsComponent trapsComponent){
        getGridComponentAt(point).add(trapsComponent);
    }
    public void setGensAtGrid(ChessboardPoint point, DensComponent densComponent){
        getGridComponentAt(point).add(densComponent);
    }

    public ElephantChessComponent removeChessComponentAtGridOfElephant(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        ElephantChessComponent chess = (ElephantChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public TigerChessComponent removeChessComponentAtGridOfTiger(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        TigerChessComponent chess = (TigerChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public CatChessComponent removeChessComponentAtGridOfCat(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        CatChessComponent chess = (CatChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public DogChessComponent removeChessComponentAtGridOfDog(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        DogChessComponent chess = (DogChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public RatChessComponent removeChessComponentAtGridOfRat(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        RatChessComponent chess = (RatChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public LionChessComponent removeChessComponentAtGridOfLion(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        LionChessComponent chess = (LionChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public WolfChessComponent removeChessComponentAtGridOfWolf(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        WolfChessComponent chess = (WolfChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public LeopardChessComponent removeChessComponentAtGridOfLeopard(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        LeopardChessComponent chess = (LeopardChessComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public TrapsComponent removeChessComponentAtGridOfTraps(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        TrapsComponent chess = (TrapsComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }
    public DensComponent removeChessComponentAtGridOfDens(ChessboardPoint point) {
        // Note re-validation is required after remove / removeAll.
        DensComponent chess = (DensComponent) getGridComponentAt(point).getComponents()[0];
        getGridComponentAt(point).removeAll();
        getGridComponentAt(point).revalidate();
        chess.setSelected(false);
        return chess;
    }



    public CellComponent getGridComponentAt(ChessboardPoint point) {
        return gridComponents[point.getRow()][point.getCol()];
    }

    private ChessboardPoint getChessboardPoint(Point point) {
        System.out.println("[" + point.y/CHESS_SIZE +  ", " +point.x/CHESS_SIZE + "] Clicked");
        return new ChessboardPoint(point.y/CHESS_SIZE, point.x/CHESS_SIZE);
    }
    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            JComponent clickedComponent = (JComponent) getComponentAt(e.getX(), e.getY());
            if (clickedComponent.getComponentCount() == 0) {
                System.out.print("None chess here and ");
                gameController.onPlayerClickCell(getChessboardPoint(e.getPoint()), (CellComponent) clickedComponent);
            } else if(clickedComponent.getComponents()[0].getName().equals("Elephant")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (ElephantChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            } else if(clickedComponent.getComponents()[0].getName().equals("Tiger")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (TigerChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
            else if(clickedComponent.getComponents()[0].getName().equals("Lion")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (LionChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
            else if(clickedComponent.getComponents()[0].getName().equals("Dog")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (DogChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }}
            else if(clickedComponent.getComponents()[0].getName().equals("Cat")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (CatChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
            else if(clickedComponent.getComponents()[0].getName().equals("Rat")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (RatChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
            else if(clickedComponent.getComponents()[0].getName().equals("Wolf")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (WolfChessComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
            else if(clickedComponent.getComponents()[0].getName().equals("Leopard")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (LeopardChessComponent) clickedComponent.getComponents()[0]);

                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }}else if(clickedComponent.getComponents()[0].getName().equals("Traps")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (TrapsComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
            else if(clickedComponent.getComponents()[0].getName().equals("Dens")){
                System.out.print("One chess here and ");
                gameController.onPlayerClickChessPiece(getChessboardPoint(e.getPoint()), (DensComponent) clickedComponent.getComponents()[0]);
                if(getGameController().win()){
                    getGameController().swapColor();
                    JLabel label = new JLabel("Winner is：" + getGameController().getCurrentPlayer());
                    JOptionPane.showMessageDialog(this, label);
                }
            }
        }
    }
}
