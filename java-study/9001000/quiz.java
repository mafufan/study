class quiz {

  public static void main(String[] args) {
    // 900 부터 1000 까지 나눠서
    // 0 이 될때 까지의 횟수가 가장 많은 숫자 구하기
    int count = 0;
    int max = 1;
    int maxNum = 0;
    for (int i = 10; i <= 10; i++) {
      //10 5 16 8 4 2 1
      int n = i;
      count = 0;
      while (n != 1) {
        count++;
        if (n % 2 == 0) {
          n = n / 2;
        } else if (n % 2 != 0) {
          n = n * 3 + 1;
        }
      }

      System.out.println(i + " : " + count);
      if (max < count) {
        maxNum = i;
        max = count;
      }
    }
    System.out.println();
    System.out.println(maxNum + " : " + max);
  }
}
