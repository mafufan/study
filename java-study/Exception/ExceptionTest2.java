import java.io.IOException;
import java.text.ParseException;

class MyB {

  void doSomething() throws Exception {
    System.out.println("부모 Exception 예외 처리 완료");
  }
  // void L1() {
  //   try {
  //     if (true) {
  //       IOException obj = new IOException();
  //       throw obj;
  //     }
  //   } catch (Exception e) {
  //     System.out.println("1");
  //   } finally {
  //     System.out.println("2");
  //   }
  //   System.out.println("3");
  // }
}

class MyA extends MyB {

  void doSomething() throws ParseException, IOException {
    // System.out.println("자식 IOException 예외 처리 완료");
    System.out.println(
      "자식 ParseException 예외 처리 완료"
    );
  }
}

/*
  void L1() {
    try {
      int value = 1;

      if (value == 0) {
        IOException obj = new IOException();
        throw obj;
      } else if (value == 1) {
        ParseException obj = new ParseException("hello", 2);
        throw obj;
      }
    } catch (Exception e) {}
      catch (IOException e) {
      System.out.println("IOException");
      } catch (ParseException e) {
      System.out.println("ParseException");
      } 
    System.out.println("2");
  }
  */

public class ExceptionTest2 {

  public static void main(String[] args) throws Exception {
    MyA obj = new MyA();

    // obj.L1();
    obj.doSomething();
  }
}
