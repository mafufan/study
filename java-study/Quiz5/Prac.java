import java.util.Scanner;

public class Prac {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 2차원 배열 줄 수와 글자 수 입력 받기
    System.out.println("입력 문자열의 줄(Line) 수를 입력하세요!");
    int lineLength = sc.nextInt();
    System.out.println("한 줄(Line)의 글자 수를 입력하세요!");
    int strLength = sc.nextInt();
    sc.nextLine(); // 개행 문자 제거

    // 입력 받은 문자열의 줄과 글자 수로 2차원 배열 생성.
    char[][] buffer = new char[lineLength][strLength];

    // 문자열 입력
    for (int i = 0; i < lineLength; i++) {
      System.out.println(i + 1 + " 번째 라인의 문자열을 입력하세요.");
      String inputStr = sc.nextLine();
      int inputStrLength = inputStr.length(); // 입력받은 문자열 길이

      // 최대 글자 수를 초과 할 경우
      if (inputStrLength > strLength) {
        // 넘어간 글자수는 최대 글자 수 만큼 자름
        inputStrLength = strLength;
      }
      inputStr.getChars(0, inputStrLength, buffer[i], 0);
    }
    for (int i = 0; i < lineLength; i++) {
      System.out.print(i + 1 + " 번째 라인 : ");
      for (int j = 0; j < strLength; j++) {
        System.out.print(buffer[i][j]);
      }
      System.out.println(".");
    }

    String searchStr; // 검색 할 문자열
    String temp = "";
    boolean searchFlag = false; // 찾았는지 확인 Flag
    int searchCnt = 0; // 검색된 횟수
    int[] searchLineIdx = new int[lineLength]; // 검색된 라인 index
    int wordsCnt = 0; // 총 단어 수
    // 검색 할 문자열이 있는지 찾기
    while (true) {
      System.out.println("검색 할 문자열을 입력하세요.");
      searchStr = sc.nextLine();
      System.out.println("검색 할 단어 : " + searchStr + ".");
      for (int i = 0; i < buffer.length; i++) {
        searchFlag = false;
        for (int j = 0; j < buffer[i].length; j++) {
          if (buffer[i][j] != (char) 0x0 && buffer[i][j] != ' ') {
            temp += buffer[i][j];
          }
          if ((buffer[i][j] == ' ' || j == buffer[i].length - 1) && temp != "") {
            System.out.print(i + 1 + "번째 라인, 단어 : " + temp + ". 단어갯수 : ");
            wordsCnt++;
            System.out.print(wordsCnt);
            if (temp.equals(searchStr)) {
              searchCnt++;
              System.out.println(" 검색!");
              searchFlag = true;
            }
            System.out.println();
            temp = "";
          }
        }
        if (searchFlag) {
          searchLineIdx[i] = i + 1;
        }
      }
      if (searchCnt == 0) {
        // 검색 할 문자를 못 찾았을 경우
        System.out.print("찾을 수가 없습니다. ");
        wordsCnt = 0;
        continue;
      }
      break;
    }

    System.out.println(searchStr + "를 찾았습니다.");
    // System.out.println("검색된 라인 수 : " + );
    // System.out.println("검색된 횟수 : " + );
    System.out.print("검색된 라인 수 : ");
    for (int i = 0; i < searchLineIdx.length; i++) {
      if (searchLineIdx[i] == 0) {
        continue;
      }
      System.out.print(searchLineIdx[i] + ",");
    }
    System.out.println();
    System.out.println("검색된 회수 : " + searchCnt);
    System.out.println("총 단어 수 : " + wordsCnt);
    sc.close();
  }
}
