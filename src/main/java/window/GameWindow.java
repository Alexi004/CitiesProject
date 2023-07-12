package window;

import gamelogic.CityValidator;
import gamelogic.MainGame;
import gamelogic.Player;

import javax.swing.*;

public class GameWindow extends JFrame {
    private final MainGame game;
    private final ComponentsGameWindow components;
    private final String playerName;

    public GameWindow(String playerName) {
        this.playerName = playerName;

        String[] cities = CityValidator.loadCities("src/main/resources/cities.txt");
        game = new MainGame(new Player(playerName), cities);
        components = new ComponentsGameWindow();
        initComponents();
    }

    private void initComponents() {
        components.createFrame();

        components.getButton().addActionListener(e -> {
            String userInput = components.getUserInput();
            if (userInput.equalsIgnoreCase("здаюсь")) {
                components.closeGameWindow();
                int computerScore = game.getPlayerScore();
                int playerScore = game.getPlayerScore();
                SwingUtilities.invokeLater(() -> new FinishWindow(computerScore, playerScore, playerName));
                return;
            }
            boolean isCityAvailable = game.isCityAvailable(userInput);

            if (isCityAvailable) {
                String aiCity = game.getRandomCity(game.getLastCitySymbol());
                if (aiCity.equalsIgnoreCase("not found")) {
                    components.showMessage("AI loss at turn " + game.getLastCitySymbol(), "AI loss");
                    return;
                } else {
                    isCityAvailable = game.isCityAvailable(aiCity);
                    if (!isCityAvailable) {
                        components.showMessage("AI loss at turn " + game.getLastCitySymbol(), "AI loss");
                        return;
                    }
                }
                components.setComputerResponse(aiCity.substring(0, 1).toUpperCase() + aiCity.substring(1));
            } else {
                components.showMessage("Такого міста немає", "Міста немає");
            }
        });
    }
}
