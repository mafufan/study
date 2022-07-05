public class Quiz9_3_1 {

  public static void main(String[] args) {
    char arg1[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
    char arg2[] = { 'c', 'd' };
    System.out.println(searchWord(arg1, arg2));
  }

  public static int searchWord(char arg1[], char arg2[]) {
    // arg1에서 arg2 문자열을 찾을 경우 시작 인덱스 값 리턴
    // 찾는 문자열이 없을 경우 "-1" 반환
    int result = -1;
    for (int i = 0; i < arg1.length; i++) {
      if (arg1[i] == arg2[0]) {
        // arg1[i]가 arg2 첫번째 문자와 같을때
        for (int j = 0; j < arg2.length; j++) {
          if (arg1[i + j] != arg2[j]) {
            // arg1[i]가 arg2의 다음 문자와 같지 않을때
            // 반복문 종료
            break;
          } else if (j == arg2.length - 1) {
            // arg1에 arg2의 모든 문자가 포함되었을 때
            // 첫번째 문자의 인덱스 값 삽입
            result = i;
          }
        }
      }
    }
    return result;
  }
}
