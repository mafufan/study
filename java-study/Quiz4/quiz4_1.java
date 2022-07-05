class quiz4_1 {

  public static void main(String[] args) {
    for (int dan = 1; dan < 10; dan++) { // 1단 부터 10단 까지
      if (dan % 2 == 0) { // 단이 2의 배수일 때만 출력
        for (int gugudan = 1; gugudan < 10; gugudan++) {
          System.out.printf("%d * %d = %d\t", dan, gugudan, dan * gugudan);
          if (gugudan % 3 == 0) System.out.println(); // 세번 출력 할때마다 줄바꿈
        }
        System.out.println();
      }
    }
  }
}
