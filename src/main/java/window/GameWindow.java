package window;

import gamelogic.CityValidator;
import gamelogic.MainGame;
import gamelogic.Player;

import javax.swing.*;

public class GameWindow extends JFrame {
    private MainGame game;
    private ComponentsGameWindow components;
    private WelcomeWindow welcomeWindow;

    public GameWindow(String playerName) {
        this.welcomeWindow = welcomeWindow;
        String[] cities = CityValidator.loadCities("src/main/resources/cities.txt");
        game = new MainGame(new Player(playerName), cities);
        components = new ComponentsGameWindow();
        initComponents();
    }

    private void initComponents() {
        components.createFrame();

        components.getButton().addActionListener(e -> {
            String userInput = components.getUserInput();
            boolean isCityAvailable = game.isCityAvailable(userInput);

            if (isCityAvailable) {
                String aiCity = game.getRandomCity(userInput.charAt(userInput.length() - 1));
                components.setComputerResponse(aiCity);
                game.addCity(userInput, aiCity);
            } else {
                components.showGameOverDialog();
                showRecordWindow();
            }
        });
    }

    private void showRecordWindow() {
        RecordWindow recordWindow = new RecordWindow();
        // Get player score data and add the record to the record window
        int playerScore = game.getPlayerScore();
        String playerName = game.getPlayer().getPlayerName();
        recordWindow.addRecord(playerName, playerScore);
        recordWindow.setVisible(true);

        // Close the current welcome window
        welcomeWindow.dispose();
    }
}