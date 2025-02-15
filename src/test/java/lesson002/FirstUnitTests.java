package lesson002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUnitTests {
    @Test
    void sumNumbersTest() {
        // Arrange
        int a = 3;
        int b = 2;

        // Act
        int c = a + b;

        //Assert
        assertEquals(5, c);
    }
}
