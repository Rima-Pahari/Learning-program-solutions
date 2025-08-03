import org.junit.jupiter.api.*; // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*; // for assertions

public class CalculatorTest {

    private Calculator calculator;

    // Setup method: runs before each test
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup executed");
    }

    // Teardown method: runs after each test
    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Teardown executed");
    }

    // Test for addition using AAA pattern
    @Test
    void testAddition() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result, "5 + 3 should be 8");
    }

    // Test for subtraction using AAA pattern
    @Test
    void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result, "10 - 4 should be 6");
    }
}