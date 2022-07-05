package foo;

class foo {

  void print(int a) {
    System.out.println("int " + a);
  }

  void print(String a) {
    System.out.println("String " + a);
  }

  void print(float a) {
    System.out.println("float " + a);
  }

  void print(char a) {
    System.out.println("char " + a);
  }

  void print(Float b, double c) {
    System.out.println("f b : " + c + ", " + b);
  }

  void print(double b, Float c) {
    System.out.println("d f : " + b + ", " + c);
  }

  void print(double b, double c) {
    System.out.println("d d : " + b + ", " + c);
  }
}

class Player {

  void shoot() {
    System.out.println("슛을 쏜다.");
  }
}

class Forward extends Player {

  void shoot() {
    System.out.println("Forward shoot");
    super.shoot();
  }
}

public class Prac1 {

  public static void main(String[] args) {
    Player obj[] = new Player[5];
    obj[0] = new Forward();
    obj[0].shoot();
  }
}
