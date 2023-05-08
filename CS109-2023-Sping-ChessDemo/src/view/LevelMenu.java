package view;
import javax.swing.*;
import java.awt.*;
public class LevelMenu {
    public Menu levelMenu(){
        Menu m;
        Menu m1 = new Menu("难度");
        Menu m3 = new Menu("Level");
        Menu m5 = new Menu("難度");
        MenuItem mi1 = new MenuItem("简单");
        MenuItem mi2 = new MenuItem("中等");
        MenuItem mi3 = new MenuItem("困难");
        MenuItem mi4 = new MenuItem("Easy");
        MenuItem mi5 = new MenuItem("Medium");
        MenuItem mi6 = new MenuItem("Hard");
        MenuItem mi7 = new MenuItem("簡單");
        MenuItem mi8 = new MenuItem("中等");
        MenuItem mi9 = new MenuItem("困難");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m3.add(mi4);
        m3.add(mi5);
        m3.add(mi6);
        m5.add(mi7);
        m5.add(mi8);
        m5.add(mi9);
        m = m5;
        return m;
    }
}
