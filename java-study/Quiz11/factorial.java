public class factorial {

  public static void main(String[] args) {
    int inputValue = 3;
    System.out.println(
      inputValue + "! = " + factorial(inputValue)
    );
  }

  public static int factorial(int num) {
    int result;
    if (num == 1) {
      result = 1;
    } else {
      result = num * factorial(num - 1);
    }
    System.out.println(num + " : " + result);
    return result;
  }
}
