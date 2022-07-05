public class Quiz9_3_2 {

  public static void main(String[] args) {
    int index = indexOf(
      new String("abcdefg").toCharArray(),
      new String("cde").toCharArray()
    );
    System.out.println(index);
  }

  public static int indexOf(char arg1[], char arg2[]) {
    // arg1에서 arg2 문자열을 찾을 경우 시작 인덱스 값 리턴
    // 찾는 문자열이 없을 경우 "-1" 반환
    int result = -1;
    for (int i = 0; i < arg1.length; i++) {
      if (arg1[i] == arg2[0]) {
        for (int j = 0; j < arg2.length; j++) {
          if (arg1[i + j] != arg2[j]) {
            break;
          } else if (j == arg2.length - 1) {
            result = i;
          }
        }
      }
    }
    return result;
  }
}
