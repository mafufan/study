import java.util.Random;
import java.util.Scanner;

public class Exam1 {

  Scanner sc = new Scanner(System.in);
  int[][] table; // 사용자의 입력한 수의 2차원 배열
  int[] arr; // 난수 배열
  int input; // 사용자가 입력한 수

  void makeTable() {
    // 입력한 수만큼 2차원 배열 만들기
    System.out.println("정수를 입력하세요");
    while (true) {
      input = sc.nextInt();
      if (!(3 <= input && input <= 5)) {
        // 입력한 수가 3 ~ 5 사이의 값이 아니면 다시 입력
        System.out.println(
          "3 ~ 5 사이의 값을 입력해 주세요."
        );
        continue;
      }
      break;
    }
    table = new int[input][input];
  }

  void insertRanNum() {
    // -10 ~ 30 사이의 중복되지 않은 난수를 발생시켜 arr에 입력
    // arr을 table(2차원 배열)에 삽입
    arr = new int[input * input]; // arr배열의 크기를 table의 크기만큼
    for (int i = 0; i < arr.length; i++) {
      // 난수 생성
      int random = (int) (
        Math.random() * (30 - (-10)) - 10
      );
      for (int j = 0; j < i; j++) {
        if (random == arr[j]) {
          // 배열에 해당 난수가 이미 존재하면
          // 난수를 다시 생성후 반복 횟수 초기화
          random =
            (int) (Math.random() * (30 - (-10)) - 10);
          j = 0;
        }
      }
      arr[i] = random;
    }

    // table에 arr 값 삽입
    int count = 0;
    for (int i = 0; i < input; i++) {
      for (int j = 0; j < input; j++) {
        table[i][j] = arr[count];
        count++;
      }
    }
  }

  void printTable() {
    // 2차원 배열 출력
    for (int i = 0; i < input; i++) {
      for (int j = 0; j < input; j++) {
        System.out.printf("%3d ", table[i][j]);
      }
      System.out.println();
    }
  }

  void rowCheck() {
    // table의 행별 최소값, 최대값, 중간값 구하기
    int[][] rowArr = new int[input][input];
    for (int i = 0; i < input; i++) {
      // i행을 rowArr 배열에 복사
      for (int j = 0; j < input; j++) {
        rowArr[i][j] = table[i][j];
      }
      // rowArr 배열을 오름차순으로 정렬
      for (int j = 0; j < input; j++) {
        for (int k = j; k < input; k++) {
          if (rowArr[i][j] > rowArr[i][k]) {
            int tmp = rowArr[i][j];
            rowArr[i][j] = rowArr[i][k];
            rowArr[i][k] = tmp;
          }
        }
      }
    }
    // 출력
    System.out.println("행 별");
    System.out.print("최소값 ");
    System.out.print("최대값 ");
    System.out.print("중간값 ");
    System.out.println();
    for (int i = 0; i < input; i++) {
      System.out.printf(" %5d", rowArr[i][0]); //         i번째 행의 최소값
      System.out.printf(" %5d", rowArr[i][input - 1]); // i번째 행의 최대값
      System.out.printf(" %5d", rowArr[i][input / 2]); // i번째 행의 중간값
      System.out.println();
    }
  }

  void colCheck() {
    // table의 열별 최소값, 최대값, 중간값 구하기
    int[][] colArr = new int[input][input];
    for (int i = 0; i < input; i++) {
      // i열을 colArr 배열에 복사
      for (int j = 0; j < input; j++) {
        colArr[i][j] = table[j][i];
      }
      // colArr 배열을 오름차순으로 정렬
      for (int j = 0; j < input; j++) {
        for (int k = j; k < input; k++) {
          if (colArr[i][j] > colArr[i][k]) {
            int tmp = colArr[i][j];
            colArr[i][j] = colArr[i][k];
            colArr[i][k] = tmp;
          }
        }
      }
    }
    // 출력
    System.out.println("열 별");
    System.out.print("최소값 ");
    System.out.printf("%3d", antiDiagArr[0]); // 반대각선의 최소값
    for (int i = 0; i < input; i++) {
      System.out.printf("%3d", colArr[i][0]); // i번째 열의 최소값
    }
    System.out.println();
    System.out.print("최대값 ");
    System.out.printf("%3d", antiDiagArr[input - 1]); // 반대각선의 최대값
    for (int i = 0; i < input; i++) {
      System.out.printf("%3d", colArr[i][input - 1]); // i번째 열의 최대값
    }
    System.out.println();
    System.out.print("중간값 ");
    System.out.printf("%3d", antiDiagArr[input / 2]); // 반대각선의 중간값
    for (int i = 0; i < input; i++) {
      System.out.printf("%3d", colArr[i][input / 2]); // i번째 열의 중간값
    }
    System.out.println();
  }

  void diagCheck() {
    // table의 주대각선 최소값, 최대값, 중간값 구하기
    int[] diagArr = new int[input];
    for (int i = 0; i < input; i++) {
      // table의 주대각선을 diagArr 배열에 복사
      diagArr[i] = table[i][i];
    }
    // diagArr 배열 오름차순으로 정렬
    for (int i = 0; i < input; i++) {
      for (int k = i; k < input; k++) {
        if (diagArr[i] > diagArr[k]) {
          int tmp = diagArr[i];
          diagArr[i] = diagArr[k];
          diagArr[k] = tmp;
        }
      }
    }
    // 출력
    System.out.printf(" %5d", diagArr[0]); //        주대각선의 최소값
    System.out.printf(" %5d", diagArr[input - 1]); //주대각선의 최대값
    System.out.printf(" %5d", diagArr[input / 2]); //주대각선의 중간값
    System.out.println();
  }

  int[] antiDiagArr; // table의 반대각선 배열

  void antiDiagCheck() {
    // table의 반대각선 최소값, 최대값, 중간값 구하기
    antiDiagArr = new int[input];
    for (int i = 0; i < input; i++) {
      // table의 반대각선을 antiDiagArr 배열에 복사
      antiDiagArr[i] = table[i][input - (i + 1)];
    }
    // antiDiagArr 배열 오름차순으로 정렬
    for (int i = 0; i < input; i++) {
      for (int k = i; k < input; k++) {
        if (antiDiagArr[i] > antiDiagArr[k]) {
          int tmp = antiDiagArr[i];
          antiDiagArr[i] = antiDiagArr[k];
          antiDiagArr[k] = tmp;
        }
      }
    }
  }

  String[] histogram; // histogram 배열

  void makeHistogram() { // histogram 생성
    histogram = new String[4];
    for (int i = 0; i < 4; i++) {
      histogram[i] = ""; // histogram을 빈공백으로 초기화
    }
    // histogram[0] = -10 ~ 0
    // histogram[1] =   1 ~ 10
    // histogram[2] =  11 ~ 20
    // histogram[3] =  21 ~ 30
    for (int i = 0; i < input; i++) {
      for (int j = 0; j < input; j++) {
        for (int h = 0; h < 3; h++) {
          if (table[i][j] <= 0) {
            // 숫자가 -10 ~ 0, histogram[0]에 "*"을 추가
            histogram[0] = histogram[0] + "*";
            break;
          } else if (
            // 숫자가 1 ~ 10, 11 ~ 20, 21~30 일 경우,
            // histogram의 해당 index에 "*" 을 추가
            (h * 10) + 1 <= table[i][j] &&
            table[i][j] <= (h * 10) + 10
          ) {
            histogram[h + 1] = histogram[h + 1] + "*";
          }
        }
      }
    }
  }

  void printHistogram() { // histogram 출력
    System.out.println("\n구간 별 발생 빈도");
    System.out.printf("-10 ~ 0 : %s\n", histogram[0]); // histogram[0] = -10 ~ 0
    System.out.printf("1 ~ 10 : %s\n", histogram[1]); //  histogram[0] =   1 ~ 10
    System.out.printf("11 ~ 20 : %s\n", histogram[2]); // histogram[0] =  11 ~ 20
    System.out.printf("21 ~ 30 : %s\n", histogram[3]); // histogram[0] =  21 ~ 30
  }

  void start() {
    makeTable(); //      입력받은 수의 크기인 2차원 배열 생성
    insertRanNum(); //   난수를 생성시켜 2차원 배열에 삽입
    printTable(); //     2차원 배열 출력
    rowCheck(); //       행별 최소값, 최대값, 중간값 출력
    diagCheck(); //      주대각선 별 최소값, 최대값, 중간값 출력
    antiDiagCheck(); //  반대각선 별 최소값, 최대값, 중간값 출력
    colCheck(); //       열별 최소값, 최대값, 중간값 출력
    makeHistogram(); //  histogram 생성
    printHistogram(); // histogram 출력
  }

  public static void main(String[] args) {
    Exam1 m = new Exam1();
    m.start(); // 실행
  }
}
