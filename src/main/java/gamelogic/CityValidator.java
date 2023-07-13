package gamelogic;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        try (InputStream inputStream = CityValidator.class.getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8))) {
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