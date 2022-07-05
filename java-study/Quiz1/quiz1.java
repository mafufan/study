
import java.util.Scanner;

public class quiz1 {
  public static void main(String[] args) {
    Scanner inputNum = new Scanner(System.in); // Scanner 객체 생성
    int selectNum = 0; // 입력 받은 숫자 값

    while (true) { // 2를 입력 받을 때 까지 반복
      System.out.println("-------------");
      System.out.println("1. 구구단 출력");
      System.out.println("2. 프로그램 종료");
      System.out.println("-------------");
      selectNum = inputNum.nextInt(); // 콘솔 창으로 값을 입력 받음

      if (selectNum == 2) { // 구구단 종료
        break;
      }

      if (!(selectNum == 1 || selectNum == 2)) { // 1 또는 2 입력이 아닐 시
        System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
        continue; // 반복문 다시 실행
      }

      while (selectNum == 1) { // 1을 입력 했을 때.
        System.out.print("출력할 구구단의 단을 입력하세요.");
        System.out.println("구구단의 단은 2~9 사이 입력");
        selectNum = inputNum.nextInt();

        while (selectNum < 2 || 9 < selectNum) {
          System.out.println("2~9사이 정수를 입력해주세요");
          selectNum = inputNum.nextInt();
        }
        for (int i = 1; i < 10; i++) { // n * (1~9) 까지 구구단 출력
          int multipleNum = selectNum * i;
          System.out.printf("%d * %d = %d %n", selectNum, i, multipleNum);
        }
      }
    }
    System.out.println("이용해주셔서 감사합니다.");
    inputNum.close(); // scanner close
  }
}