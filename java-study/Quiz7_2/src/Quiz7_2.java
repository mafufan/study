import java.util.Scanner;

public class Quiz7_2 {

  public static void main(String[] args) {
    //키보드로 16진수 값을 문자열로 입력
    Scanner sc = new Scanner(System.in);
    System.out.println("16진수 입력");
    String inputStr = sc.nextLine();
    char[] buffer = new char[inputStr.length()];
    boolean InputErrFlag;
    while (true) {
      InputErrFlag = false;
      inputStr.getChars(0, inputStr.length(), buffer, 0);
      if (inputStr.length() > 20) {
        // a. 문자열의 최대 길이는 20자
        System.out.print(
          "최대 길이를 초과하였습니다. (최대 길이 20자)"
        );
        InputErrFlag = true;
      }
      for (int i = 0; i < buffer.length; i++) {
        if (
          // b. 입력 값 유효범위: 숫자 0 - 9, 문자 A - F
          !(
            ('0' <= buffer[i] && buffer[i] <= '9') ||
            ('A' <= buffer[i] && buffer[i] <= 'F')
          )
        ) {
          System.out.print("유효하지 않은 16진수입니다.");
          InputErrFlag = true;
          break;
        }
      }
      if (InputErrFlag) {
        // a, b 이외의 값이 들어 올 경우 재입력
        System.out.println(" 재입력하세요.");
        inputStr = sc.nextLine();
        buffer = new char[inputStr.length()];
        continue;
      }
      break;
    }
    // 16 진수 -> 10 진수
    int IntSum = 0;
    int[] IntArr = new int[buffer.length];
    for (int i = 0; i < buffer.length; i++) {
      int tmp = buffer[i] - '0';
      if (tmp > 10) {
        tmp = buffer[i] - '0' - 7;
      }
      // 16진수 -> 10진수 한것을 배열에 삽입
      IntArr[i] = tmp;
      int qwe = 1;
      for (int j = buffer.length - 1; j > i; j--) {
        qwe *= 16;
      }
      IntSum += tmp * qwe;
    }
    // 16 진수 -> 2 진수
    System.out.print("2진수 : ");
    for (int i = 0; i < IntArr.length; i++) {
      char[] binArr = new char[4];
      int tmp = IntArr[i];
      for (int j = 3; j >= 0; j--) {
        binArr[j] = (char) (tmp % 2 + '0');
        tmp = tmp / 2;
      }
      String binNum = new String(binArr);
      System.out.print(binNum + " ");
    }
    System.out.println();

    // 16 진수 -> 8진수
    System.out.print("8진수 : ");
    String OctStr = "";
    int tmp = IntSum;
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
    System.out.println("10진수: " + IntSum);
    sc.close();
  }
}
