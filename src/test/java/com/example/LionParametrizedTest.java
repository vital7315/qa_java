package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    @Mock
    private Feline feline;

    private String sex;
    private boolean expectedHasMane;

    public LionParametrizedTest(String sex, boolean expectedHasMane){
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }
    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false }
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}