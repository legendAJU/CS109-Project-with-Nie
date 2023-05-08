package view;
import javax.swing.*;
import java.awt.*;
public class BeginMenu {
    public Menu BeginMenu(){
        Menu m;
        Menu m1 = new Menu("开始");
        Menu m2 = new Menu("Begin");
        Menu m3 = new Menu("開始");
        MenuItem mi1 = new MenuItem("开始游戏");
        MenuItem mi2 = new MenuItem("载入游戏");
        MenuItem mi3 = new MenuItem("结束游戏");
        MenuItem mi4 = new MenuItem("Begin the Game");
        MenuItem mi5 = new MenuItem("Load the Game");
        MenuItem mi6 = new MenuItem("End the Game");
        MenuItem mi7 = new MenuItem("開始遊戲");
        MenuItem mi8 = new MenuItem("載入遊戲");
        MenuItem mi9 = new MenuItem("結束遊戲");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m3.add(mi7);
        m3.add(mi8);
        m3.add(mi9);
        m = m1;
        return m;
    }


}
