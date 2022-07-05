import java.util.Arrays;
import java.util.Scanner;

class quiz4_3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 정수 N을 입력받고, N개의 정수형 배열 선언
    System.out.println("배열의 개수를 입력하세요.");
    int N = sc.nextInt();

    // 입력받은 N 값이 1 ~ 100 일 때만 수용
    while (N < 1 || N > 100) {
      if (N < 1) {
        System.out.println("1 이상의 값을 입력하세요.");
      }
      if (N > 100) {
        System.out.println("100 이하의 값을 입력하세요.");
      }
      N = sc.nextInt();
    }
    int[] arr = new int[N];

    // 난수를 배열에 저장
    for (int i = 0; i < arr.length; i++) {
      int randomNum = (int) (Math.random() * 100 - 50);
      // 배열 내 중복값 제거
      for (int j = 0; j < i; j++) {
        if (randomNum == arr[j]) {
          randomNum = (int) (Math.random() * 100 - 50);
          j = 0;
        }
      }
      arr[i] = randomNum;
    }
    // 배열 내 난수 값 출력
    Arrays.sort(arr);
    System.out.print("배열 내 난수 값 : ");
    for (int i = 0; i < arr.length; i++) {
      if (i == arr.length - 1) {
        System.out.print(arr[i]);
        break;
      }
      System.out.print(arr[i] + ", ");
    }
    System.out.println();

    // 최대값 구하기
    int max = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    System.out.println("최대값 : " + max);

    // 최소값 구하기
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    System.out.println("최소값 : " + min);

    // 평균값 구하기, 실수 출력
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    System.out.printf("평균값 : %.1f\n", (float) sum / arr.length);

    // 구간별 히스토그램 출력
    String[] histogram = new String[10]; // 히스토그램 배열 생성
    for (int i = 0; i < histogram.length; i++) {
      histogram[i] = ""; // 공백으로 초기화
    }

    for (int i = 0; i < arr.length; i++) {
      // 해당 자릿수 마다 "*" 채워넣기
      int histoIdx = (int) ((float) (arr[i] * 0.1 + 5));
      if (histoIdx == 10) { // arr[i] == 50 일때
        histoIdx = -1; // arr[10]가 되버리므로 -1 해준다
      }
      histogram[histoIdx] += "*";
    }

    System.out.println("히스토그램");
    int histoMinArange = -50;
    for (int i = 0; i < 10; i++) {
      int histoMaxArange = histoMinArange + 9;
      if (i == 9) {
        histoMaxArange++;
      }
      System.out.printf(
        "%3d ~ %3d : %s \n",
        histoMinArange,
        histoMaxArange,
        histogram[i]
      );
      histoMinArange += 10;
    }
    sc.close();
  }
}
