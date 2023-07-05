import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityValidatorTest {
    private CityValidator cityValidator;

    @BeforeEach
    public void setup() {
        String[] towns = {"Kyiv", "Lviv", "Vinnytsya", "Odessa" };
        cityValidator = new CityValidator(towns);
    }

    @Test
    public void testValidCity() {
        String validCity = "Kyiv";
        boolean isValid = cityValidator.checkTown(validCity);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testInvalidCity() {
        String invalidCity = "Moskva";
        boolean isValid = cityValidator.checkTown(invalidCity);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testCaseInsensitiveCity() {
        String caseInsensitiveCity = "kYiV";
        boolean isValid = cityValidator.checkTown(caseInsensitiveCity);
        Assertions.assertTrue(isValid);
    }
    @Test
    public void testDefaultConstructor() {
        CityValidator cityValidator = new CityValidator();

        String[] expectedTowns = {"Kyiv", "Lviv", "Vinnytsya"};

        // Перевіряємо кожне місто зі списку expectedTowns через метод checkTown()
        for (String town : expectedTowns) {
            boolean isValid = cityValidator.checkTown(town);
            Assertions.assertTrue(isValid);
        }
    }
}
