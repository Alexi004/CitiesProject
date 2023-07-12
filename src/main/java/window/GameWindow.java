package window;

import gamelogic.CityValidator;
import gamelogic.MainGame;
import gamelogic.Player;

import javax.swing.*;

public class GameWindow extends JFrame {
    private final MainGame game;
    private final String playerName;

    public GameWindow(String playerName) {
        this.playerName = playerName;

        String[] cities = CityValidator.loadCities("src/main/resources/cities.txt");
        game = new MainGame(new Player(playerName), cities);
        initComponents();
    }

    private void openFinishWindow() {
        ComponentsGameWindow.closeGameWindow();
        int lastTurn = game.getPlayerScore();
        SwingUtilities.invokeLater(() -> new FinishWindow(game.getPlayerScore(), lastTurn, playerName));
    }

    private void initComponents() {
        ComponentsGameWindow.createFrame();

        JButton button = ComponentsGameWindow.getButton();
        button.addActionListener(e -> {
            String userInput = ComponentsGameWindow.getUserInput();
            if (userInput.equalsIgnoreCase("здаюсь")) {
                openFinishWindow();
                return;
            }
            boolean isCityAvailable = game.isCityAvailable(userInput);

            if (isCityAvailable) {
                String aiCity = game.getRandomCity(game.getLastCitySymbol());
                if (aiCity.equalsIgnoreCase("not found")) {
                    openFinishWindow();
                    return;
                } else {
                    isCityAvailable = game.isCityAvailable(aiCity);
                    if (!isCityAvailable) {
                        openFinishWindow();
                        return;
                    }
                }
                ComponentsGameWindow.setComputerResponse(aiCity.substring(0, 1).toUpperCase() + aiCity.substring(1));
            } else {
                ComponentsGameWindow.showMessage("Такого міста немає", "Міста немає");
            }
        });
    }
}