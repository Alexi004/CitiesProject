import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CityValidatorTest {
    private CityValidator cityValidator;

    @BeforeEach
    public void setup() {
        String[] towns = {"Київ", "Львів", "Вінниця", "Одесса" };
        cityValidator = new CityValidator(towns);
    }

    @Test
    public void testValidCity() {
        String validCity = "Київ";
        boolean isValid = cityValidator.checkTown(validCity);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void testInvalidCity() {
        String invalidCity = "Москава";
        boolean isValid = cityValidator.checkTown(invalidCity);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void testCaseInsensitiveCity() {
        String caseInsensitiveCity = "Київ";
        boolean isValid = cityValidator.checkTown(caseInsensitiveCity);
        Assertions.assertTrue(isValid);
    }
    @Test
    public void testDefaultConstructor() {
        CityValidator cityValidator = new CityValidator();

        String[] expectedTowns = {"Київ", "Львів", "Вінниця"};

        // Перевіряємо кожне місто зі списку expectedTowns через метод checkTown()
        for (String town : expectedTowns) {
            boolean isValid = cityValidator.checkTown(town);
            Assertions.assertTrue(isValid);
        }
    }
}
