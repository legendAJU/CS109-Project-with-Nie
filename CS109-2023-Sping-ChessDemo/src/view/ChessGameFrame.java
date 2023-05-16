package view;

import controller.GameController;

import javax.swing.*;
import java.awt.*;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {
    //    public final Dimension FRAME_SIZE ;
    private final int WIDTH;
    private final int HEIGTH;

    private final int ONE_CHESS_SIZE;

    private ChessboardComponent chessboardComponent;
    public ChessGameFrame(int width, int height) {
        setTitle("2023 CS109 Project Specifications"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.ONE_CHESS_SIZE = (HEIGTH * 4 / 5) / 9;
        LanguageMenu languageMenuBar = new LanguageMenu();
        LevelMenu levelMenu = new LevelMenu();
        BeginMenu beginMenu = new BeginMenu();
        MainMenu menu = new MainMenu();

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);
        setMenuBar(menu.MainMenu(languageMenuBar,levelMenu,beginMenu));



        addChessboard();
        addLabel();
        addResetButton();
        addLoadButton();
        addStoreButton();
        addRegretButton();
    }

    public ChessboardComponent getChessboardComponent() {
        return chessboardComponent;
    }

    public void setChessboardComponent(ChessboardComponent chessboardComponent) {
        this.chessboardComponent = chessboardComponent;
    }

    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {
        chessboardComponent = new ChessboardComponent(ONE_CHESS_SIZE);
        chessboardComponent.setLocation(HEIGTH / 5, HEIGTH / 10);
        add(chessboardComponent);
    }

    /**
     * 在游戏面板中添加标签
     */
    private void addLabel() {
        JLabel statusLabel = new JLabel("Sample label");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addResetButton() {
        JButton button = new JButton("Reset");
        button.addActionListener((e) -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to call the method?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                chessboardComponent.getGameController().restartTheGame();
            }
        });

        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }



    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            //String archive = JOptionPane.showInputDialog(this,"Input Archive here");
            //chessboardComponent.getGameController().loadTextFileAndLoadTheGame(archive);
            Object[] options = {"GameLoader1.txt", "GameLoader2.txt", "GameLoader3.txt", "GameLoader4.txt", "GameLoader5.txt", "GameLoader6.txt"};
            int result = JOptionPane.showOptionDialog(null, "Please select your archive", "Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if(result == 0){
                chessboardComponent.getGameController().loadTextFileAndLoadTheGame("GameLoader1.txt");
            }else if(result == 1){
                chessboardComponent.getGameController().loadTextFileAndLoadTheGame("GameLoader2.txt");
            }else if(result == 2){
                chessboardComponent.getGameController().loadTextFileAndLoadTheGame("GameLoader3.txt");
            }else if(result == 3){
                chessboardComponent.getGameController().loadTextFileAndLoadTheGame("GameLoader4.txt");
            }else if(result == 4){
                chessboardComponent.getGameController().loadTextFileAndLoadTheGame("GameLoader5.txt");
            }else if(result == 5){
                chessboardComponent.getGameController().loadTextFileAndLoadTheGame("GameLoader6.txt");
            }
        });
    }
    private void addStoreButton() {
        JButton button = new JButton("Store");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click store");
            //String archive = JOptionPane.showInputDialog(this,"Input Archive here");
            //chessboardComponent.getGameController().loadTextFileAndLoadTheGame(archive);
            Object[] options = {"GameLoader1.txt", "GameLoader2.txt", "GameLoader3.txt", "GameLoader4.txt", "GameLoader5.txt", "GameLoader6.txt"};
            int result = JOptionPane.showOptionDialog(null, "Please select which archive you want to store your game", "Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if(result == 0){
                chessboardComponent.getGameController().storeGameIntoFile("GameLoader1.txt");
            }else if(result == 1){
                chessboardComponent.getGameController().storeGameIntoFile("GameLoader2.txt");
            }else if(result == 2){
                chessboardComponent.getGameController().storeGameIntoFile("GameLoader3.txt");
            }else if(result == 3){
                chessboardComponent.getGameController().storeGameIntoFile("GameLoader4.txt");
            }else if(result == 4){
                chessboardComponent.getGameController().storeGameIntoFile("GameLoader5.txt");
            }else if(result == 5){
                chessboardComponent.getGameController().storeGameIntoFile("GameLoader6.txt");
            }
        });
    }
    private void addRegretButton(){
        JButton button = new JButton("Regret");
        button.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }


}
