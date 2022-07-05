// backward compatibility

interface bracket {
  void prtSomething();

  static void prtHello() {
    System.out.println("hello");
  }
  /* default void prtHello() {
    System.out.println("hello");
  } */

}

class bar implements bracket {

  public void prtSomething() {}

  public void prtHello() {}
}

class foo implements bracket {

  public void prtSomething() {}

  public void prtHello() {}
}

// ---------------------------//

class NewBar implements bracket {

  public void prtSomething() {}

  public void prtHello() {
    System.out.println("안녕하세요");
  }
}

public class ITtest {

  public static void main(String[] args) {
    NewBar obj = new NewBar();
    obj.prtHello();
    bracket.prtHello();
  }
}
