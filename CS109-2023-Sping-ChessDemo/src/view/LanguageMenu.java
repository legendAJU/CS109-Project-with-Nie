package view;

import javax.swing.*;
import java.awt.MenuItem;
import java.awt.*;

public class LanguageMenu {
    public Menu LanguageMenu() {
        Menu m;
        Menu m2 = new Menu("语言");
        Menu m4 = new Menu("Language");
        Menu m6 = new Menu("語言");
        MenuItem mi1 = new MenuItem("中文（简体）");
        MenuItem mi2 = new MenuItem("English");
        MenuItem mi3 = new MenuItem("中文（繁體）");
        MenuItem mi4 = new MenuItem("中文（简体）");
        MenuItem mi5 = new MenuItem("English");
        MenuItem mi6 = new MenuItem("中文（繁體）");
        MenuItem mi7 = new MenuItem("中文（简体）");
        MenuItem mi8 = new MenuItem("English");
        MenuItem mi9 = new MenuItem("中文（繁體）");
        m2.add(mi1);
        m2.add(mi2);
        m2.add(mi3);
        m4.add(mi4);
        m4.add(mi5);
        m4.add(mi6);
        m6.add(mi7);
        m6.add(mi8);
        m6.add(mi9);
        m = m2;
        return m;

    }

}
