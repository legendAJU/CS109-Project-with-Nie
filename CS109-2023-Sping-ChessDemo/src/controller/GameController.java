package controller;


import listener.GameListener;
import model.Constant;
import model.PlayerColor;
import model.Chessboard;
import model.ChessboardPoint;
import view.AnimalComponent.*;
import view.CellComponent;
import view.ChessboardComponent;
import view.PalcesComponent.DensComponent;
import view.PalcesComponent.TrapsComponent;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Controller is the connection between model and view,
 * when a Controller receive a request from a view, the Controller
 * analyzes and then hands over to the model for processing
 * [in this demo the request methods are onPlayerClickCell() and onPlayerClickChessPiece()]
 *
*/
public class GameController implements GameListener {


    private Chessboard model;
    private ChessboardComponent view;



    private PlayerColor currentPlayer;

    // Record whether there is a selected piece before
    private ChessboardPoint selectedPoint;

    public GameController(ChessboardComponent view, Chessboard model) {
        this.view = view;
        this.model = model;
        this.currentPlayer = PlayerColor.BLUE;

        view.registerController(this);
        initialize();
        view.initiateChessComponent(model);
        view.repaint();
    }

    private void initialize() {
        for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
            for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {

            }
        }
    }

    // after a valid move swap the player
    private void swapColor() {
        currentPlayer = currentPlayer == PlayerColor.BLUE ? PlayerColor.RED : PlayerColor.BLUE;
    }

    private boolean win() {
        // TODO: Check the board if there is a winner
        if (model.getGrid()[0][3]!= null||model.getGrid()[8][3]!= null){
            return true;
        }
        int countRed = 0 ;
        int countBlue = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if (model.getGrid()[i][j].getPiece().getOwner()==PlayerColor.RED){
                    countRed++;
                }
                if (model.getGrid()[i][j].getPiece().getOwner()==PlayerColor.BLUE){
                    countBlue++;
                }
            }
        }
        if (countRed==0||countBlue==0){
            return true;
        }
        return false;
    }



    // click an empty cell
    @Override
    public void onPlayerClickCell(ChessboardPoint point, CellComponent component) {
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on

        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }
        if (selectedPoint != null && model.isValidMove(selectedPoint, point ) && view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")) {
            if((selectedPoint.getRow() == 0 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4)) || (selectedPoint.getRow() == 1 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setBlueTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.BLUE,72));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else if(((selectedPoint.getRow() == 8 && (selectedPoint.getCol() == 2 || selectedPoint.getCol() == 4))) || (selectedPoint.getRow() == 7 && selectedPoint.getCol() == 3)){
                model.moveChessPiece(selectedPoint, point);
                model.setRedTrapsChessAt(selectedPoint);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                view.setTrapsAtGrid(selectedPoint,new TrapsComponent(PlayerColor.RED,72));

                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.moveChessPiece(selectedPoint, point);
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
            // TODO: if the chess enter Dens or Traps and so on
        }

    }

    // click a cell with a chess
    @Override
    public void onPlayerClickChessPiece(ChessboardPoint point, ElephantChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfElephant(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }

    }
    public void onPlayerClickChessPiece(ChessboardPoint point, TigerChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTiger(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, LionChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfLion(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, DogChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
                if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                    model.captureChessPiece(selectedPoint,point);
                    view.removeChessComponentAtGridOfTraps(point);
                    if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                    }
                    selectedPoint = null;
                    swapColor();
                    view.repaint();
                }else{
                    model.captureChessPiece(selectedPoint,point);
                    view.removeChessComponentAtGridOfDog(point);
                    if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                    }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                        view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                    }
                    selectedPoint = null;
                    swapColor();
                    view.repaint();
                }
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, CatChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfCat(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, RatChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfRat(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, WolfChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfWolf(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, LeopardChessComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfLeopard(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, TrapsComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            if(model.getGrid()[point.getRow()][point.getCol()].getPiece().getName().equals("Traps")){
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }else{
                model.captureChessPiece(selectedPoint,point);
                view.removeChessComponentAtGridOfTraps(point);
                if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
                }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                    view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
                }
                selectedPoint = null;
                swapColor();
                view.repaint();
            }
        }
    }
    public void onPlayerClickChessPiece(ChessboardPoint point, DensComponent component) {
        if (selectedPoint == null) {
            if (model.getChessPieceOwner(point).equals(currentPlayer)) {
                selectedPoint = point;
                component.setSelected(true);
                component.repaint();
            }
        } else if (selectedPoint.equals(point)) {
            selectedPoint = null;
            component.setSelected(false);
            component.repaint();
        }
        // TODO: Implement capture function
        if (selectedPoint!=null&&model.isValidCapture(selectedPoint,point)){
            model.captureChessPiece(selectedPoint,point);
            view.removeChessComponentAtGridOfDens(point);
            if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Dog")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfDog(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Elephant")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfElephant(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Lion")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLion(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Tiger")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfTiger(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Leopard")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfLeopard(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Wolf")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfWolf(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Cat")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfCat(selectedPoint));
            }else if(view.getGridComponentAt(selectedPoint).getComponents()[0].getName().equals("Rat")){
                view.setChessComponentAtGrid(point, view.removeChessComponentAtGridOfRat(selectedPoint));
            }
            selectedPoint = null;
            swapColor();
            view.repaint();
        }
    }

    //Some functions

    public void restartTheGame(){
        model.removeAllPieces();
        model.initPieces();
        view.removeAllPieceComponent();
        view.initiateChessComponent(model);
        currentPlayer = PlayerColor.BLUE;
        view.repaint();


    }

    public void loadTextFileAndLoadTheGame(String archive){
        String path = "D:\\大一\\大一下课程\\java\\FirstDraftOfProject\\CS109-Project-with-Nie\\CS109-2023-Sping-ChessDemo\\GameFiles\\" + archive;

        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            model.removeAllPieces();
            model.setPiecesFromText(lines);
            int count1 = 0;
            int count2 = 0;
            //Chech whether there are other animals in the water
            for (int i = 3; i < 6 ; i++) {
                for (int j = 1; j < 3 ; j++) {
                    if(model.getChessPieceAt(new ChessboardPoint(i,j)) != null){
                        if(!model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Rat")){
                            count1++;
                        }
                    }
                }
            }
            //Check whether Dens or Traps are in the right places
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    if(model.getChessPieceAt(new ChessboardPoint(i,j)) != null){
                        if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Traps")){
                            if(!((i == 0 && (j == 2 || j ==4)) || (i == 1 && j==3) || (i == 8 && (j == 2 || j ==4)) || (i == 7 && j==3))){
                                count2 ++;
                            }
                        }
                        if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Dens")){
                            if(!((i == 0 && j ==3) || (i == 8 && j == 3))){
                                count2++;
                            }
                        }
                    }

                }
            }
            if(count1 == 0 && count2 == 0){
                view.removeAllPieceComponent();
                view.initiateChessComponent(model);
                currentPlayer = getCurrentPlayerFromText(lines);
                view.repaint();
            }else{
                JOptionPane.showMessageDialog(null, "Your archive is damaged");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public PlayerColor getCurrentPlayerFromText(List<String> lines){
        PlayerColor currentColor = PlayerColor.BLUE;
        if(lines.get(9).charAt(0) == '0'){
            currentColor = PlayerColor.BLUE;
        }else if((lines.get(9).charAt(0) == '1')){
            currentColor = PlayerColor.RED;
        }
        return currentColor;
    }

    public void storeGameIntoFile(String archive){
        String path = "D:\\大一\\大一下课程\\java\\FirstDraftOfProject\\CS109-Project-with-Nie\\CS109-2023-Sping-ChessDemo\\GameFiles\\" + archive;

        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            char[][] fileElement = new char[10][8];
            //fileElement[9][0] = '1';
            for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
                for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                   fileElement[i][j] = lines.get(i).charAt(j);
                }
            }
            for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
                for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                    if(model.getChessPieceAt(new ChessboardPoint(i,j)) != null){
                        if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Elephant") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'C';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Elephant") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'c';
                        }
                        if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Lion") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'D';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Lion") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'd';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Tiger") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'E';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Tiger") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'e';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Leopard") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'F';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Leopard") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'f';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Wolf") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'G';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Wolf") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'g';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Dog") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'H';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Dog") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'h';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Cat") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'I';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Cat") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'i';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Rat") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'J';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Rat") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'j';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Traps") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'B';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Traps") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'b';
                        }if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Dens") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.BLUE) ){
                            fileElement[i][j] = 'A';
                        }else if(model.getChessPieceAt(new ChessboardPoint(i,j)).getName().equals("Dens") && model.getChessPieceAt(new ChessboardPoint(i,j)).getOwner().equals(PlayerColor.RED)){
                            fileElement[i][j] = 'a';
                        }
                    }else if(model.getChessPieceAt(new ChessboardPoint(i,j)) == null){
                        fileElement[i][j] = '2';
                    }

                }
            }
            if(currentPlayer == PlayerColor.BLUE){
                fileElement[9][0] = '0';
            }else{
                fileElement[9][0] = '1';
            }
            try (FileWriter writer = new FileWriter(path)) {
                for (int i = 0; i < Constant.CHESSBOARD_ROW_SIZE.getNum(); i++) {
                    for (int j = 0; j < Constant.CHESSBOARD_COL_SIZE.getNum(); j++) {
                        writer.write(fileElement[i][j]);
                    }
                    writer.write(System.lineSeparator());
                }
                writer.write(fileElement[9][0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public PlayerColor getCurrentPlayer() {
        return currentPlayer;
    }
}

