import java.util.Arrays;
import java.util.Scanner;

public class quiz4sort {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 배열 갯수 입력
    System.out.println();
    System.out.println("배열의 개수를 입력하세요.");
    int arrCnt = sc.nextInt();
    while (!(1 <= arrCnt && arrCnt <= 100)) {
      // 입력받은 N 값이 1이상 100이하의 값만 수용, 아닐 경우 Msg 출력 후 재입력
      if (arrCnt < 1) {
        System.out.println("1 이상의 값을 입력하세요.");
      }
      if (100 < arrCnt) {
        System.out.println("100 이하의 값을 입력하세요.");
      }
      arrCnt = sc.nextInt();
      continue;
    }
    int[] arr = new int[arrCnt];

    // 난수를 발생하여 배열에 저장
    for (int i = 0; i < arr.length; i++) {
      int randomNum = (int) (Math.random() * 100 - 50);
      arr[i] = randomNum;
    }

    Arrays.sort(arr);

    System.out.print("월래 배열         : ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    // 배열 내 중복값 제거

    // 중복을 뺀 배열의 길이 구하기
    int overlay = arr[0];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > overlay) {
        overlay = arr[i];
        count++;
      }
    }
    System.out.println();

    // 중복을 뺀 배열 만들기
    int[] sortArr = new int[count]; // 중복을 없앤 배열
    overlay = arr[0];
    count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > overlay) {
        overlay = arr[i];
        sortArr[count] = overlay;
        count++;
      }
    }

    // 배열의 개수
    System.out.print("배열의 개수 : " + arrCnt + "\n");
    // 배열 내 난수 값
    System.out.print("배열 내 난수의 값 : ");
    for (int i = 0; i < sortArr.length; i++) {
      System.out.print(sortArr[i] + " ");
    }
    System.out.println();
    // 최 대 값
    System.out.print("최  대  값 : ");
    int max = sortArr[0];
    for (int i = 0; i < sortArr.length; i++) {
      if (max < sortArr[i]) {
        max = sortArr[i];
      }
    }
    System.out.println(max);
    // 최 소 값
    System.out.print("최  소  값 : ");
    int min = sortArr[0];
    for (int i = 0; i < sortArr.length; i++) {
      if (min > sortArr[i]) {
        min = sortArr[i];
      }
    }
    System.out.println(min);

    // 평 균 값
    System.out.print("평  균  값 : ");
    float sum = 0;
    for (int i = 0; i < sortArr.length; i++) {
      sum += sortArr[i];
    }
    System.out.printf("%.1f\n", sum / sortArr.length);
    System.out.println();
    // 히스토그램
    int comNum = -50;
    for (int i = 0; i < 10; i++) {
      int SecondcomNum = comNum + 10;
      if (i == 9) {
        System.out.printf("%3d ~ %3d : ", comNum, SecondcomNum);
      }
      if (i < 9) {
        System.out.printf("%3d ~ %3d : ", comNum, SecondcomNum - 1);
      }
      for (int j = 0; j < sortArr.length; j++) {
        if (comNum <= sortArr[j] && sortArr[j] < SecondcomNum) {
          System.out.print("*");
        }
      }
      System.out.println();
      comNum += 10;
    }
  }
}
