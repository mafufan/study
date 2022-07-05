import java.util.Scanner;

public class app {

  Scanner sc = new Scanner(System.in);
  String keyInput;
  int number;
  int count = 0;

  void print() {
    System.out.println("1 이상의 정수를 입력하세요");
  }

  void IsThisNumber(String KeyInput) {
    if (keyInput.equals("q")) {
      number = 20000;
      return;
    }
    number = Integer.parseInt(keyInput);
  }

  void inputNum() {
    while (true) {
      keyInput = sc.nextLine();
      IsThisNumber(keyInput);
      if (!(number >= 1)) {
        System.out.println("1 이상의 양수를 입력해주세요.");
        continue;
      }
      break;
    }
  }

  void OddOrEven() {
    if (number % 2 == 0) {
      System.out.println("짝수 입니다.");
      return;
    }
    System.out.println("홀수 입니다.");
  }

  void multipleOfNum() {
    if (number % 3 == 0) {
      System.out.println("3의 배수 입니다.");
    }
    if (number % 7 == 0) {
      System.out.println("7의 배수 입니다.");
    }
  }

  void result() {
    count++;
    System.out.printf(
      "%d번째 입력 값은 = %d\n",
      count,
      number
    );
  }

  void start() {
    while (true) {
      print();
      inputNum();
      if (number == 20000) {
        break;
      }
      result();
      OddOrEven();
      multipleOfNum();
    }
    end();
  }

  void end() {
    System.out.println("프로그램 종료");
  }

  public static void main(String[] args) {
    app m = new app();
    m.start();
  }
}
