package study.utils;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.zip.DataFormatException;

public class InputValidator {

    private static Pattern pattern;

    // 유틸리티 객체의 인스턴스화 방지를 위해 생성자를 프라이빗으로 만든다.
    private InputValidator() {}

    public static boolean isNumeric(String strNum) {
        pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    public static boolean isOperator(String strOp) {
        pattern = Pattern.compile("[+\\-*\\/]");
        if (strOp == null) {
            return false;
        }
        return pattern.matcher(strOp).matches();
    }

    public static boolean validateUserInput(String[] stringArr) {
        // 숫자, 연산자, 숫자 의 값을 가져야하므로 3 이상의 홀수 길이를 가져야 한다.
        int len = stringArr.length;
        if (len < 3 || len % 2 == 0) return false;

        AtomicInteger index = new AtomicInteger();

//        IntStream.range(0, len).anyMatch(i -> {
//            if (index.getAndIncrement() % 2 == 0) return isNumeric(x);
//            return isOperator(x);
//        });

        // 숫자, 연산자 순으로 나열되는지 검증
        // 모두 true 인 경우에만, true
        boolean result = Arrays.stream(stringArr).allMatch(x -> {
            if (index.getAndIncrement() % 2 == 0) return isNumeric(x);
            return isOperator(x);
        });
        return result;
    }

}
