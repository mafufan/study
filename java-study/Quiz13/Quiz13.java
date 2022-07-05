import java.util.Scanner;

class MyException extends Exception { // Exception 클래스로부터 상속

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

  // 사용자로부터 키보드를 통해 argFrom 이상, argTo 이하 값 입력 후 반환
  // argFrom 미만 또는 argTo 초과 값 입력 시 MyException 예외 발생 후 throw

  static int getInputValue(int argFrom, int argTo)
    throws MyException {
    System.out.println("정수를 입력하세요");
    Scanner sn = new Scanner(System.in);
    int N = sn.nextInt();
    if (N < argFrom) {
      throw new MyException(
        argFrom + " 보다 큰 수를 입력 하세요",
        MyException.LESS
      );
    } else if (N > argTo) {
      throw new MyException(
        argTo + " 보다 작은 수를 입력 하세요",
        MyException.OVER
      );
    }
    return N;
  }
}

class Gugudan {

  static void printGugudan(int inputValue) {
    for (int i = 1; i < 10; i++) {
      System.out.printf(
        "%d * %d = %d\n",
        inputValue,
        i,
        inputValue * i
      );
    }
  }
}

public class Quiz13 {

  public static void main(String[] args) {
    while (true) {
      try {
        int inputValue = MyConsoleInput.getInputValue(2, 9);
        Gugudan.printGugudan(inputValue);
        // 입력 값에 대한 구구단 출력 구현
        break;
      } catch (MyException e) {
        System.out.println(
          "에러 메세지 : " + e.getMessage()
        );
        System.out.println(
          "에러 코드 : " + e.getExceptionCode()
        );
      } catch (Exception e) {
        System.out.println(
          "Undefined exception, Get the input value again"
        );
      }
    }
  }
}
