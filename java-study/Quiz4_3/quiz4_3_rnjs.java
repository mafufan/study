import java.util.Arrays;
import java.util.Scanner;

public class quiz4_3_rnjs {

  public static void main(String[] args) {
    int n = 0; // 사용자에게 입력받을 값을 저장할 변수
    String str = ""; // 배열 내 난수 값들을 저장할 변수
    int max = -50; // 최대값
    int min = 50; // 최소값
    int total = 0; // 평균을 구하기 위해 총합을 저장할 변수
    int aver = 0; // 평균을 저장할 변수
    String[] histogram = new String[10];
    Arrays.fill(histogram, "");
    Scanner sc = new Scanner(System.in);
    // 입력받은 N 값이 1이상 100이하의 값만 수용, 아닐경우 msg 출력 후 재입력
    System.out.println("배열의 개수를 입력하세요.");
    while (true) {
      n = sc.nextInt();
      if (n < 1) {
        System.out.println("1이상의 값을 입력하세요");
      } else if (n > 100) {
        System.out.println("100이하의 값을 이력하세요");
      } else {
        break;
      }
    }
    // 입력받은 n개 크기의 정수형 배열 선언
    int[] arr = new int[n];

    // 배열에 -50 ~ 50 사이의 난수를 만들어 배열에 저장
    for (int i = 0; i < arr.length; i++) {
      int random = (int) (Math.random() * 101) - 50;
      // 배열 내 중복값 제거
      for (int j = 0; j < i; j++) {
        if (random == arr[j]) {
          random = (int) (Math.random() * 101) - 50;
          j = -1;
        }
      }
      arr[i] = random;

      // 최대값과 최소값 구하기
      if (arr[i] > max) {
        max = arr[i];
      } else if (arr[i] < min) {
        min = arr[i];
      }

      // total에 배열의 값들을 더해준다(총점구하기)
      total += arr[i];

      // 해당하는 범위에 * 추가
      if (arr[i] != 50) {
        histogram[(arr[i] + 50) / 10] += "*";
      } else {
        histogram[9] += "*";
      }
    }

    // 배열 내 난수 값 문자열로 받기
    str = Arrays.toString(arr);

    // 평균값 구하기(실수 출력)
    aver = total / n;

    // 출력
    System.out.println("배열의 개수 : " + n);
    System.out.println(
      "배열 내 난수 값 : " + str.substring(1, str.length() - 1)
    );
    System.out.println("최대값 : " + max);
    System.out.println("최소값 : " + min);
    System.out.println("평균값 : " + aver);
    System.out.println();

    // 구간별 난수의 개수를 구하고 히스토그램으로 출력

    int histo = -50;
    System.out.println("히스토그램");
    for (int i = 0; i < 10; i++) {
      if (i == 9) {
        System.out.printf("%3d ~ %3d : %s\n", histo, histo + 10, histogram[i]);
      }
      System.out.printf("%3d ~ %3d : %s\n", histo, histo + 9, histogram[i]);
    }
  }
}
