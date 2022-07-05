class MyCal {

  CalBracket myCal;

  MyCal(CalBracket argCal) {
    myCal = argCal;
  }

  void numPlus(int x, int y) {
    System.out.println("더하기 값:" + myCal.plus(x, y));
  }

  void numMinus(int x, int y) {
    System.out.println("빼기 값:" + myCal.minus(x, y));
  }

  void numMul(int x, int y) {
    System.out.println("곱하기 값:" + myCal.multiple(x, y));
  }

  void numDiv(float x, float y) {
    System.out.println("나누기 값:" + myCal.division(x, y));
  }
}

interface CalBracket {
  int plus(int x, int y);
  int minus(int x, int y);
  int multiple(int x, int y);
  float division(float x, float y);
}

class SuperCal implements CalBracket {

  public int plus(int x, int y) {
    return x + y;
  }

  public int minus(int x, int y) {
    return x - y;
  }

  public int multiple(int x, int y) {
    return x * y;
  }

  public float division(float x, float y) {
    return x / y;
  }
}

public class CalculatorTest {

  public static void main(String[] args) {
    MyCal myCal = new MyCal(new SuperCal());

    System.out.println("Hello, MyCalculator!");
    myCal.numPlus(300, 200);
    myCal.numMinus(300, 200);
    myCal.numMul(300, 200);
    myCal.numDiv(300, 200);
  }
}
