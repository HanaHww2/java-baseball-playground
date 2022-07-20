package study.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.model.InputData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.DataFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InputValidatorTest {
    InputData inputString;

    @BeforeEach
    void setUp() {
        this.inputString = new InputData.Builder().inputString("1 + 2 + 3").build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("input 데이터를 잘 검증하는지")
    void ifValidationWorkingWell() {
        Boolean expected = true;
        String[] arr = new String[]{"1", "+", "2", "+", "3"};
        assertThat(InputValidator.validateUserInput(arr)).isEqualTo(expected);
    }
    @Test
    @DisplayName("input 데이터(단일)에 문제가 있는 경우 false를 잘 반환하는지")
    void ifValidationWorkingWell2() {
        Boolean expected = false;
        String[] arr = new String[]{"1", "3", "2", "+", "3"};
        assertThat(InputValidator.validateUserInput(arr)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    @DisplayName("input 데이터(복수개)에 문제가 있는 경우 false를 잘 반환하는지")
    void getInputStringWell(List<String> list) {
        Boolean expected = false;
        String[] arr = (String[]) list.toArray();
        assertThat(InputValidator.validateUserInput(arr)).isEqualTo(expected);
    }
    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(Arrays.asList("1", "3", "2", "+", "3")),
                arguments(Arrays.asList(""))
        );
    }
}