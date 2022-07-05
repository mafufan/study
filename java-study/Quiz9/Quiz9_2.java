public class Quiz9_2 {

  public static void main(String[] args) {
    boolean result = compareTo(
      new String("문자열1").toCharArray(),
      new String("문자열2").toCharArray()
    );
    System.out.println(result ? "같음" : "다름");
  }

  public static boolean compareTo(
    char arg1[],
    char arg2[]
  ) {
    // arg1와 arg2 문자열 비교 후
    // 일치 할 경우 "참", 아닐 경우 "거짓" 반환
    boolean equal = false;
    if (arg1.length == arg2.length) {
      // arg1과 arg2의 길이가 같으면
      for (int i = 0; i < arg1.length; i++) {
        if (arg1[i] != arg2[i]) {
          // 문자 비교시 다른 문자가 있으면 반복문 종료
          break;
        } else if (i == arg1.length - 1) {
          // 모든 문자가 같으면(마지막 반복일때)
          equal = true;
          break;
        }
      }
    }
    return equal;
  }
}
