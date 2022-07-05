import java.util.Scanner;

public class Exam2 {

  Scanner sc = new Scanner(System.in);
  String[] words = new String[3]; // 입력받은 문자열 단어들을 입력 받는 배열

  void inputWords() {
    // 키보드로 단어 입력
    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        System.out.println("첫 번째 단어를 입력하세요");
      } else if (i == 1) {
        System.out.println("두 번째 단어를 입력하세요");
      } else if (i == 2) {
        System.out.println("세 번째 단어를 입력하세요");
      }
      while (true) {
        // 글자 길이가 3 ~ 20 사이 인지 확인
        words[i] = sc.nextLine();
        if (
          !(
            3 <= words[i].length() &&
            words[i].length() <= 20
          )
        ) {
          System.out.println(
            "3이상 20이하 글자로 구성된 단어를 입력 하세요."
          );
          continue;
        }
        break;
      }
    }
  }

  String selectedWord = ""; // 랜덤하게 뽑힌 단어

  void selectWord() {
    // 입력한 단어들 중 랜덤하게 단어 하나를 뽑음
    int random = (int) (Math.random() * 2);
    selectedWord = words[random];
  }

  void gameStart() {
    // 게임 시작
    selectWord(); // 랜덤하게 단어 하나를 뽑음
    System.out.println(
      "단어 선택 완료 게임을 시작 합니다. 선택된 단어 : " +
      selectedWord
    );
  }

  char[] buffer; // 선택된 단어를 char문자열로 변환

  void toBuffer() {
    // 선택된 단어를 char 배열인 buffer로 변환
    buffer = new char[selectedWord.length()]; // 단어의 길이만큼 배열 크기 생성

    for (int i = 0; i < selectedWord.length(); i++) {
      buffer[i] = selectedWord.charAt(i);
    }
  }

  char[] blindBuffer; // buffer중 일부를 '_'로 바꾼 문자 배열

  void wordBlind() {
    // buffer중 일부를 '_'로 바꾼 blindBuffer 생성
    blindBuffer = new char[buffer.length];

    int time; // '_'로 바꾸는 횟수(buffer길이의 절반값의 반올림한 수)
    if (buffer.length % 2 != 0) {
      time = (buffer.length + 1) / 2;
    } else {
      time = (buffer.length) / 2;
    }

    // blindBuffer에 buffer를 복사
    for (int i = 0; i < buffer.length; i++) {
      blindBuffer[i] = buffer[i];
    }

    // blindBuffer중 랜덤한 index의 문자를 time만큼 '_'로 변환
    for (int i = 0; i < time; i++) {
      int randomIdx = (int) (
        Math.random() * (buffer.length - 1)
      );
      blindBuffer[randomIdx] = '_';
    }
  }

  void printBlindBuffer() {
    // BlindBuffer를 출력
    for (int i = 0; i < blindBuffer.length; i++) {
      System.out.print(blindBuffer[i]);
    }
    System.out.println();
  }

  int correctCount; // 맞춘 단어의 횟수
  char inputText; //   입력한 문자
  int gameCount; //    게임 반복 횟수

  void playGame() {
    // 게임 플레이
    boolean endFlag = false; // 게임 종료 Flag
    gameCount = 0;
    while (true) {
      // blindBuffer = buffer(단어를 전부다 찾으면), 게임종료
      // 게임 종료 : Flag=True
      gameCount++;
      System.out.printf(
        "\n%d번째 시도, 아래 단어를 구성하는 알파벳 한 개 입력하세요.\n",
        gameCount
      );
      printBlindBuffer();
      inputText = sc.nextLine().charAt(0); // 맞출 단어 하나를 입력

      // 입력한 단어가 buffer에 존재할 때 correctCount++
      for (int i = 0; i < buffer.length; i++) {
        if (inputText == buffer[i]) {
          correctCount++;
        }
      }

      // 입력한 단어가 buffer에 존재하지 않을때(correctCount = 0)
      if (correctCount == 0) {
        System.out.println(
          "단어 내 포함되지 않은 알파벳입니다."
        );
      }

      // 하나 이상 맞췄을 경우
      if (correctCount > 0) {
        correct(); // 맞춘 문자 자리의 '_'를 원래 문자로 변환
        correctCount = 0;
      }

      // 그렇지 않으면 게임 계속 진행
      for (int i = 0; i < buffer.length; i++) {
        // 단어를 아직 다 못 찾은 경우
        if (buffer[i] != blindBuffer[i]) {
          endFlag = false;
          break;
        }
        // 단어를 모두 찾은 경우
        endFlag = true;
      }

      if (endFlag == true) {
        gameResult(); // 게임 결과 출력
        break;
      }
    }
  }

  void correct() {
    // *입력한 문자 하나가 단어에 존재할때 실행
    // blindBuffer에 맞춘 문자 자리의 '_'를 원래 문자로 변환
    System.out.print(
      "\n입력한 알파벳 단어 내 포함 :" + correctCount
    );
    for (int i = 0; i < buffer.length; i++) {
      if (inputText == buffer[i]) {
        blindBuffer[i] = buffer[i];
      }
    }
  }

  void gameResult() { // 게임 결과 출력
    // 게임이 끝남
    System.out.printf(
      "Clear - 선택된 단어 : %s, 총 시도 횟수 : %d",
      selectedWord,
      gameCount
    );
  }

  void start() {
    inputWords(); // 키보드로 문자열인 단어 입력
    gameStart(); //  게임 시작
    toBuffer(); //   buffer : 입력받은 문자열을 문자 배열에 하나씩 넣음
    wordBlind(); //  BlindBuffer : 랜덤한 Index자리에 '_'로 바꿈
    playGame(); //   게임 플레이
  }

  public static void main(String[] args) {
    Exam2 m = new Exam2();
    m.start(); // 실행
  }
}
