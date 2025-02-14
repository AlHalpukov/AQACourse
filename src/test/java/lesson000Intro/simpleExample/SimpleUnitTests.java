package lesson000Intro.simpleExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleUnitTests {
    @Test
    void checkSumOfTwoNumbers() {
        // Average
        int a = 1;
        int b = 2;

        // Act
        int c = a + b;

        // Assert
        Assertions.assertEquals(3, c);
    }
}
