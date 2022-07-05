import java.util.Random;

public class app {

  char[][] table = new char[8][8];
  int[] textCount = new int[26];
  int max;
  int min;

  void makeTable() {
    // a ~ z 알파벳을 랜덤하게 선택 후 저장, 중복 OK
    // Random 함수 사용
    // a = 49 26개
    // z = 74
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char text = (char) (Math.random() * 26 + 'a');
        table[i][j] = text;
      }
    }
  }

  void printTable() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        System.out.print(table[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  void checkTextCount() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        textCount[table[i][j] - '0' - 49] += 1;
      }
    }
  }

  void checkMinMax() {
    max = 0;
    min = 26;
    for (int i = 0; i < 26; i++) {
      if (textCount[i] > max) {
        max = textCount[i];
      }
      if (textCount[i] != 0 && textCount[i] < min) {
        min = textCount[i];
      }
    }
  }

  void printMax() {
    System.out.println("최대 발생 알파벳");
    System.out.println("- 발생 빈도 : " + max);
    System.out.print("- 중복 알파벳 개수 : ");
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (textCount[i] == max) {
        count++;
      }
    }
    System.out.println(count);
    System.out.print("- 알파벳 : ");
    String tmp = "";
    for (int i = 0; i < 26; i++) {
      if (textCount[i] == max) {
        tmp += (char) ('a' + i);
        tmp += ", ";
      }
    }
    tmp = tmp.replaceAll(", $", "");
    System.out.printf(tmp + "\n\n");
  }

  void printMin() {
    System.out.println("최대 발생 알파벳");
    System.out.println("- 발생 빈도 : " + min);
    System.out.print("- 중복 알파벳 개수 : ");
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (textCount[i] == min) {
        count++;
      }
    }
    System.out.println(count);
    System.out.print("- 알파벳 : ");
    String tmp = "";
    for (int i = 0; i < 26; i++) {
      if (textCount[i] == min) {
        tmp += (char) ('a' + i);
        tmp += ", ";
      }
    }
    tmp = tmp.replaceAll(", $", "");
    System.out.printf(tmp + "\n\n");
  }

  void sortTable() {
    int[][] sortTable = new int[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        for (int z = 0; z < textCount[i + j]; z++) {
          sortTable[i][j] = (char) ('a' + i + j);
        }
      }
    }
  }

  void start() {
    makeTable();
    printTable();
    checkTextCount();
    checkMinMax();
    printMax();
    printMin();
    sortTable();
  }

  public static void main(String[] args) {
    app m = new app();
    m.start();
  }
}
