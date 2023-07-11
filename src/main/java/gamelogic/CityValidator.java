package gamelogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityValidator {
    private final String[] towns;

    public CityValidator(String[] towns) {
        this.towns = towns;
    }

    public CityValidator() {
        this.towns = new String[]{"Київ", "Львів", "Вінниця"}; // default cities
    }

    public static String[] loadCities(String fileName) {
        List<String> cities = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cities.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities.toArray(new String[0]);
    }

    public boolean checkTown(String town) {
        for (String currentTown : towns) {
            if (currentTown.equalsIgnoreCase(town)) {
                return true;
            }
        }
        return false;
    }
}