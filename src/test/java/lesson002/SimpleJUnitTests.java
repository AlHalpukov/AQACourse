package lesson002;

import org.junit.jupiter.api.*;
import lesson002.models.User;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleJUnitTests {
    @Test
    void simpleJUnitTest() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
    }

    @Test
    @Disabled("It show how to work this annotation")
        // Test will not run
    void simpleDisabledJUnitTest() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
    }

    @Test
    @DisplayName("Summarize two numbers")
        // Test will show Test description in report
    void simpleTestWithName() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
    }

    @Test
    @Tag("smoke")
    void simpleTestWithTagAnnotation() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
    }

    @Test
    @Tags({@Tag("smoke"), @Tag("defect")})
    @Timeout(2)
    void simpleTestWithTagsAnnotation() throws InterruptedException {
        // Arrange
        Thread.sleep(2000);
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
    }

    @RepeatedTest(value = 2, name = "{displayName}" +
            " - repeat {currentRepetition} from {totalRepetition}")
    @DisplayName("Test with Repetition")
    void simpleTestWithRepeatAnnotation() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
    }

    @Test
    void testWithTrueFalseAssert() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertTrue(expectedSun == actualSum);
        assertFalse(expectedSun != actualSum);
    }

    @Test
    void testWithException() {
        // Arrange
        String test = null;

        // Act
        Exception ex = assertThrows(NullPointerException.class, () -> test.length());

        // Assert
        Assertions.assertEquals("Cannot invoke \"String.length()\" " +
                "because \"test\" is null", ex.getMessage());
    }

    @Test
    void testWithAssertAll() {
        User user = new User("Ivan", "Ivanov", 35);
        assertAll(
                () -> assertEquals("Ivan", user.getFirstName(), "Wrong First Name"),
                () -> assertEquals("Ivanov", user.getLastName(), "Wrong Last Name"),
                () -> assertEquals(35, user.getAge(), "Wrong First Name")
        );
    }

    @Test
    void testWithSeparateAssertions() {
        // Arrange
        User user = new User("Ivan", "Ivanov", 35);

        // Assert
        assertEquals("Ivan", user.getFirstName(), "Wrong First Name");
        assertEquals("Ivanov", user.getLastName(), "Wrong Last Name");
        assertEquals(35, user.getAge(), "Wrong First Name");
    }

    @Test
    void firstTest() throws InterruptedException {
        System.out.println("First Parallel Unit Test start => "+ Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("First Parallel Unit Test end => "+ Thread.currentThread().getName());
    }

    @Test
    void secondTest() throws InterruptedException {
        System.out.println("Second Parallel Unit Test start => "+ Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("Second Parallel Unit Test end => "+ Thread.currentThread().getName());
    }
}
