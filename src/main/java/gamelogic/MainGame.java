package gamelogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainGame {
    private final HashMap<String, Integer> citiesMap;
    private String lastCity;
    private int turnCounter;

    public MainGame(String[] cities) {
        this.citiesMap = new HashMap<>();
        for (String city : cities) {
            this.citiesMap.put(city.toLowerCase(), 0);
        }
        this.turnCounter = 1;
    }

    public String getRandomCity(char firstChar) {
        List<String> availableCities = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : citiesMap.entrySet()) {
            String city = entry.getKey();
            if (Character.toLowerCase(city.charAt(0)) == firstChar && entry.getValue() == 0) {
                availableCities.add(city);
            }
        }
        if (!availableCities.isEmpty()) {
            int randomIndex = new Random().nextInt(availableCities.size());
            return availableCities.get(randomIndex);
        } else {
            return "not found";
        }
    }

    public boolean isCityAvailable(String city) {
        city = city.toLowerCase();
        if (lastCity != null) {
            if (city.charAt(0) != getLastCitySymbol()) {
                return false;
            }
        }
        if (citiesMap.containsKey(city) && citiesMap.get(city) == 0) {
            citiesMap.put(city, turnCounter);
            lastCity = city;
            turnCounter++;
            return true;
        } else {
            return false;
        }
    }

    public char getLastCitySymbol() {
        if (lastCity != null && !lastCity.isEmpty()) {
            String lastCityLowerCase = lastCity.toLowerCase();
            for (int i = lastCityLowerCase.length(); i > 0; i--) {
                char lastSymbol = lastCityLowerCase.charAt(i - 1);
                if (lastSymbol != 'ь' && lastSymbol != 'й' && lastSymbol != 'и') {
                    return lastSymbol;
                }
            }
            return lastCityLowerCase.charAt(lastCityLowerCase.length() - 2);
        } else {
            return '0';
        }
    }

    public int getPlayerScore() {
        return turnCounter - 1;
    }
}