import java.util.Scanner;

public class Quiz8 {

  Scanner sc = new Scanner(System.in);
  int turnCount; // 입력한 방향(direction)으로 회전
  int number; // 숫자 1 ~ 테이블의 칸 수 만큼
  int input; // 키보드 입력
  int direction; // 1: 시계방향, 2: 반시계방향
  int[][] table; // 2차원 배열
  int x = 0; // 가로
  int y = 0; // 세로

  void dataInput() { // 키보드로 2차원 배열의 크기를 입력 받음
    // 2차원 배열의 크기를 지정
    System.out.println("행렬 N의 크기를 입력하세요:");
    input = sc.nextInt();
    table = new int[input][input];

    // 테이블의 방향을 설정
    System.out.println("=========================");
    System.out.println(
      "달팽이 행렬의 생성 방향은(1: 시계, 2: 반시계):"
    );
    direction = sc.nextInt();
    System.out.println("-------------------------");
  }

  void makeTable() { // 테이블의 방향을 설정
    // 1 : 시계 방향
    // 2 : 반시계 방향
    if (direction == 1) {
      clock();
    } else if (direction == 2) {
      antiClock();
    }
  }

  void clock() { // 시계 테이블 만들기
    number = 1;
    while (number <= input * input) {
      // number <= 테이블의 칸수 일때, 마지막 숫자 채우면 종료
      table[x][y] = number++; // number를 table[x][y]에 넣고, number+1
      if (turnCount % 4 == 0) {
        if (y + 1 == input) {
          x = 1;
          turnCount++;
          continue;
        } else if (table[x][y + 1] != 0) {
          x += 1;
          turnCount++;
          continue;
        }
        y++;
      } else if (turnCount % 4 == 1) {
        if (x + 1 == input) {
          y -= 1;
          turnCount++;
          continue;
        } else if (table[x + 1][y] != 0) {
          y -= 1;
          turnCount++;
          continue;
        }
        x++;
      } else if (turnCount % 4 == 2) {
        if (y == 0) {
          x -= 1;
          turnCount++;
          continue;
        } else if (table[x][y - 1] != 0) {
          x -= 1;
          turnCount++;
          continue;
        }
        y--;
      } else if (turnCount % 4 == 3) {
        if (table[x - 1][y] != 0) {
          y += 1;
          turnCount++;
          continue;
        }
        x--;
      }
    }
  }

  void antiClock() { // 반시계 테이블 만들기
    number = 1;
    while (number <= input * input) {
      // 숫자 <= 테이블의 칸수 일때, 마지막 숫자 채우면 종료
      table[y][x] = number++; // number를 table[x][y]에 넣고, number+1
      if (turnCount % 4 == 0) {
        if (y + 1 == input) {
          x = 1;
          turnCount++;
          continue;
        } else if (table[x][y + 1] != 0) {
          x += 1;
          turnCount++;
          continue;
        }
        y++;
      } else if (turnCount % 4 == 1) {
        if (x + 1 == input) {
          y -= 1;
          turnCount++;
          continue;
        } else if (table[x + 1][y] != 0) {
          y -= 1;
          turnCount++;
          continue;
        }
        x++;
      } else if (turnCount % 4 == 2) {
        if (y == 0) {
          x -= 1;
          turnCount++;
          continue;
        } else if (table[y - 1][x] != 0) {
          x -= 1;
          turnCount++;
          continue;
        }
        y--;
      } else if (turnCount % 4 == 3) {
        if (table[y][x - 1] != 0) {
          y += 1;
          turnCount++;
          continue;
        }
        x--;
      }
    }
  }

  void print() { // 출력
    for (int i = 0; i < input; i++) {
      for (int j = 0; j < input; j++) {
        System.out.print(table[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("계속하려면 아무키나 누르세요..");
  }

  void start() {
    dataInput(); // 입력받은 수의 크기 만큼 2차원 테이블를 생성
    makeTable(); // 1 : 시계방향으로 2 : 반시계방향으로 테이블을 만듬
    print(); // 출력
  }

  public static void main(String[] args) {
    Quiz8 m = new Quiz8();
    m.start(); // 시작
  }
}
