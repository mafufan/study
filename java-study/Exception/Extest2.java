public class Extest2 {

  public static void main(String[] args) {
    try {
      System.out.println(1);
      System.out.println(2);
      System.out.println(3);
      System.out.println(0 / 0);
      // ArithmeticException예외발생!}
      System.out.println(4); // 실행안됨
    } catch (ArithmeticException ae) {
      if (
        ae instanceof ArithmeticException
      ) System.out.println("ArithmeticException 예외 처리");
    } catch (Exception e) {
      System.out.println("모든 예외 처리");
    }
    System.out.println(5);
  }
}
