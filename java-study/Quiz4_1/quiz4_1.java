class quiz4_1 {

  public static void main(String[] args) {
    // 1. 구구단 출력
    // 2. 짝수단 출력 구현 시, "% 연사자를 이용하여 구현"
    // 3. 출력 포맷 준수, 하드코딩 점수 없음, 반복문 안에 로직을 만들어 작성

    for (int dan = 1; dan < 10; dan++) {
      // 1단 부터 10단 까지 반복
      if (dan % 2 == 0) {
        // 단이 2의 배수일 때만 출력
        for (int gugudan = 1; gugudan < 10; gugudan++) {
          System.out.printf("%d * %d = %d\t", dan, gugudan, dan * gugudan);
          // 세번 출력 할때마다 줄바꿈
          if (gugudan % 3 == 0) System.out.println();
        }
        System.out.println();
      }
    }
  }
}
