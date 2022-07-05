public class Extest6 {

  // 예외 발생 시키기
  public static void main(String[] args) {
    try {
      Exception e = new Exception("고의로 발생");
      throw e; // 예외를 발생시킴
      // throw new Exception("고의로 발생")
      // 위에 두줄을 한줄로 쓸수 있음.
    } catch (Exception e) {
      System.out.println("에러 메시지 : " + e.getMessage());
      e.printStackTrace();
    }
    System.out.println("프로그램 정상 종료.");
  }
}
