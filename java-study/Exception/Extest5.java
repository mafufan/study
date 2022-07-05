public class Extest5 {

  // 멀티 catch 블럭
  public static void main(String[] args) {
    try {
      // System.out.println(0 / 0);
      System.out.println(args[0]);
    } catch (
      ArithmeticException | ArrayIndexOutOfBoundsException e
    ) {
      if (
        e instanceof ArithmeticException
      ) System.out.println(
        "ArithmeticException 예외 처리"
      ); else {
        System.out.println(
          "ArrayIndexOutOfBoundsException 예외처리"
        );
      }
    }
  }
}
