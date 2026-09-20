import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathAppTest {

    private MathApp app;

    @BeforeEach
    void setUp() {
        CalculatorService calculator = new BasicCalculator();
        app = new MathApp(calculator);
    }

    @Test
    @DisplayName("Test Sum Calculation")
    void testComputeSum() {
        int result = app.computeSum(10, 20);
        assertEquals(30, result, "10 + 20 should equal 30");
    }

    @Test
    @DisplayName("Test Division Success")
    void testComputeDivision() {
        double result = app.computeDivision(10.0, 2.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    @DisplayName("Test Division by Zero Throws Exception")
    void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            app.computeDivision(10.0, 0.0);
        });
    }

    @Test
    @DisplayName("Test Object Not Null")
    void testAppNotNull() {
        assertNotNull(app);
    }

    @Test
    @DisplayName("Test Multiple Assertions")
    void testMultipleOperations() {
        assertAll("Math Operations",
            () -> assertEquals(15, app.computeSum(7, 8)),
            () -> assertEquals(2.0, app.computeDivision(4.0, 2.0))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("Parameterized Test for Addition")
    void testAdditionWithMultipleValues(int number) {
        assertTrue(app.computeSum(number, 5) > 5);
    }
}