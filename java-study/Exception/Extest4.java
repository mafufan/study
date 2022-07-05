public class Extest4 {

  // printStackTrace(), getMessage()
  public static void main(String[] args) {
    try {
      System.out.println(0 / 0); //예외발생
      System.out.println(4);
    } catch (ArithmeticException ae) {
      ae.printStackTrace();
      //예외발생당시 CallStack에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
      System.out.println("예외메시지 : " + ae.getMessage());
      // 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.
    }
  }
}
