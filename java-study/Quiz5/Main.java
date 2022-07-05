import java.util.Scanner;

public class Main {

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

    // 배열에 넣을 문자열 입력
    for (int i = 0; i < lineLength; i++) {
      System.out.println(i + 1 + " 번째 라인의 문자열을 입력하세요.");
      String inputStr = sc.nextLine();
      int inputStrLength = inputStr.length(); // 입력받은 문자열 길이
      // 입력한 문자열의 길이가 최대 글자 수를 초과한 경우
      if (inputStrLength > strLength) {
        // 초과한 글자수는 최대 글자 수의 길이 만큼 자름
        inputStrLength = strLength;
      }
      inputStr.getChars(0, inputStrLength, buffer[i], 0);
    }

    String searchStr; // 검색 할 문자열
    String temp = ""; // 빈 문자열
    boolean searchFlag = false; // 찾았는지 확인 Flag
    int searchCnt = 0; // 검색된 횟수
    int[] searchLineIdx = new int[lineLength]; // 검색된 라인 index
    int wordsCnt = 0; // 총 단어 수

    // 검색 할 문자열이 배열에 있는지 찾기
    while (true) {
      System.out.println("검색 할 문자열을 입력하세요.");
      searchStr = sc.nextLine();

      for (int i = 0; i < buffer.length; i++) {
        searchFlag = false; // false로 초기화
        for (int j = 0; j < buffer[i].length; j++) {
          // 현재 위치에 있는 문자가 null이 아니고 ' '이 아닌 경우 -> 문자일 경우에만
          if (buffer[i][j] != (char) 0x0 && buffer[i][j] != ' ') {
            // 빈 문자열에 현재 위치에 있는 문자 하나를 삽입
            temp += buffer[i][j];
          }
          // 현재 위치에 있는 문자가 공백이거나, 마지막 반복일때 && temp문자열이 빈 문자열이 아닐때
          if ((buffer[i][j] == ' ' || j == buffer[i].length - 1) && temp != "") {
            wordsCnt++; // 총 단어 수 +1
            // temp와 검색할 문자열이 일치할 시
            if (temp.equals(searchStr)) {
              searchCnt++; // 검색된 횟수 +1
              searchFlag = true; // 문자열이 검색 됨
            }
            temp = ""; // 빈 문자열로 초기화
          }
        }
        // 문자열이 검색 되었을 경우
        if (searchFlag) {
          // 겸색 된 라인의 index를 삽입
          searchLineIdx[i] = i + 1;
        }
      }
      // 검색된 횟수가 0일 경우
      if (searchCnt == 0) {
        System.out.print("찾을 수가 없습니다. ");
        wordsCnt = 0; // 총 단어 수를 0으로 초기화
        continue; // 검색할 문자열 다시 입력
      }
      break;
    }

    // 결과 출력
    System.out.println(searchStr + "를 찾았습니다.");
    System.out.print("검색된 라인 수 : ");
    for (int i = 0; i < searchLineIdx.length; i++) {
      // 검색되지 않은 라인은 출력하지 않음
      if (searchLineIdx[i] == 0) {
        continue;
      }
      System.out.print(searchLineIdx[i]);
      // 마지막 반복에는 ','를 출력하지 않음
      if (i + 1 < searchLineIdx.length) {
        System.out.print(", ");
      }
    }
    System.out.println();
    System.out.println("검색된 횟수 : " + searchCnt);
    System.out.println("총 단어 수 : " + wordsCnt);
    sc.close();
  }
}
