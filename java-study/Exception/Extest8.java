public class Extest8 {

  // 예외를 던짐 throws
  // method2 -> method1 -> main
  public static void main(String[] args) throws Exception {
    System.out.println("method1 실행");
    method1();
  }

  static void method1() throws Exception {
    System.out.println("method2 실행");
    method2();
  }

  static void method2() throws Exception {
    System.out.println("예외 발생!");
    throw new Exception();
  }
}
