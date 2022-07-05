public class prac {

  public static void main(String[] args) {
    int num = 10;
    char arr[] = new char[4];
    int count = 3;
    while (num != 0) {
      arr[count] = (char) (num % 2 + '0');
      count--;
      num = num / 2;
    }
    String here = new String(arr);
    System.out.println(here);
  }
}
