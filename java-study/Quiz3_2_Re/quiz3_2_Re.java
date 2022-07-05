import java.util.Scanner;

public class quiz3_2_Re {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] studentTable = new int[5][8]; // 학생 정보 표
    int inputIdx = 0; // 입력 index

    while (true) {
      // 메뉴 출력
      System.out.println("--------------------");
      System.out.println("1. 성적 입력");
      System.out.println("2. 전체 성적 출력 (평균 기준 오름차순)");
      System.out.println("3. 학생 조회 후 출력");
      System.out.println("4. 종료");
      System.out.println("--------------------");
      System.out.println("메뉴 선택 : ");
      int selectMenu = sc.nextInt(); // 메뉴 입력받음
      boolean err = false; // 학번이 중복인지 확인

      // 1. 성적 입력
      if (selectMenu == 1) {
        // 5번 다 입력 했을 때
        if (inputIdx == 5) {
          System.out.println("더이상 입력할 수 없습니다.");
          continue;
        }

        // 현재 몇번째 입력인지
        studentTable[inputIdx][0] = inputIdx + 1;
        System.out.println("학번을 입력 하세요");
        int studentId = sc.nextInt();

        // 입력한 학번이 존재하는지 검사
        for (int i = 0; i < studentTable.length; i++) {
          if (studentId == studentTable[i][1]) {
            System.out.println("다시 입력해주세요.");
            err = true; // 학번이 이미 존재함
            break;
          }
        }

        // 학번이 이미 존재 할 경우
        if (err == true) {
          continue;
        }

        // 학번이 없는 경우
        // 학번 입력
        studentTable[inputIdx][1] = studentId;

        // 국어 성적 입력
        System.out.println("국어 성적을 입력 하세요");
        int koreanScore = sc.nextInt();
        studentTable[inputIdx][2] = koreanScore;

        // 영어 성적 입력
        System.out.println("영어 성적을 입력 하세요");
        int englishScore = sc.nextInt();
        studentTable[inputIdx][3] = englishScore;

        // 수학 성적 입력
        System.out.println("수학 성적을 입력 하세요");
        int mathScore = sc.nextInt();
        studentTable[inputIdx][4] = mathScore;

        // 총점 구하기
        int sumScore = koreanScore + englishScore + mathScore;
        studentTable[inputIdx][5] = sumScore;
        // 평균 구하기
        int avgScore = sumScore / 3;
        studentTable[inputIdx][6] = avgScore;

        // 입력받은 값들 출력
        System.out.println("입력 값 :");
        System.out.printf("학번 : %d ", studentTable[inputIdx][1]);
        System.out.printf("국어 : %d ", studentTable[inputIdx][2]);
        System.out.printf("영어 : %d ", studentTable[inputIdx][3]);
        System.out.printf("수학 : %d ", studentTable[inputIdx][4]);
        System.out.printf("총점 : %d ", sumScore);
        System.out.printf("평균 : %d %n", avgScore);

        // 평균으로 구성된 배열 만들기
        int[] avgArr = new int[studentTable.length];
        for (int i = 0; i < avgArr.length; i++) {
          avgArr[i] = studentTable[i][6];
        }

        // 학생들의 평균 비교하여 순위 정하기
        for (int i = 0; i < avgArr.length; i++) {
          studentTable[i][7] = 1; // 1등으로 초기화
          for (int j = 0; j < avgArr.length; j++) {
            if (avgArr[i] < avgArr[j]) { // 비교 하는 평균보다 작으면
              studentTable[i][7] = studentTable[i][7] + 1; // 순위 증가
            }
          }
        }
        inputIdx++; // 입력 순서 증가
      }

      // 2. 전체 성적 출력 (평균 기준 오름차순)
      if (selectMenu == 2) {
        // 카테고리 출력
        String[] info = {
          "입력순번",
          "학번",
          "국어",
          "영어",
          "수학",
          "총점",
          "평균",
          "순위",
        };
        for (int i = 0; i < info.length; i++) {
          System.out.printf("%7s", info[i]);
        }

        // 전체 정보 출력
        int rank = 1; // 학생들의 순위와 rank의 값이 동일한지 체크
        System.out.println();

        while (rank <= 5) { // 5등까지 출력하면 종료
          for (int i = 0; i < studentTable.length; i++) {
            if (studentTable[i][7] == rank && studentTable[i][0] != 0) {
              // 학생의 순위와 rank가 같거나 학생 정보가 존재하는 경우에만 출력
              for (int j = 0; j < studentTable[i].length; j++) {
                if (j == 0) {
                  System.out.printf("%7d", studentTable[i][j]);
                } else if (j == 1) {
                  System.out.printf("%14d", studentTable[i][j]);
                } else if (j == 2) {
                  System.out.printf("%7d", studentTable[i][j]);
                } else {
                  System.out.printf("%9d", studentTable[i][j]);
                }
              }
              System.out.println();
            }
          }
          rank++; // 한번 출력 되었을때 마다 1증가
        }
      }

      // 3. 학생 조회 후 출력
      if (selectMenu == 3) {
        boolean findFlag = false; // 검색 완료 확인 플래그
        int errCount = 0; // 에러 횟수
        int findIdx = 0; // 학번이 어디에 존재하는지 체크

        while (errCount != 3) {
          // 에러 3회 발생시 종료
          System.out.println("검색 할 학생의 학번을 입력 하세요");
          int searchId = sc.nextInt();

          // 입력한 학번이 존재하는지 체크
          for (int i = 0; i < studentTable.length; i++) {
            if (searchId == studentTable[i][1]) {
              findFlag = true;
              findIdx = i;
              break;
            }
          }

          // 입력한 학번이 존재하지 않을 때
          if (findFlag == false) {
            errCount++; // 에러 횟수 증가
            System.out.printf(
              "입력하신 학번은 없는 학번입니다. 다시 입력하세요. [오류횟수: %d]%n",
              errCount
            );
            continue;
          }

          // 입력한 학번이 존재할 때
          if (findFlag == true) {
            // 카테고리 출력
            String[] info = {
              "입력순번",
              "학번",
              "국어",
              "영어",
              "수학",
              "총점",
              "평균",
              "순위",
            };
            for (int i = 0; i < info.length; i++) {
              System.out.printf("%7s", info[i]);
            }
            System.out.println();

            // 정보 출력
            for (int i = 0; i < studentTable[findIdx].length; i++) {
              if (i == 0) {
                System.out.printf("%7d", studentTable[findIdx][i]);
              } else if (i == 1) {
                System.out.printf("%14d", studentTable[findIdx][i]);
              } else if (i == 2) {
                System.out.printf("%7d", studentTable[findIdx][i]);
              } else {
                System.out.printf("%9d", studentTable[findIdx][i]);
              }
            }
            System.out.println();
            break;
          }
        }
      }

      // 4. 종료
      if (selectMenu == 4) {
        System.out.println("프로그램 종료");
        break;
      }
    }
    sc.close();
  }
}
