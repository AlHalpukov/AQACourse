package lesson002;

import lesson002.extensions.LifecycleExtension;
import lesson002.extensions.ParameterExtension;
import lesson002.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtensionJUnitTest {
    @Test
    @ExtendWith(LifecycleExtension.class)
    void jUnitTestWithLifeCycleExtension() {
        // Arrange
        int actualSum = 1 + 1;
        int expectedSum = 2;

        // Assert
        assertEquals(expectedSum, actualSum);
        System.out.println("jUnit Test With Extend");
    }

    @Test
    @ExtendWith(ParameterExtension.class)
    void jUnitTestWithParameterExtend(User user) {
        assertAll(
                () -> assertEquals("John", user.getFirstName()),
                () -> assertEquals("Doe", user.getLastName()),
                () -> assertEquals(30, user.getAge())
        );
    }
}
