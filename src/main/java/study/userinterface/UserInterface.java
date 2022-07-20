package study.userinterface;

import study.model.InputData;

import java.util.Scanner;

public class UserInterface {
    // 스캐너 클래스를 static final 멤버 변수로 선언
    // 외부에서 사용시 싱글톤 전략을 구현해 볼 수 있다.
    private static final Scanner scanner = new Scanner(System.in);
    private InputData userInputData;

    /*
    * 스캐너를 통해 받은 입력값을 UserInputData 객체에 담는다.
    * */
    public String scanUserInputString() {
        String input = scanner.nextLine();
        userInputData = new InputData.Builder().inputString(input).build();
        return input;
    }
}
