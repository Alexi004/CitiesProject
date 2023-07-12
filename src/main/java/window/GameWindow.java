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
    private void openFinishWindow(String finishMessage){
        components.closeGameWindow();
        int lastTurn = game.getTurnCounter();
        int computerScore = lastTurn/2-1 ;
        int playerScore = lastTurn/2;
        SwingUtilities.invokeLater(() -> new FinishWindow(computerScore, playerScore, playerName));
        return;
    }

    private void initComponents() {
        components.createFrame();

        components.getButton().addActionListener(e -> {
            String userInput = components.getUserInput();
            if (userInput.equalsIgnoreCase("здаюсь")) {
                openFinishWindow("здаюсь");
                return;
            }
            boolean isCityAvailable = game.isCityAvailable(userInput);

            if (isCityAvailable) {
                String aiCity = game.getRandomCity(game.getLastCitySymbol());
                if (aiCity.equalsIgnoreCase("not found")) {
                    openFinishWindow("комп здаеться");
                    //components.showMessage("AI loss at turn " + game.getLastCitySymbol(), "AI loss");
                    return;
                } else {
                    isCityAvailable = game.isCityAvailable(aiCity);
                    if (!isCityAvailable) {
                        openFinishWindow("комп здаеться - шось пішло не так");
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
