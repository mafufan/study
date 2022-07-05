class Quiz9_1 {

  public static void main(String[] args) {
    char value1[] = { 'h', 'e', 'l', 'l', 'o' };
    char value2[] = { ' ', 'w', 'o', 'r', 'l', 'd' };

    char values[] = concatenate(value1, value2);

    System.out.println(values);
  }

  public static char[] concatenate(
    // arg1 + arg2 결과 값 반환 메서드 작성
    char arg1[],
    char arg2[]
  ) {
    char result[] = new char[arg1.length + arg2.length];
    // 배열의 크기를 arg1 길이 + arg2 길이 만큼 생성

    for (int i = 0; i < arg1.length; i++) {
      result[i] = arg1[i];
      // result에 arg1 삽입
    }
    for (
      int i = arg1.length;
      i < arg1.length + arg2.length;
      i++
    ) {
      result[i] = arg2[i - arg1.length];
      // result에 arg2 삽입
    }

    return result;
  }
}
