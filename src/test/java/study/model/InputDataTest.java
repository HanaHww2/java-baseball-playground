package study.model;

import org.assertj.core.api.ObjectArrayAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputDataTest {

    InputData inputData;

    @BeforeEach
    void setUp() {
        this.inputData = new InputData.Builder().inputString("1 + 2 + 3").build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("input 데이터가 기대한 값과 동일한지 확인")
    void chkInputData() {
        String expected = "1 + 2 + 3";
        assertThat(inputData.getInputString()).isEqualTo(expected);
    }

    @Test
    @DisplayName("input 데이터가 잘 분리되는지 확인")
    void splitInputDataWell() {
        String[] expected = new String[]{"1", "+", "2", "+", "3"};
        assertThat(this.inputData.splitInputString()).isEqualTo(expected);
    }

    /*
    * 에러를 발생시키는 위치를 검증 클래스로 옮겨야 할 것 같기도?
    * */
    @Test
    @DisplayName("데이터 검증 과정에서 관련 예외처리가 되는지 확인")
    void handleCharAtException_test() {
        assertThatThrownBy(() -> { this.inputData.confirmData(new String[] {"5", "-"}); }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining(" : 데이터 입력값이 잘못되었습니다.");
    }
}