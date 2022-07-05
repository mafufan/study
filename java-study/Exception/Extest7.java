public class Extest7 {

  // checked예외, uncheck예외
  public static void main(String[] args) {
    // checked : 예외 처리 필수
    try {
      throw new Exception();
    } catch (Exception e) {}
    // unchecked : 컴파일 ok
    throw new RuntimeException();
    System.out.println("실행안됨"); // 컴파일만 ok
  }
}
