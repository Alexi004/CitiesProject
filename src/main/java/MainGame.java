import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainGame {
    Player player;
    String lastCity;
    HashMap<String, Integer> cities;
    String[] citiesByIndex;
    int turnCounter;

    public MainGame(Player player, HashMap<String, Integer> cities) {
        this.player = player;
        this.cities = cities;
        this.citiesByIndex = (String[]) cities.keySet().toArray();
        this.turnCounter = 1;
    }
    private String getRandomCity(char firstChar){
        if (firstChar=='0'){
            int randomIndex = new Random().nextInt(cities.size());
            return citiesByIndex[randomIndex];
        }else {
            //todo get random city that begin from firstChar
            for (Map.Entry<String ,Integer> city:cities.entrySet()
                 ) {
                if (city.getKey().charAt(0) == firstChar) {
                    return  city.getKey();
                }
            }
        }
        return "not found";
    }
    public static void main(String[] args) {
        MainGame game = new MainGame(new Player("testName"), loadCities("cities.txt"));
        //first turn
        String aiCity="Киів";//game.getRandomCity('0');
        while (true){

        if (game.isCityAvailable(aiCity)) {
            System.out.println("Turn "+aiCity + " 1 " +game.turnCounter);
        }else {
            System.out.println("ai loss at turn:"+game.turnCounter);
            break;
        }
        //player answer
        String answer="Вінниця";
            if (game.isCityAvailable(aiCity)) {
                System.out.println("Turn "+answer + " 2 "+game.turnCounter);
            }else {
                System.out.println("player loss at turn:"+game.turnCounter);
            }
        }
    }

    public static HashMap<String,Integer> loadCities(String fileName) {
        HashMap<String,Integer> cities = new HashMap<>();
        cities.put("Київ", 0);
        cities.put("Львів", 0);
        cities.put("Вінниця", 0);
        cities.put("Odessa", 0);
        return cities;

    }

    public boolean isCityAvailable(String city) {
        if (city.charAt(0)!=getLastCitySymbol()){
            return false;
        }
        if (cities.getOrDefault(city, 1) == 0) {
            turnCounter += 1;
            cities.put(city, turnCounter);
            return true;
        } else {
            return false;
        }
    }
    private char getLastCitySymbol() {
        char lastSymbol = lastCity.charAt(lastCity.length()-1);
        if (lastSymbol != 'ь') {
            return lastSymbol;
        }
        return lastCity.charAt(lastCity.length() - 2);
    }

}
