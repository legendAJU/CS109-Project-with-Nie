package view;
import javax.swing.*;
import java.awt.*;
public class MainMenu {
    private LanguageMenu languageMenu;
    private LevelMenu levelMenu;
    private BeginMenu beginMenu;

    public MenuBar MainMenu(LanguageMenu languageMenu, LevelMenu levelMenu, BeginMenu beginMenu) {
        this.languageMenu = languageMenu;
        this.levelMenu = levelMenu;
        this.beginMenu = beginMenu;


        MenuBar mainMenu = new MenuBar();

        mainMenu.add(levelMenu.levelMenu());
        mainMenu.add(languageMenu.LanguageMenu());
        mainMenu.add(beginMenu.BeginMenu());
        return mainMenu;
    }
}
