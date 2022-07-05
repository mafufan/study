import java.util.Scanner;

public class Quiz6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 0 ~ 9 사이의 숫자중 3개를 랜덤하게 배열에 넣기
    // 단 중복 없이
    int[] numbers = new int[3];
    for (int i = 0; i < 3; i++) {
      int random = (int) (Math.random() * 9);
      for (int j = 0; j < i; j++) {
        // 중복 일 경우 다시 random 숫자을 생성
        if (random == numbers[j]) {
          random = (int) (Math.random() * 9);
          j = 0;
        }
      }
      numbers[i] = random;
    }

    int count = 1; // 시도횟수
    while (count <= 5) {
      // 시도횟수가 5 이상이면 게임 종료
      // 사용자가 숫자 3개를 입력
      System.out.println("시도횟수: " + count);
      System.out.println("정수 3개를 입력하세용~~~^__^");
      int[] input = new int[3]; // 숫자 3개를 입력받는 배열
      String temp = sc.nextLine();
      input[0] = temp.charAt(0) - '0';
      input[1] = temp.charAt(2) - '0';
      input[2] = temp.charAt(4) - '0';

      // strike, ball, out 확인하기
      int strike = 0;
      int ball = 0;
      int out = 0;
      for (int i = 0; i < 3; i++) {
        // strike 일때 = 숫자의 index와 값이 모두 같을때
        if (numbers[i] == input[i]) {
          strike++;
        } else if (
          // ball 일때 = 숫자의 index와 상관없이 숫자만 같을때
          (numbers[i] == input[0]) ||
          (numbers[i] == input[1]) ||
          (numbers[i] == input[2])
        ) {
          ball++;
        }
      }
      if (strike == 0 && ball == 0) {
        // out 일때
        // = 입력한 모든 수가 하나도 일치하지 않을때
        // = strike( 0 ) && ball( 0 )
        out++;
      }
      System.out.println();

      // strike, ball, out 을 출력
      if (strike > 0) {
        // strike가 있을때만 출력
        System.out.println(strike + " strike ");
      }
      if (ball > 0) {
        // ball이 있을때만 출력
        System.out.println(ball + " Ball");
      }
      if (out > 0) {
        // out이 있을때만 출력
        System.out.println("out : 아웃 " + out + "번");
      }
      System.out.println();
      count++; // 시도횟수++

      // 3 strike = Win
      if (strike == 3) {
        System.out.println("Win");
        break; // 게임종료
      }
      // 게임횟수가 5를 초과하거나, 2 out 이상 = Lose
      if (count == 5 || out >= 2) {
        System.out.println("게임횟수 초과");
        System.out.println("아까비~~~졌네용..");
        System.out.printf(
          "정답은: %d %d %d 입니다.\n",
          numbers[0],
          numbers[1],
          numbers[2]
        );
        break; // 게임종료
      }
    }
    sc.close();
  }
}
