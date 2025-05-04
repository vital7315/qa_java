import com.example.Feline;
import com.example.Lion;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class LionParametrizedTest {

    private Object[] lionSexParams() {
        return new Object[] {
                new Object[] { "Самец", true },
                new Object[] { "Самка", false }
        };
    }

    @Test
    @Parameterized.Parameters(method = "lionSexParams")
    public void testDoesHaveMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}