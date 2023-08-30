package com.udemy.register.service;

import com.udemy.register.domain.User;
import com.udemy.register.repository.UserRepository;
import com.udemy.register.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("should_register_user_successfully")
    void should_register_user_successfully() {
        User userBeforeSave = new User(null, "Nicholas", "1234", LocalDate.of(1991, 8, 13));
        User userAfterSave = userBeforeSave;
        userAfterSave.setId("1");
        Mockito.when(userRepository.save(userBeforeSave)).thenReturn(userAfterSave);

        var user = userService.register(userBeforeSave);

        Mockito.verify(userRepository).save(userBeforeSave);
        Assertions.assertEquals(userAfterSave, user);
    }

    @ParameterizedTest
    @ValueSource(ints = {2015, 1960})
    void should_return_error_when_age_is_invalid(Integer year) {
        User user = new User(null, "Nicholas", "1234", LocalDate.of(year, 4, 10));

        var exception = Assertions.assertThrows(RuntimeException.class, () -> userService.register(user));

        Mockito.verifyNoInteractions(userRepository);
        Assertions.assertEquals("Idade não permitida", exception.getMessage());
    }

}