import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ru.vsu.amm.poiais.Calculator;

/**
 * Run 'mvn clean test jacoco:report jacoco:check@default-check' to see report
 */
public class CalculatorTest {
    
    @Test
    public void testCalculator() {
        // given
        Calculator calc = new Calculator();
        // when
        double sum = calc.add(3.2, 5.4);
        // then
        assertEquals(8.6, sum, 0.0001f);
    }
}
