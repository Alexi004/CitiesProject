import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainGame {
    Player player;
    private String lastCity;
    HashMap<String, Integer> cities;
    String[] citiesByIndex;
    int turnCounter;

    public MainGame(Player player, HashMap<String, Integer> cities) {
        this.player = player;
        this.cities = cities;
        this.citiesByIndex = cities.keySet().toArray(String[]::new);
        this.turnCounter = 1;
    }

    private String getRandomCity(char firstChar) {
        if (firstChar == '0') {
            int randomIndex = new Random().nextInt(cities.size());
            return citiesByIndex[randomIndex];
        } else {
            //todo get random city that begin from firstChar
            for (Map.Entry<String, Integer> city : cities.entrySet()
            ) {
                if (Character.toLowerCase(city.getKey().charAt(0)) == firstChar) {
                    if (cities.get(city.getKey())==0)
                        return city.getKey();
                }
            }
        }
        return "not found";
    }

    public static void main(String[] args) {
        MainGame game = new MainGame(new Player("testName"), loadCities("src\\main\\resources\\cities.txt"));
        //first turn
        String aiCity = "Київ";//game.getRandomCity('0');
        game.setLastCity(String.valueOf(aiCity.charAt(0)).toLowerCase());
        //first ai turn
        game.isCityAvailable(aiCity);
        System.out.println("Turn " + aiCity + " 1 " + game.turnCounter);
        while (true) {
            //player answer
            String answer = game.getRandomCity(game.getLastCitySymbol());
            if (game.isCityAvailable(answer)) {
                System.out.println("Turn " + answer + " 2 " + game.turnCounter);
            } else {
                System.out.println("Turn " + answer +" player loss at turn:" + game.turnCounter);
            }
            aiCity=game.getRandomCity(game.getLastCitySymbol());
            if (game.isCityAvailable(aiCity)) {
                System.out.println("Turn " + aiCity + " 1 " + game.turnCounter);
                game.cities.put(aiCity, game.turnCounter);
            } else {
                System.out.println("ai loss at turn:" + game.turnCounter);
                break;
            }
        }
    }

    public static HashMap<String, Integer> loadCities(String fileName) {
        HashMap<String, Integer> cities = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line= reader.readLine())!=null){
                cities.put(line,0);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        //for testing
        cities.put("Київ", 0);
        cities.put("Львів", 0);
        cities.put("Вінниця", 0);
        cities.put("Odessa", 0);
        cities.put("Яворів", 0);
        cities.put("Васильків", 0);
        cities.put("Виноградів", 0);
        return cities;

    }

    public boolean isCityAvailable(String city) {
        if (Character.toLowerCase(city.charAt(0)) != getLastCitySymbol()) {
            return false;
        }
        if (cities.getOrDefault(city, 1) == 0) {
            turnCounter += 1;
            cities.put(city, turnCounter);
            lastCity = city;
            return true;
        } else {
            return false;
        }
    }

    private char getLastCitySymbol() {

        String lastCity= getLastCity();
        for (int i = lastCity.length(); i >0 ; i--) {
            char lastSymbol = lastCity.charAt(i-1);
            if (lastSymbol != 'ь' && lastSymbol != 'й' && lastSymbol != 'и') {
                return lastSymbol;
            }
        }
        return getLastCity().charAt(getLastCity().length() - 2);
    }

    public String getLastCity() {
        return lastCity;
    }

    public void setLastCity(String lastCity) {
        this.lastCity = lastCity;
    }
}
