package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;
    private Lion lion;
    @Test
    public void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", this.feline);
        assertTrue("У самца должна быть грива", lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", this.feline);
        assertFalse("У самки не должно быть гривы", lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный пол", this.feline);
    }

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", this.feline);
        assertEquals("Количество котят должно быть 2", 2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", this.feline);
        assertEquals("Рацион льва должен совпадать", expectedFood, lion.getFood());
    }
}