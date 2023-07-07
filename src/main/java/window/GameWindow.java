package window;

import java.awt.*;

import static window.ComponentsGameWindow.*;

public class GameWindow {
    private String userInputText;

    public void createGameWindow() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        createFrame();
        createTextField();
        createButton();
        createLabel();
        usingFonts();
    }

    public String getUserInput() {
        ComponentsGameWindow.button.addActionListener(e -> {
            String userInputText = ComponentsGameWindow.userInputField.getText();
        });
        return userInputText;
    }

    public void closeWindow() {
        ComponentsGameWindow.frameGame.dispose();
    }
}
