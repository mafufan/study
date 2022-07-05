// 클래스는 단일 상속
// 인터페이스는 다중 상속
interface A {
  int a = 2;
}

interface B extends A {
  int a = 3;
}

interface C extends A {}

interface D extends B, C {}

class test implements D {

  @Override
  public void prt() {
    System.out.println(a);
  }
}

public class interfacePrac {

  public static void main(String args[]) {}
}
