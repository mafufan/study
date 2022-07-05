import java.util.Scanner;

class InputHex {

  // 16진수를 입력받아서 buffer를 출력하는 클래스
  Scanner sc; // 스캐너
  String inputStr; // 입력받은 문자열
  char[] buffer; // 입력받은 문자열을 하나씩 나눔

  char[] makeBuffer() {
    sc = new Scanner(System.in);
    System.out.println("16진수 입력");
    inputStr = sc.nextLine(); // 키보드로 16진수를 문자열로 입력받음
    buffer = new char[inputStr.length()]; // 입력받은 문자열의 길이만큼 char 배열 생성
    boolean InputErrFlag; // 잘못된 입력이 있는지 없는지 확인하는 Flag
    while (true) {
      // 잘못된 입력이 없으면 break 되는 반복문
      InputErrFlag = false; // false로 초기화
      inputStr.getChars(0, inputStr.length(), buffer, 0);
      // 입력받은 문자열을 하나씩 buffer 배열에 저장

      if (inputStr.length() > 20) {
        // a. 문자열의 최대 길이는 20자
        System.out.print(
          "최대 길이를 초과하였습니다. (최대 길이 20자)"
        );
        InputErrFlag = true; // 잘못된 입력 확인
      }
      for (int i = 0; i < buffer.length; i++) {
        // buffer의 모든 문자가 올바른 범위내의 값인지 검사
        if (
          // b. 입력 값 유효범위: 숫자 0 - 9, 문자 A - F
          !(
            ('0' <= buffer[i] && buffer[i] <= '9') ||
            ('A' <= buffer[i] && buffer[i] <= 'F')
          )
        ) {
          System.out.print("유효하지 않은 16진수입니다.");
          InputErrFlag = true; // 잘못된 입력 확인
          break; // 잘못된 입력이 발견되는 순간 반복문 탈출
        }
      }
      if (InputErrFlag) {
        // a, b 이외의 값이 들어 올 경우 재입력
        System.out.println(" 재입력하세요.");
        inputStr = sc.nextLine();
        buffer = new char[inputStr.length()]; // buffer 초기화
        continue; // while 반복문 처음으로
      }
      break; // while 반복문 탈출
    }
    return buffer; // 올바르게 입력된 16진수를 buffer로 반환
  }
}

class Converter {

  // 16진수를 10진수로 변환후 2진수, 8진수로 변환하는 클래스
  public int DecNum = 0; // 10진수로 변환된 값
  public char[] buffer;
  public int[] DecArr; // 10진수 배열

  public void toDec() {
    DecArr = new int[buffer.length];
    for (int i = 0; i < buffer.length; i++) {
      int tmp = buffer[i] - '0'; // 현재 문자를 숫자로 변환
      if (tmp > 10) {
        // 현재 문자가 0 ~ 9가 아닐경우 = 'A' ~ 'F' 일 경우
        tmp = buffer[i] - '0' - 7;
      }
      DecArr[i] = tmp; // 16진수 -> 10진수 한것을 10진수 배열에 삽입
      int HexSquare = 1;
      for (int j = buffer.length - 1; j > i; j--) {
        HexSquare *= 16;
      }
      DecNum += tmp * HexSquare;
    }
  }

  public void toBin() {
    // 10진수를 2진수로 변환
    System.out.print("2진수 : ");
    for (int i = 0; i < DecArr.length; i++) {
      char[] binArr = new char[4];
      int tmp = DecArr[i];
      for (int j = 3; j >= 0; j--) {
        binArr[j] = (char) (tmp % 2 + '0');
        tmp = tmp / 2;
      }
      String binNum = new String(binArr);
      System.out.print(binNum + " ");
    }
    System.out.println();
  }

  public void toOct() {
    // 10진수를 8진수로 변환
    System.out.print("8진수 : ");
    String OctStr = "";
    int tmp = DecNum;
    while (tmp != 0) {
      OctStr += (char) (tmp % 8 + '0');
      tmp = tmp / 8;
    }
    char[] OctNum = new char[OctStr.length()];
    OctStr.getChars(0, OctStr.length(), OctNum, 0);
    for (int i = OctNum.length - 1; i >= 0; i--) {
      System.out.print(OctNum[i]);
    }

    System.out.println();
  }
}

public class Quiz7_2 {

  public static void main(String[] args) {
    //키보드로 16진수 값을 문자열로 입력
    InputHex hex = new InputHex(); // hex : 16진수 buffer를 만드는 객체
    char[] buffer = hex.makeBuffer();
    // 16진수 숫자를 문자열로 입력하여 문자를 하나씩 쪼개서 buffer에 저장
    Converter cvt = new Converter(); // cvt : 16진수를 다른 진수로 변환하는 객체
    cvt.buffer = buffer; // 반환된 buffer를 cvt객체에 보내줌
    // 16 진수 -> 10 진수
    cvt.toDec();
    // 10 진수 -> 2 진수
    cvt.toBin();
    // 10 진수 -> 8진수
    cvt.toOct();

    System.out.println("10진수: " + cvt.DecNum);
  }
}
