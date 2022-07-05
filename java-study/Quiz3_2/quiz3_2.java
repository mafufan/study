import java.util.Scanner;

public class quiz3_2 {

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

      // 1번 메뉴
      if (selectMenu == 1) {
        if (inputIdx == 5) { // 5번 다 입력 했을 때
          System.out.println("더이상 입력할 수 없습니다.");
          continue;
        }
        studentTable[inputIdx][0] = inputIdx + 1; // 현재 몇번째 입력인지
        System.out.println("학번을 입력 하세요");
        int studentId = sc.nextInt();
        // 입력한 학번이 존재하는지 검사
        for (int i = 0; i < studentTable.length; i++) {
          if (studentId == studentTable[i][1]) {
            System.out.println("다시 입력해주세요.");
            err = true;
            break;
          }
        }
        if (err == true) { // 학번이 이미 있는 경우
          continue;
        } else {
          studentTable[inputIdx][1] = studentId;
        }

        System.out.println("국어 성적을 입력 하세요");
        int koreanScore = sc.nextInt();
        studentTable[inputIdx][2] = koreanScore;

        System.out.println("영어 성적을 입력 하세요");
        int englishScore = sc.nextInt();
        studentTable[inputIdx][3] = englishScore;

        System.out.println("수학 성적을 입력 하세요");
        int mathScore = sc.nextInt();
        studentTable[inputIdx][4] = mathScore;

        int sumScore = koreanScore + englishScore + mathScore;
        studentTable[inputIdx][5] = sumScore;
        int avgScore = sumScore / 3;
        studentTable[inputIdx][6] = avgScore;

        System.out.println("입력 값 :");
        System.out.printf("학번 : %d ", studentTable[inputIdx][1]);
        System.out.printf("국어 : %d ", studentTable[inputIdx][2]);
        System.out.printf("영어 : %d ", studentTable[inputIdx][3]);
        System.out.printf("수학 : %d ", studentTable[inputIdx][4]);
        System.out.printf("총점 : %d ", sumScore);
        System.out.printf("평균 : %d %n", avgScore);

        // 학생들의 평균 순위 정하기
        int[] avgArr = new int[studentTable.length]; // 평균값 입력받는 배열
        for (int i = 0; i < avgArr.length; i++) {
          avgArr[i] = studentTable[i][6];
        }

        // 평균 비교
        for (int i = 0; i < avgArr.length; i++) {
          studentTable[i][7] = 1; // 1등으로 초기화
          for (int j = 0; j < avgArr.length; j++) {
            if (avgArr[i] < avgArr[j]) { // 비교 하는 평균보다 작으면
              studentTable[i][7] = studentTable[i][7] + 1; // 순위 증가
            }
          }
        }
        inputIdx++;
      }
      // 2번 메뉴
      if (selectMenu == 2) {
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

        int count = 1;
        System.out.println();
        while (count <= 5) {
          for (int i = 0; i < studentTable.length; i++) {
            if (studentTable[i][7] == count && studentTable[i][0] != 0) {
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
          count++;
        }
      }
      // 3번 메뉴
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
            errCount++;
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
      // 4번 메뉴
      if (selectMenu == 4) {
        System.out.println("프로그램 종료");
        break;
      }
    }
    sc.close();
  }
}
