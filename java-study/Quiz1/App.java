import java.util.Scanner;

class Menu {

  Scanner sc = new Scanner(System.in);
  int selectMenu;

  void print() {
    System.out.println("---------------------");
    System.out.println("1. 구구단 출력");
    System.out.println("2. 프로그램 종료");
    System.out.println("---------------------");
  }

  void selectMenu() {
    while (true) {
      selectMenu = sc.nextInt();
      if (selectMenu == 1) {
        break;
      } else if (selectMenu == 2) {
        break;
      } else {
        System.out.println(
          "잘못 입력하셨습니다. 다시 입력하세요."
        );
        continue;
      }
    }
  }

  void gugudan() {
    if (selectMenu == 1) {
      System.out.println(
        "출력할 구구단의 단을 입력하세요. 구구단의 단은 2~9 사이 입력"
      );
      int gugudan = sc.nextInt();
      while (true) {
        if (!(1 <= gugudan && gugudan <= 9)) {
          System.out.println(
            "2~9사이 정수를 입력해주세요."
          );
          gugudan = sc.nextInt();
          continue;
        }
        break;
      }
      for (int i = 1; i <= 9; i++) {
        System.out.printf(
          "%d X %d = %d\n",
          gugudan,
          i,
          gugudan * i
        );
      }
    }
  }
}

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Menu m = new Menu();
    m.print();
    m.selectMenu();
    m.gugudan();
    System.out.println("프로그램 종료.");
  }
}
