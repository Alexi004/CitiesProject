/**
 * Вести рахунок і валідувати дані від користувача. Треба створити клас, що перевіряє, чи є введене місто коректним,
 * тобто чи воно знаходиться у списку допустимих міст. Основні елементи класу CityValidator:
 * Приватне поле типу String[]: Це масив, який містить список допустимих міст. Його значення передається через конструктор класу.
 * Конструктор: Приймає масив міст і ініціалізує поле значенням, отриманим у конструкторі.
 * Метод, що перевіряє, чи є введене місто в списку допустимих міст. Метод працює за допомогою циклу for-each,
 * який проходиться по всіх елементах масиву. На кожній ітерації порівнюється введене місто з елементом масиву за допомогою методу equalsIgnoreCase(),
 * який порівнює дві рядкові значення незалежно від регістру. Якщо знайдено співпадіння, метод повертає true, що означає, що місто є допустимим.
 * Якщо всі елементи перевірені, і співпадіння не знайдено, метод повертає false, що означає, що місто не є допустимим.
 */

public class CityValidator {
    private final String[] towns;

    public CityValidator(String[] towns) {
        this.towns = towns;
    }

    public CityValidator() {
        this.towns= new String[]{"Київ", "Львів", "Вінниця", "Odessa"}; ///towns for testing
    }

    public boolean checkTown(String town){
        for (String currentTown:towns
             ) {
            if (currentTown.equalsIgnoreCase(town)){
                return true;
            }
        }
        return false;
    }
}
