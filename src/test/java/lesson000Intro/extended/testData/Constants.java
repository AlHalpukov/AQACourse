package lesson001.extended.testData;


import lesson001.extended.models.User;

public class Constants {
    public static final User DEFAULT_USER = User.builder()
            .id(0)
            .username("string")
            .firstName("string")
            .lastName("string")
            .email("string")
            .password("string")
            .phone("string")
            .userStatus(0)
            .build();
}
