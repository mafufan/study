import java.util.Arrays;

public class quiz3_1_Re {

  public static void main(String[] args) {
    char[][] arr = new char[8][8]; // 8 x 8 2차원 배열
    int[] countArr = new int[26]; // a-z 발생 빈도수 배열

    // a-z 중에 랜덤으로 알파벳 하나를 골라 배열에 넣고
    // 뽑은 알파벳의 index에 뽑힌 갯수 count
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        int randomIdx = (int) (Math.random() * 26);
        char randomChar = (char) ('a' + randomIdx);
        arr[i][j] = randomChar;
        countArr[randomIdx]++;
      }
    }

    // 8 x 8 배열 출력
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.printf("%c \t", arr[i][j]);
      }
      System.out.println();
    }

    // 최소 발생 빈도
    int min = countArr[0];
    if (min == 0) { // 'a'의 갯수가 0일때 0개 알파벳 출력 방지
      min = countArr[1];
    }
    for (int i = 0; i < countArr.length; i++) {
      if (0 < countArr[i] && countArr[i] < min) {
        min = countArr[i];
      }
    }

    // 최소 중복 알파벳 개수, 그 알파벳
    int minCount = 0;
    String minChar = "";
    for (int i = 0; i < countArr.length; i++) {
      if (countArr[i] == min) {
        minCount++;
        minChar += ((char) ('a' + i) + ", ");
      }
    }

    // 최소 발생 알파벳 출력
    System.out.println("최소 발생 알파벳");
    System.out.println(" - 발생 빈도 : " + min);
    System.out.println(" - 중복 알파벳 개수 : " + minCount);
    System.out.println(
      " - 알파벳 : " + minChar.substring(0, minChar.length() - 2)
    );

    // 최대 발생 알파벳의 발생 빈도 구하기
    int max = countArr[0];
    for (int i = 0; i < countArr.length; i++) {
      if (countArr[i] > max) {
        max = countArr[i];
      }
    }

    // 최대 중복 알파벳 개수, 그 알파벳
    int maxCount = 0;
    String maxChar = "";
    for (int i = 0; i < countArr.length; i++) {
      if (countArr[i] == max) {
        maxCount++;
        maxChar += ((char) ('a' + i) + ", ");
      }
    }

    // 최대 발생 알파벳 출력
    System.out.println("최대 발생 알파벳");
    System.out.println(" - 발생 빈도 : " + max);
    System.out.println(" - 중복 알파벳 개수 : " + maxCount);
    System.out.println(
      " - 알파벳 : " + maxChar.substring(0, maxChar.length() - 2)
    );

    // arr 배열을 오름차순으로 정렬
    char[] sortArr = new char[arr.length * arr[0].length];
    // 2차원 배열을 1차원으로 변환
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        sortArr[i * arr.length + j] = arr[i][j];
      }
    }
    Arrays.sort(sortArr);

    // 오름차순 출력
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.printf("%c \t", sortArr[i * arr.length + j]);
      }
      System.out.println();
    }
  }
}
