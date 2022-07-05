import java.util.Scanner;

public class quiz4_2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // M 값 입력
    System.out.println("M값을 입력하세요");
    int M = sc.nextInt();

    // N 값 입력
    System.out.println("N값을 입력하세요");
    int N = sc.nextInt();

    // M < N 일때
    if (M < N) {
      System.out.println("M : " + M + " ~ N : " + N + "사이의 정수값은");

      for (int i = M; i <= N; i++) {
        if (i == N) {
          System.out.print(i);
          break;
        }
        System.out.print(i + ", ");
      }
    }

    // M > N 일때
    if (M > N) {
      System.out.println("N : " + N + " ~ M : " + M + "사이의 정수값은");

      for (int i = N; i <= M; i++) {
        if (i == M) {
          System.out.print(i);
          break;
        }
        System.out.print(i + ", ");
      }
    }

    // M = N 일때
    if (M == N) {
      System.out.print("N, M 정수값은 : ");

      for (int i = M; i <= N; i++) {
        if (i == N) {
          System.out.print(i);
          break;
        }
        System.out.print(i + ", ");
      }
    }

    System.out.println();
    System.out.println("----감사합니다----");
    sc.close();
  }
}
