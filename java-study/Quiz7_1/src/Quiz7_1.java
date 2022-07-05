public class Quiz7_1 {

  public static void main(String[] args) {
    // 5X5 2차원 배열 생성
    int[][] arr = new int[5][5];

    // 1~50 중 난수를 중복 없이 생성
    int[] random = new int[25];
    for (int i = 0; i < random.length; i++) {
      int ranNum = (int) (Math.random() * 50 + 1);
      for (int j = 0; j < i; j++) {
        if (ranNum == random[j]) {
          ranNum = (int) (Math.random() * 50 + 1);
          j = 0;
        }
      }
      random[i] = ranNum;
    }
    // 난수를 정렬
    for (int i = 0; i < random.length; i++) {
      for (int j = 0; j < i; j++) {
        if (random[i] < random[j]) {
          int tmp = random[i];
          random[i] = random[j];
          random[j] = tmp;
        }
      }
    }
    // 2차원 배열에 난수를 저장
    int count = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        arr[i][j] = random[count];
        System.out.printf("%2d ", arr[i][j]);
        count++;
      }
      System.out.println();
    }

    // 열별 최대, 최소, 중간 값
    int[] culMax = new int[5];
    int[] culMin = new int[5];
    int[] culCenter = new int[5];

    for (int i = 0; i < 5; i++) {
      int Max = 0;
      int Min = arr[i][0];
      for (int j = 0; j < 5; j++) {
        if (Max < arr[i][j]) {
          Max = arr[i][j];
        }
        if (Min > arr[i][j]) {
          Min = arr[i][j];
        }
        if (j == 2) {
          culCenter[i] = arr[i][j];
        }
      }
      culMax[i] = Max;
      culMin[i] = Min;
    }
    System.out.println();
    System.out.println("열별");
    System.out.println("최소\t최대\t중간 값");
    for (int i = 0; i < 5; i++) {
      System.out.printf(
        "%2d\t %2d\t %2d\n",
        culMin[i],
        culMax[i],
        culCenter[i]
      );
    }
    // 행별 최대, 최소, 중간 값
    int[] rowMax = new int[5];
    int[] rowMin = new int[5];
    int[] rowCenter = new int[5];

    for (int i = 0; i < 5; i++) {
      int Max = 0;
      int Min = arr[i][0];
      for (int j = 0; j < 5; j++) {
        if (Max < arr[j][i]) {
          Max = arr[j][i];
        }
        if (Min > arr[j][i]) {
          Min = arr[j][i];
        }
        if (j == 2) {
          rowCenter[i] = arr[j][i];
        }
      }
      rowMax[i] = Max;
      rowMin[i] = Min;
    }
    System.out.println();
    System.out.println("행별");
    System.out.print("최소값 ");
    for (int i = 0; i < 5; i++) {
      System.out.printf("%2d \t", rowMin[i]);
    }
    System.out.println();
    System.out.print("최대값 ");
    for (int i = 0; i < 5; i++) {
      System.out.printf("%2d \t", rowMax[i]);
    }
    System.out.println();
    System.out.print("중간값 ");
    for (int i = 0; i < 5; i++) {
      System.out.printf("%2d \t", rowCenter[i]);
    }
    System.out.println();
    // 2차원 배열 전체의 최대, 최소, 중간 값
    System.out.println();
    System.out.println("최소값 " + arr[0][0]);
    System.out.println("최대값 " + arr[2][2]);
    System.out.println("중간값 " + arr[4][4]);
  }
}
