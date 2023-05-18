package view;

import controller.GameController;
import model.PlayerColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        addNameLabel();
        addResetButton();
        addLoadButton();
        addStoreButton();
        addRegretButton();
       addCurrentPlayerLabel();
       addCurrentRecordRoundLabel();
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
    private void addNameLabel() {
        JLabel statusLabel = new JLabel("斗兽棋");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 60));
        add(statusLabel);
    }
    private void addCurrentPlayerLabel(){
        JLabel statusLabel = new JLabel("CurrentPlayerMessage");
        statusLabel.setOpaque(false);
        statusLabel.setLocation(HEIGTH / 2 - 120  , HEIGTH / 90);
        statusLabel.setSize(400, 60);
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Current Player: " + chessboardComponent.getGameController().getCurrentPlayer());
            }
        });
        timer.start();
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 24));
        add(statusLabel);
    }
    private void addCurrentRecordRoundLabel(){
        JLabel statusLabel = new JLabel("CurrentRoundMessage");
        statusLabel.setOpaque(false);
        statusLabel.setLocation(HEIGTH, HEIGTH / 90);
        statusLabel.setSize(400, 60);
        Timer timer = new Timer(10, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Current Round: " + chessboardComponent.getGameController().getCurrentRound());
            }
        });
        timer.start();
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 24));
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
            String fileName = JOptionPane.showInputDialog(null, "Which archive do you want to play: ");
            chessboardComponent.getGameController().loadTextFileAndLoadTheGame(fileName);
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
            String archive = JOptionPane.showInputDialog(this,"Create a archive , please input your file name: ");
            if(archive.substring(archive.length() - 4).equals(".txt")){
                try {
                    File file = new File("GameFiles/" + archive);
                    file.createNewFile();
                    try {
                        FileWriter writer = new FileWriter(file);
                        writer.write("D2BAB2E\n" +
                                "2H2B2I2\n" +
                                "J2F222C\n" +
                                "222G222\n" +
                                "2222222\n" +
                                "222f222\n" +
                                "c2g222j\n" +
                                "2i2b2h2\n" +
                                "e2bab2d");
                        writer.write(0);
                        writer.write(0);
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    chessboardComponent.getGameController().storeGameIntoFile(file.getAbsolutePath());
                }catch(IOException e1){
                    e1.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Your file name is not in the right formal(Error Code: 101)");
            }



            //chessboardComponent.getGameController().loadTextFileAndLoadTheGame(archive);


        });
    }
    private void addRegretButton(){
        JButton button = new JButton("Regret");
        button.addActionListener((e) -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to regret?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                chessboardComponent.getGameController().regret();
            }
        });
        button.setLocation(HEIGTH, HEIGTH / 10 + 480);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));


        add(button);
    }


}
