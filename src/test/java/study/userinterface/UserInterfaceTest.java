package study.userinterface;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class UserInterfaceTest {

    String inputString;
    UserInterface userInterface = new UserInterface();

    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 + 2"})
    @DisplayName("입력이 잘 되는지")
    void getInputStringWell(String input) {
        String expected = "1 + 3 + 2";
        this.inputString = input;
        assertThat(this.inputString).isEqualTo(expected);
    }

}