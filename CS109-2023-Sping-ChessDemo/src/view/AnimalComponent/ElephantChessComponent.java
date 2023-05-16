package view.AnimalComponent;


import model.PlayerColor;

import javax.swing.*;
import java.awt.*;

/**
 * This is the equivalent of the ChessPiece class,
 * but this class only cares how to draw Chess on ChessboardComponent
 */
public class ElephantChessComponent extends JComponent {
    private PlayerColor owner;

    private boolean selected;

    private final String name = "Elephant";

    private ImageIcon image;

    @Override
    public String getName() {
        return name;
    }

    public ElephantChessComponent(PlayerColor owner, int size ) {
        this.owner = owner;
        this.selected = false;
        setSize(size/2, size/2);
        setLocation(0,0);
        setVisible(true);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ImageIcon icon = null;
        if(owner == PlayerColor.BLUE){
            icon = new ImageIcon("E:\\OneDrive - 南方科技大学\\桌面\\大一下\\cs\\斗兽棋\\resource\\ElephantInBlue.png");
        }else if(owner == PlayerColor.RED){
            icon = new ImageIcon("E:\\OneDrive - 南方科技大学\\桌面\\大一下\\cs\\斗兽棋\\resource\\ElephantInRed.png");
        }
        Image image = icon.getImage();
        int newWidth = image.getWidth(null) / 2; // 计算缩小后的宽度
        int newHeight = image.getHeight(null) / 2; // 计算缩小后的高度
        int x = (getWidth() - newWidth) / 2; // 计算图像的 x 坐标
        int y = (getHeight() - newHeight) / 2; // 计算图像的 y 坐标
        g2.drawImage(image, x, y, newWidth, newHeight, null);
        if (isSelected()) { // Highlights the model if selected.
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}
