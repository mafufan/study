import java.util.Scanner;

class gorigori {

  void guruguru(int N, int[][] arr, int reverse) {
    int i = 1;
    int row = 0;
    int sero = 0;
    int turnCount = 0;
    if (reverse == 1) {
      while (i <= N * N) {
        arr[row][sero] = i++;
        //순서가 4개니까 if문도 4게러 무한 루프 시켜주자
        if (turnCount % 4 == 0) {
          if (sero + 1 == N) {
            row = 1;
            turnCount++;
            continue;
          } else if (arr[row][sero + 1] != 0) {
            row += 1;
            turnCount++;
            continue;
          }
          sero++;
        } else if (turnCount % 4 == 1) {
          if (row + 1 == N) {
            sero -= 1;
            turnCount++;
            continue;
          } else if (arr[row + 1][sero] != 0) {
            sero -= 1;
            turnCount++;
            continue;
          }
          row++;
        } else if (turnCount % 4 == 2) {
          if (sero == 0) {
            row -= 1;
            turnCount++;
            continue;
          } else if (arr[row][sero - 1] != 0) {
            row -= 1;
            turnCount++;
            continue;
          }
          sero--;
        } else if (turnCount % 4 == 3) {
          if (arr[row - 1][sero] != 0) {
            sero += 1;
            turnCount++;
            continue;
          }
          row--;
        }
      }
    } else if (reverse == 2) {
      while (i <= N * N) {
        arr[sero][row] = i++;
        if (turnCount % 4 == 0) {
          if (sero + 1 == N) {
            row = 1;
            turnCount++;
            continue;
          } else if (arr[row][sero + 1] != 0) {
            row += 1;
            turnCount++;
            continue;
          }
          sero++;
        } else if (turnCount % 4 == 1) {
          if (row + 1 == N) {
            sero -= 1;
            turnCount++;
            continue;
          } else if (arr[row + 1][sero] != 0) {
            sero -= 1;
            turnCount++;
            continue;
          }
          row++;
        } else if (turnCount % 4 == 2) {
          if (sero == 0) {
            row -= 1;
            turnCount++;
            continue;
          } else if (arr[sero - 1][row] != 0) {
            row -= 1;
            turnCount++;
            continue;
          }
          sero--;
        } else if (turnCount % 4 == 3) {
          if (arr[sero][row - 1] != 0) {
            sero += 1;
            turnCount++;
            continue;
          }
          row--;
        }
      }
    }
  }
}

public class hello {

  public static void main(String[] args) {
    //배열 끝에 도착하거나 앞에 값에 값이 들어있으면 정해진 방향대로 꺽음
    Scanner sc = new Scanner(System.in);
    gorigori g = new gorigori();
    System.out.println("행렬 N의 크기를 입력하세요.");
    int N = sc.nextInt();
    System.out.println();
    System.out.println(
      "===================================="
    );
    int[][] arr = new int[N][N];
    //CASE 1 시계방향 왼쪽으로가다가 밑 오른쪽 위 순서
    System.out.println(
      "달팽이 배열 생성방향은 (1: 시계, 2: 반시계)"
    );
    int M = sc.nextInt();
    System.out.println(
      "----------------------------------------------"
    );
    g.guruguru(N, arr, M);
    for (int k = 0; k < 5; k++) {
      for (int j = 0; j < 5; j++) {
        System.out.print(arr[k][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("계속하려면 이무키나 누르세요..");
  }
}
