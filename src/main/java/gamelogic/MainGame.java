package gamelogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainGame {
    private final Player player;
    private String lastCity;
    private final HashMap<String, Integer> cities;
    private int turnCounter;

    public MainGame(Player player, String[] cities) {
        this.player = player;
        this.cities = new HashMap<>();
        for (String city : cities) {
            this.cities.put(city.toLowerCase(), 0);
        }
        this.turnCounter = 1;
    }

    public String getRandomCity(char firstChar) {
        List<String> availableCities = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
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
        if (lastCity!=null) { //if not first turn
            if (city.charAt(0) != getLastCitySymbol()) {
                return false;
            }
        }
        if (cities.containsKey(city) && cities.get(city) == 0) {
            cities.put(city, turnCounter);
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

    @SuppressWarnings("unused")
    public String getLastCity() {
        return lastCity;
    }

    @SuppressWarnings("unused")
    public void setLastCity(String lastCity) {
        this.lastCity = lastCity;
    }


    public void addCity(String userCity, String aiCity) {
        cities.put(userCity.toLowerCase(), turnCounter);
        cities.put(aiCity.toLowerCase(), turnCounter);
        turnCounter++;
    }

    public int getPlayerScore() {
        return turnCounter - 1;
    }

    public Player getPlayer() {
        return player;
    }

    @SuppressWarnings("unused")
    public boolean isAllCitiesUsed() {
        for (int value : cities.values()) {
            if (value == 0) {
                return false;
            }
        }
        return true;
    }
}