package study.model;


import study.utils.InputValidator;

import java.util.zip.DataFormatException;

public class InputData {

    /* 속성이 하나인 클래스이지만, 추후 (만에 하나) 발생할 확장성 (+ 그냥 연습용으로 )을 고려하여 빌더 패턴을 적용했다. */
    private String inputString;
    private String[] stringArr;

    public static class Builder {
        private String inputString = "";

        public Builder() {}
        public Builder inputString(String val) {
            inputString = val;
            return this;
        }
        public InputData build() {
            return new InputData(this);
        }
    }

    private InputData(Builder builder) {
        inputString = builder.inputString;
    }
    public String getInputString() {
        return this.inputString;
    }
    public String[] getStringArr() { return this.stringArr; }

    public void printInputData() {
        System.out.println(this.inputString);
    }
    public String[] splitInputString() {
        // 빈 공백 문자열을 기준으로 문자들을 분리
        String[] arr = this.inputString.split(" ");
        if (confirmData(arr)) this.stringArr = arr;
        return this.stringArr;
    }

    /*
    * valid 하지 않은 값이 입력되면 예외를 발생시킨다.
    * */
    boolean confirmData(String[] tempArr) {
        boolean result = InputValidator.validateUserInput(tempArr);
        if (!result) throw new RuntimeException(this.inputString + " : 데이터 입력값이 잘못되었습니다.");
        return true; // 항상 true... 예외 발생에 대해 좀 더 고민해볼 필요가 있다.
    }
}
