import java.util.Scanner;

class MyException extends Exception {

  MyException(String argMsg) {
    super(argMsg);
  }
}

class Calculator {

  int x;
  int y;

  Calculator(int argX, int argY) {
    x = argX;
    y = argY;
  }

  int plus() throws MyException {
    return x + y;
  }
}

class MyConsoleInput {

  static int getInputValue(int argX, int argY)
    throws MyException {
    if (argX < 0 || argX < 0) {
      throw new MyException("0보다 큰수를 입력하세요.");
    }
    Calculator myCal = new Calculator(argX, argY);

    return myCal.plus();
  }
}

public class ExCal {

  public static void main(String[] args) {
    while (true) {
      try {
        Scanner sn = new Scanner(System.in);
        System.out.println("x를 입력하세요");
        int inputX = sn.nextInt();
        System.out.println("y를 입력하세요");
        int inputY = sn.nextInt();
        System.out.println(
          MyConsoleInput.getInputValue(inputX, inputY)
        );

        break;
      } catch (MyException e) {
        System.out.println(e.getMessage());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
