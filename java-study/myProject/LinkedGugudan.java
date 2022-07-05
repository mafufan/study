import java.util.Scanner;

class MyException extends Exception {

  static final int LESS = 1;
  static final int OVER = 2;
  int ERR_CODE = 0;

  MyException(String argMsg, int argCode) {
    super(argMsg);
    ERR_CODE = argCode;
  }

  public int getERR_CODE() {
    return ERR_CODE;
  }
}

class MyConsoleInput {

  static int getInputValue(int argFrom, int argTo)
    throws MyException {
    System.out.println("정수 입력 :");
    Scanner sn = new Scanner(System.in);
    int inputValue = sn.nextInt();
    if (inputValue < argFrom) {
      throw new MyException(
        argFrom + "보다 큰 수를 입력하세요",
        MyException.LESS
      );
    } else if (inputValue > argTo) {
      throw new MyException(
        argTo + "보다 작은 수를 입력하세요",
        MyException.OVER
      );
    }
    return inputValue;
  }
}

class Gugudan {

  static void getGugudan(int argValue) {
    for (int i = 1; i <= 9; i++) {
      System.out.printf(
        "%d * %d = %d\n",
        argValue,
        i,
        argValue * i
      );
    }
  }
}

public class LinkedGugudan {

  public static void main(String[] args) {
    while (true) {
      try {
        int inputValue = MyConsoleInput.getInputValue(2, 9);
        Gugudan.getGugudan(inputValue);
        break;
      } catch (MyException e) {
        System.out.println("ERROR : " + e.getMessage());
        System.out.println("ERR_CODE : " + e.getERR_CODE());
      } catch (Exception e) {
        System.out.println(
          "Undefined exception, Get the input value again"
        );
      }
    }
  }
}
