public class Quiz9_4_2 {

  public static void main(String[] args) {
    char result[] = replace(
      new String("abcdefg").toCharArray(),
      new String("cde").toCharArray(),
      new String("k").toCharArray()
    );
    System.out.println(result);
  }

  public static char[] replace(
    char arg1[],
    char arg2[],
    char arg3[]
  ) {
    int index1 = -1;
    int index2 = 0;
    char result[] = new char[arg1.length -
    arg2.length +
    arg3.length];

    for (int i = 0; i < arg1.length; i++) {
      if (arg1[i] == arg2[0]) {
        for (int j = 0; j < arg2.length; j++) {
          if (arg1[i + j] != arg2[j]) {
            break;
          } else if (j == arg2.length - 1) {
            index1 = i; // index1 = arg2 첫 문자 위치
            index2 = i + j + 1; // index2 = arg2 마지막 문자 위치
          }
        }
      }
      // arg2 문자열을 찾았을때
      if (index1 >= 0) {
        for (int k = 0; k < index1; k++) {
          result[k] = arg1[k];
        }
        for (int k = 0; k < arg3.length; k++) {
          result[k + index1] = arg3[k];
        }
        for (int k = 0; k < arg1.length - index2; k++) {
          result[k + index1 + arg3.length] =
            arg1[k + index2];
        }
      }
    }

    return result;
  }
}
