package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final Animal animal = new Animal();
    private final String animalKind;
    private final List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")}
        });
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actualFood = animal.getFood(animalKind);
        assertNotNull(actualFood);
        assertEquals(expectedFood.size(), actualFood.size());
        assertTrue(actualFood.containsAll(expectedFood));
    }

    @Test
    public void testGetFoodException() {
        Throwable throwable = assertThrows(Exception.class, () -> {
            animal.getFood("unsupported animal kind");
        });
        assertEquals(Exception.class, throwable.getClass());
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", throwable.getMessage());
    }

    @Test
    public void testGetFamily() {
        String actual = animal.getFamily();
        assertEquals("Ответ не соответствует ожидаемому",
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        List<String> food = animal.getFood("Травоядное"); // Обратите внимание на опечатку
        assertNotNull(food);
        assertEquals(2, food.size());
        assertTrue(food.contains("Трава"));
        assertTrue(food.contains("Различные растения"));
    }
}
