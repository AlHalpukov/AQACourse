package lesson002;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.class)
public class LifeCycleJUnitTests {
    @BeforeAll
    void setUpAll() {
        System.out.println(" --> Before all Tests");
    }

    @BeforeEach
    void setUp() {
        System.out.println(" --> Before each Test");
    }

    @AfterEach
    void tearDown() {
        System.out.println(" --> After each Test");
    }

    @AfterAll
    void tearDownAll() {
        System.out.println(" --> After all Tests");
    }

    @Test
    @DisplayName("First Test")
    @Order(1)
    void firstTest() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
        System.out.println(" --> First Test passed");
    }

    @Test
    @DisplayName("Second Test")
    @Order(2)
    void secondTest() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int actualSum = a + b;
        int expectedSun = 8;

        // Assert
        assertEquals(expectedSun, actualSum);
        System.out.println(" --> Second Test passed");
    }
}
