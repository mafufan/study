import java.util.Scanner;

class MyException extends Exception {

  static final int LESS = 1;
  static final int OVER = 2;
  private int errorCode = 0;

  MyException(String argMsg, int argCode) {
    // 예외메시지, 예외 코드 저장 구현
    super(argMsg);
    errorCode = argCode;
  }

  int getExceptionCode() {
    // 예외 코드 반환 : errorCode
    return errorCode;
  }
}

class MyConsoleInput {

  static int getInputValue(int argFrom, int argTo)
    throws MyException {
    System.out.println(
      "숫자를 입력 하세요.(" +
      argFrom +
      "이상, " +
      argTo +
      "이하)"
    );
    Scanner sn = new Scanner(System.in);
    int inputInt = sn.nextInt();

    if (inputInt < argFrom) {
      throw new MyException(
        argFrom + "보다 큰 수를 입력하세요. ",
        MyException.LESS
      );
    } else if (inputInt > argTo) {
      throw new MyException(
        argTo + "보다 작은 수를 입력하세요.",
        MyException.OVER
      );
    }
    return inputInt;
  }
}

public class Exgugudan {

  public static void main(String[] args) {
    while (true) {
      try {
        int inputIntValue = MyConsoleInput.getInputValue(
          2,
          9
        );

        for (int i = 1; i <= 9; i++) {
          System.out.println(
            inputIntValue +
            " * " +
            i +
            " = " +
            inputIntValue *
            i
          );
        }
        break;
      } catch (MyException e) {
        System.out.println(
          "에러 메세지 : " +
          e.getMessage() +
          "에러 코드 : " +
          e.getExceptionCode()
        );
      } catch (Exception e) {
        System.out.println(
          "에러 메세지 : " + e.getMessage()
        );
      }
    }
  }
}
