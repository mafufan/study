import java.util.Scanner;

public class quiz2 {
  public static void main(String[] args) {
    Scanner inputNum = new Scanner(System.in); // Scanner 객체 생성
    int number = 0; // 입력 받은 숫자 값
    int runIdx = 1; // 프로그램 실행 index

    while (true) {
      number = inputNum.nextInt(); // 콘솔 창으로 값을 입력 받음

      if (number <= 0) { // 음수를 입력 했을 때
        System.out.println("1이상 양수를 입력해주세요");
        continue;
      }
      if (number == 20000) { // 20000 입력시 종료
        break;
      }

      System.out.printf("%d번째 입력 값은 = %d %n", runIdx, number);
      runIdx++; // 실행 index 증가

      if (number % 1 == 0) { // 홀수 일때
        if (number % 2 == 0) { // 짝수 일때
          System.out.println("짝수입니다.");
          if (number % 3 == 0) {
            System.out.println("3의 배수입니다.");
          }
          if (number % 7 == 0) {
            System.out.println("7의 배수입니다.");
          }
          continue; // if 문 빠져나오기
        }
        System.out.println("홀수입니다.");
        if (number % 3 == 0) {
          System.out.println("3의 배수입니다.");
        }
        if (number % 7 == 0) {
          System.out.println("7의 배수입니다.");
        }
      }
    }
    System.out.println("이용해주셔서 감사합니다");
    inputNum.close(); // scanner close
  }
}
