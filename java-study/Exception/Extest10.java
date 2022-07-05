import java.util.Scanner;

public class Extest10 {

  // finally 블럭
  public static void main(String[] args) {
    System.out.println("이름을 입력하세요 : ");
    Scanner sn = new Scanner(System.in);
    String name = sn.nextLine();
    insertName(name);
  }

  static void insertName(String inputValue) {
    try {
      if (inputValue.equals("")) {
        throw new Exception("이름이 유효하지 않습니다.");
      }
      System.out.println("안녕하세요, " + inputValue);
    } catch (Exception e) {
      System.out.println("에러 메세지" + e.getMessage());
    } finally {
      System.out.println("프로그램 종료");
    }
  }
}
