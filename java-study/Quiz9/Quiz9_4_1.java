public class Quiz9_4_1 {

  public static void main(String[] args) {
    char arg1[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
    char arg2[] = { 'c', 'd', 'e', 'f' };
    char arg3[] = { 'k' };
    System.out.println(replace(arg1, arg2, arg3));
  }

  public static char[] replace(
    char arg1[], // 검색 대상 문자열
    char arg2[], // 찾을 문자열
    char arg3[] //  바꿀 문자열
  ) {
    // arg1 에서 arg2 문자열을 찾을 경우
    // 찾은 문자열을 arg3로 치환
    int index1 = -1; // arg2 첫번째 인덱스
    int index2 = 0; //  arg2 마지막 인덱스
    char result[] = new char[arg1.length -
    arg2.length +
    arg3.length];

    for (int i = 0; i < arg1.length; i++) {
      // result 배열에 arg1에서 찾은
      // arg2의 첫번째 인덱스(index1)와 마지막 인덱스(index2)를 구해
      // arg1를 index1자리의 하나 앞 자리까지 삽입하고
      // arg3를 삽입하여
      // index2 뒤에 남은 나머지 arg1를 삽입하여 결과 리턴
      if (arg1[i] == arg2[0]) {
        // arg2 문자열의 첫번째 문자를 찾았을 때
        for (int j = 0; j < arg2.length; j++) {
          if (arg1[i + j] != arg2[j]) {
            break;
          } else if (j == arg2.length - 1) {
            index1 = i; // arg2 첫번째 인덱스
            index2 = i + j + 1; // arg2 마지막 인덱스
          }
        }
      }
      if (index1 >= 0) {
        // arg2 문자열을 찾았을때
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
