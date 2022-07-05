class bar {

  static String hello = "hello";
  static String hi = "hi";

  static void sayHello() {
    System.out.println(hello);
  }

  static void hi() {
    System.out.println(hi);
  }
}

public class Prac1 {

  public static void main(String[] args) {
    bar obj = new bar();
    bar.sayHello();
    obj.hi();
  }
}
