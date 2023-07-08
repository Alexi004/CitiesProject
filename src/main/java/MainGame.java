import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainGame {
    Player player;
    String lastCity;
    HashMap<String, Integer> cities;
    int turnCounter;

    public MainGame(Player player, HashMap<String, Integer> cities) {
        this.player = player;
        this.cities = cities;
        this.turnCounter = 1;
    }
    private String getRandomCity(){
        String cityString="Town 404";
        int randomIndex = new Random().nextInt(15);
        char rndChar=(char) (((byte)'c')+randomIndex);
        for (Map.Entry<String ,Integer> city:cities.entrySet()
             ) {
            if (city.getKey().charAt(0) == rndChar) {
                cityString = city.getKey();
            }
        }
        return cityString;
    }
    public static void main(String[] args) {
        MainGame game = new MainGame(new Player("testName"), loadCities("cities.txt"));
        //first turn
        String aiCity=game.getRandomCity();

        if (game.isCityAvailable("Львів")) {
            System.out.println("Львів" + " 1");
        }
        if (game.isCityAvailable("Львів")) {
            System.out.println("Львів" + " 2");
        }
    }

    public static HashMap loadCities(String fileName) {
        HashMap cities = new HashMap();
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
        char lastSymbol = lastCity.charAt(lastCity.length());
        if (lastSymbol != 'ь') {
            return lastSymbol;
        }
        return lastCity.charAt(lastCity.length() - 1);
    }

}
