class A {

  void L1() throws Exception {
    try {
      L2();
    } catch (Exception e) {}
  }

  void L2() throws Exception {
    L3();
    Exception e = new Exception();
    throw e;
  }

  void L3() {
    /* // 예외 객체 생성
    RuntimeException e = new RuntimeException(
      "Exception test"
    );
    
    System.out.println("1");
    
    // 예외 객체를 던진다.
    throw e;
    // 아래 문장이 실행 될까요?
    //System.out.println("2"); */

    // 예외 객체 생성
    /* try {
      Exception e = new Exception("Exception test");
      throw e;
    } catch (Exception e) {
      System.out.println("예외처리 완료");
    } */
    // 예외 객체를 던진다.
    // 아래 문장이 실행 될까요?
    //System.out.println("2");
  }
}

public class ExceptionTest {

  public static void main(String[] args) throws Exception {
    A a = new A();
    a.L1();
    int jCount = 0;
    while (jCount <= 100) {
      System.out.print("*");
      Thread.sleep(100);
      /* try {
        Thread.sleep(100);
      } catch (Exception e) {} */
      jCount++;
    }
  }
}
