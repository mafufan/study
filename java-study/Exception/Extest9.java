import java.util.Scanner;

public class Extest9 {

  // try-catch
  public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    try {
      System.out.println("이름을 입력해 주세요 : ");
      String inputValue = sn.nextLine();
      System.out.println(
        "안녕하세요! " + insertName(inputValue)
      );
    } catch (Exception e) {
      System.out.println(
        e.getMessage() + " : 다시 입력해 주세요."
      );
    }
  }

  static String insertName(String argValue)
    throws Exception {
    if (argValue.equals("")) {
      throw new Exception("이름이 유효하지 않습니다.");
    }
    return argValue;
  }
}
