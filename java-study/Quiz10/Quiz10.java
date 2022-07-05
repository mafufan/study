import java.util.Scanner;

public class Quiz10 {

  // 키보드로 부터 정수 N을 입력 받고, N X N 매트릭스를 생성하라.
  // 초기화 된 매트릭스를 출력하고, 아래와 같은 메뉴를 화면으로 출력.
  // 1) 오른쪽으로 90도 회전
  // 2) 왼쪽으로 90도 회전
  // 3) 상하반전
  // 4) 좌우반전
  // 5) 프로그램 종료
  Scanner sc = new Scanner(System.in);
  int N; // 키보드로 부터 입력 받은 정수
  int matrix[][];
  int numbers[]; // 1 ~ N X N 의 숫자가 들어간 배열
  int menu; // 메뉴 입력 변수

  void makeMatrix() {
    // 입력받은 정수 N 만큼 N X N 매트릭스 생성
    // 단 2 이상 8 이하의 정수만 입력 받음
    System.out.println("정수 N을 입력");
    while (true) {
      N = sc.nextInt();
      if (!(2 <= N && N <= 8)) {
        System.out.println(
          "2이상 8이하의 정수를 입력하시오."
        );
        continue;
      }
      break;
    }
    matrix = new int[N][N];
  }

  void insertNumbers() {
    // 1 ~ N X N 의 숫자를 매트릭스에 삽입
    int count = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = count;
        count++;
      }
    }
  }

  void printMatrix() {
    // 매트릭스 출력
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.printf("%3d", matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  void selectMenu() {
    // 메뉴 입력
    System.out.println("메뉴 입력 : ");
    System.out.println("1) 오른쪽으로 90도 회전");
    System.out.println("2) 왼쪽으로 90도 회전");
    System.out.println("3) 상하반전");
    System.out.println("4) 좌우반전");
    System.out.println("5) 프로그램 종료");
    menu = sc.nextInt();
  }

  void degreeLeft() {
    // 왼쪽으로 90도 회전
    // 매트릭스를 temp[](1차원 배열)로 옮긴후
    // matrix[0,마지막 index]부터  temp[]를 삽입
    // matirx의 첫번째 열이 다 채워 졌으면 그 다음 열에 똑같이 반복

    int temp[] = new int[N * N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        temp[count] = matrix[i][j];
        count++;
      }
    }
    count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = N - 1; j >= 0; j--) {
        matrix[j][i] = temp[count];
        count++;
      }
    }
  }

  void degreeRight() {
    // 오른쪽으로 90도 회전
    // 매트릭스를 temp[](1차원 배열)로 옮긴후
    // matrix[0,마지막 index]부터  temp[]를 삽입
    // matirx의 마지막 열이 다 채워 졌으면 그 앞의 열에 똑같이 반복

    int temp[] = new int[N * N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        temp[count] = matrix[i][j];
        count++;
      }
    }
    count = 0;
    for (int i = N - 1; i >= 0; i--) {
      for (int j = 0; j < N; j++) {
        matrix[j][i] = temp[count];
        count++;
      }
    }
  }

  void horizontalFlip() {
    // 상하 반전
    // 매트릭스를 temp[](1차원 배열)로 옮긴후
    // matrix[마지막 index,0]부터  temp[]를 삽입
    // matirx의 마지막 행이 다 채워 졌으면 그 앞의 행에 똑같이 반복

    int temp[] = new int[N * N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        temp[count] = matrix[i][j];
        count++;
      }
    }
    count = 0;
    for (int i = N - 1; i >= 0; i--) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = temp[count];
        count++;
      }
    }
  }

  void verticalFlip() {
    // 좌우 반전
    // 매트릭스를 temp[](1차원 배열)로 옮긴후
    // matrix[0,마지막 인덱스]부터  temp[]를 삽입
    // matirx의 첫번째 행이 다 채워 졌으면 그 뒤의 행에 똑같이 반복

    int temp[] = new int[N * N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        temp[count] = matrix[i][j];
        count++;
      }
    }
    count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = N - 1; j >= 0; j--) {
        matrix[i][j] = temp[count];
        count++;
      }
    }
  }

  void start() {
    makeMatrix();
    insertNumbers();
    while (true) {
      printMatrix();
      selectMenu();
      if (menu == 1) {
        degreeRight();
      } else if (menu == 2) {
        degreeLeft();
      } else if (menu == 3) {
        horizontalFlip();
      } else if (menu == 4) {
        verticalFlip();
      } else if (menu == 5) {
        break;
      }
    }
    System.out.println("프로그램 종료.");
  }

  public static void main(String[] args) {
    Quiz10 m = new Quiz10();
    m.start();
  }
}
