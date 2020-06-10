package land.gomi.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * CalculatorTest class
 */
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    /**
     * Sum
     */
    @Test
    public void sum() {
        assertEquals(5, calculator.sum(2, 3));
    }

    /**
     * Sub
     */
    @Test
    public void sub() {
        assertEquals(1, calculator.sub(3, 2));
    }
}
