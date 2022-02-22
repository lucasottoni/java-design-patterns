package br.com.sky.dp.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserBuilderTest {

    @Test
    public void fullUser() {
        User user = new User.Builder("User", "Full")
                .address("Rua X")
                .age(10)
                .phone("11 99999 8888")
                .build();

        assertEquals("User", user.getFirstName());
        assertEquals("Full", user.getLastName());
        assertEquals(10, user.getAge());
        assertEquals("Rua X", user.getAddress());
        assertEquals("11 99999 8888", user.getPhone());
    }

    @Test
    public void partialUser() {
        User user = new User.Builder("User", "Full")
                .age(10)
                .build();

        assertEquals("User", user.getFirstName());
        assertEquals("Full", user.getLastName());
        assertEquals(10, user.getAge());
        assertNull(user.getAddress());
        assertNull(user.getPhone());
    }

    @DisplayName("Creating user using only required fields")
    @Test
    public void onlyRequiredUser() {
        User user = new User.Builder("User", "Full")
                .build();

        assertEquals("User", user.getFirstName());
        assertEquals("Full", user.getLastName());
        assertEquals(0, user.getAge());
        assertNull(user.getAddress());
        assertNull(user.getPhone());
    }

    @Test
    public void invalidUser() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new User.Builder("User", "Full")
                        .age(-10)
                        .build()
        );

        assertEquals("Age cannot be negative", illegalArgumentException.getMessage());
    }
}
