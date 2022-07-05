import java.util.Scanner;

public class app {

  Scanner sc = new Scanner(System.in);
  int[][] scoreTable = new int[5][8];
  int inputMenu;
  int inputIdx = -1;

  void printMenu() {
    System.out.println("--------------------");
    System.out.println("1. 성적 입력");
    System.out.println(
      "2. 전체 성적 출력 (평균 기준 오름차순)"
    );
    System.out.println(
      "3. 학생 조회 후 출력 (평균 기준 오름차순)"
    );
    System.out.println("4. 종료");
    System.out.println("--------------------");
    System.out.println("메뉴 선택 : ");
    inputMenu = sc.nextInt();
  }

  void inputScore() {
    // 0:입력순번 1:학번
    // 2:국어 3:영어: 4:수학
    // 5:총점 6:평균 7:순위
    inputIdx++;
    scoreTable[inputIdx][0] = inputIdx + 1;
    System.out.println("학번을 입력 하세요:");
    scoreTable[inputIdx][1] = sc.nextInt();
    System.out.println("국어 성적을 입력 하세요:");
    scoreTable[inputIdx][2] = sc.nextInt();
    scoreTable[inputIdx][5] += scoreTable[inputIdx][2];
    System.out.println("영어 성적을 입력 하세요:");
    scoreTable[inputIdx][3] = sc.nextInt();
    scoreTable[inputIdx][5] += scoreTable[inputIdx][3];
    System.out.println("수학 성적을 입력 하세요:");
    scoreTable[inputIdx][4] = sc.nextInt();
    scoreTable[inputIdx][5] += scoreTable[inputIdx][4];
    scoreTable[inputIdx][6] = scoreTable[inputIdx][5] / 3;
    printInputScore();
  }

  void printInputScore() {
    System.out.println("입력 값 : ");
    System.out.printf(
      "학번 : %d ",
      scoreTable[inputIdx][1]
    );
    System.out.printf(
      "국어 : %d ",
      scoreTable[inputIdx][2]
    );
    System.out.printf(
      "영어 : %d ",
      scoreTable[inputIdx][3]
    );
    System.out.printf(
      "수학 : %d ",
      scoreTable[inputIdx][4]
    );
    System.out.printf(
      "총점 : %d ",
      scoreTable[inputIdx][5]
    );
    System.out.printf(
      "평균 : %d ",
      scoreTable[inputIdx][6]
    );
    System.out.println();
  }

  void makeRanking() {
    for (int i = 0; i <= inputIdx; i++) {
      int rank = 1;
      scoreTable[i][7] = 1;
      for (int j = 0; j <= inputIdx; j++) {
        if (scoreTable[i][6] < scoreTable[j][6]) {
          rank++;
        }
        scoreTable[i][7] = rank;
      }
    }
  }

  void printAllTable() {
    System.out.printf(
      "%4s %4s %4s %4s %4s %4s %4s %4s\n",
      "입력순번",
      "학번",
      "국어",
      "영어",
      "수학",
      "총점",
      "평균",
      "순위"
    );
    int rank = 1;
    for (int i = 0; i <= inputIdx; i++) {
      if (scoreTable[i][7] == rank) {
        for (int j = 0; j < 8; j++) {
          if (j == 1) {
            System.out.printf("%8d ", scoreTable[i][j]);
            continue;
          }
          System.out.printf("%6d ", scoreTable[i][j]);
        }
        System.out.println();
        i = rank - 1;
        rank++;
      }
    }
  }

  void start() {
    while (true) {
      printMenu();
      if (inputMenu == 1) {
        if (inputIdx >= 5) {
          System.out.println("더이상 입력할수 없습니다.");
          continue;
        }
        inputScore();
      } else if (inputMenu == 2) {
        makeRanking();
        printAllTable();
      } else if (inputMenu == 4) {
        System.out.println("프로그램 종료.");
        break;
      }
    }
  }

  public static void main(String[] args) {
    app m = new app();
    m.start();
  }
}
