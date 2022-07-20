package study.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("분리가 잘 되어서 배열이 반환되는지 확인")
    void split_test1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("단일 값을 가졌을 때, 분리가 잘 되어서 배열이 반환되는지 확인")
    void split_test2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("문자열 슬라이싱이 잘 되는지 확인")
    void substring_test() {
        String actual = "(1,2)"
                .substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 인덱싱이 잘 되는지 확인")
    void charAt_test() {
        String actual = String.valueOf("abc".charAt(1));
        assertThat(actual).isEqualTo("b");
    }

    @Test
    @DisplayName("인덱싱 중 IndexOutOfBounds 관련 예외처리가 되는지 확인")
    void handleCharAtException_test() {
        assertThatThrownBy(() -> { char actual = "abc".charAt(4); }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @Test
    @DisplayName("인덱싱 중 IndexOutOfBounds 관련 예외처리가 되는지 확인")
    void handleCharAtException_test_b() {
        try {
            char actual = "abc".charAt(4);
        } catch(StringIndexOutOfBoundsException e) {
            String actual = e.getMessage();
            assertThat(actual).isEqualTo("String index out of range: 4");
        }
    }
}
