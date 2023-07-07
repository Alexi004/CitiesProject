package window;

import javax.swing.*;

public class maintest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WelcomeWindow welcomeWindow = new WelcomeWindow();
        });

        GameWindow game = new GameWindow();
        game.createGameWindow();
    }
}
