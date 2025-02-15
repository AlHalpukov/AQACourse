package lesson002;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParametrizedTests {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void sourceTest(int parameter) {
        // Arrange

        // Act
        int expectedSum = parameter + parameter;
        int actualSum = 2 * parameter;

        // Assert
        assertEquals(expectedSum, actualSum);
    }

    @ParameterizedTest
    @CsvSource({"John, Doe", "Alice, Smith"})
    void csvTest(String firstName, String lastName) {
        // Arrange
        List<String> expectedPeople = Arrays.asList("John Doe", "Alice Smith");

        // Assert
        assertTrue(expectedPeople.contains(firstName + " " + lastName));
    }

    static Stream<String> provideStreams() {
        return Stream.of("One", "Two", "Three");
    }

    @ParameterizedTest
    @MethodSource("provideStreams")
    void customParameterTest(String parameter) {
        // Arrange
        List<String> expectedList = Arrays.asList("one", "two", "three");

        // Assert
        assertTrue(expectedList.contains(parameter.toLowerCase(Locale.ROOT)));
    }
}
