import java.time.LocalDateTime;
import java.util.Scanner;

class MyException extends Exception {

  static final int notMenu = -1;
  int errCode = 0;

  MyException(String argMsg, int argCode) {
    super(argMsg);
    errCode = argCode;
  }

  int getErrCode() {
    return errCode;
  }
}

class MyConsoleInput {

  static int getInputMenu() throws MyException {
    Scanner sn = new Scanner(System.in);
    int inputValue = sn.nextInt();
    if (inputValue < 1 || inputValue > 3) {
      throw new MyException(
        "다시 입력하세요.",
        MyException.notMenu
      );
    }
    return inputValue;
  }
}

class Student {

  int id;
  String name;
  int gradeKor;
  int gradeEng;
  int gradeMath;
  private int sum;
  private float avg;
  LocalDateTime inputDateTime;

  Student(int argId, String argName) {
    id = argId;
    name = argName;
    getInputDateTime();
  }

  void setGrade(int argKor, int argEng, int argMath) {
    gradeKor = argKor;
    gradeEng = argEng;
    gradeMath = argMath;
    sum = getSum();
    avg = getAvg();
  }

  int getSum() {
    sum = gradeKor + gradeEng + gradeMath;
    return sum;
  }

  float getAvg() {
    avg = (float) (sum / 3);
    return avg;
  }

  LocalDateTime getInputDateTime() {
    return inputDateTime = LocalDateTime.now();
  }

  public String toString() {
    return String.format(
      "[id : %d name : %s kor : %d eng : %d math : %d sum : %d avg : %.1f date : %s년 %s월 %s일 %s시 %s분 %s초]\n",
      id,
      name,
      gradeKor,
      gradeEng,
      gradeMath,
      sum,
      avg,
      inputDateTime.getYear(),
      inputDateTime.getMonthValue(),
      inputDateTime.getDayOfMonth(),
      inputDateTime.getHour(),
      inputDateTime.getMinute(),
      inputDateTime.getSecond()
    );
  }
}

class MyList {

  Node head;
  Node tail;
  int numOfNode = 0;
  float avg = 0;

  MyList() {
    tail = new Node(null, null);
    head = new Node(null, tail);
  }

  int addNode(Student argValue) {
    Node temp = head;
    while (temp.getNextNode() != tail) {
      temp = temp.getNextNode();
    }
    Node newNode = new Node(argValue, tail);
    temp.setNextNode(newNode);
    avg += argValue.getAvg();
    return numOfNode++;
  }

  int getSize() {
    return numOfNode;
  }

  float getAvg() {
    if (numOfNode != 0) {
      avg = (float) (avg / numOfNode);
    }
    return avg;
  }

  public String toString() {
    String str = "";
    Node temp = head.getNextNode();
    while (temp.getNextNode() != null) {
      str += temp.getValue().toString();
      temp = temp.getNextNode();
    }
    return str;
  }
}

class Node {

  Student value;
  Node nextNode;

  Node(Student argValue, Node argNode) {
    value = argValue;
    nextNode = argNode;
  }

  Student getValue() {
    return value;
  }

  Node getNextNode() {
    return nextNode;
  }

  void setNextNode(Node argNode) {
    nextNode = argNode;
  }
}

class LinkedStudentInfo {

  static void printMenu(int argSize, float argAvg) {
    System.out.println("========================");
    System.out.println(" 1. 학생 성적 입력");
    System.out.println(" 2. 학생 목록 출력(입력 순)");
    System.out.println(" 3. 프로그램 종료\n");
    System.out.println("현 입력데이터 갯수 : " + argSize);
    System.out.println("전체 학생 평균 값 : " + argAvg);
    System.out.println("========================");
  }

  static Student inputInfo() {
    Scanner sn = new Scanner(System.in);
    System.out.println("학번을 입력하세요.");
    int id = sn.nextInt();
    System.out.println("이름을 입력하세요.");
    sn.nextLine();
    String name = sn.nextLine();
    System.out.println("국어 성적을 입력하세요.");
    int gradeKor = sn.nextInt();
    System.out.println("영어 성적을 입력하세요.");
    int gradeEng = sn.nextInt();
    System.out.println("수학 성적을 입력하세요.");
    int gradeMath = sn.nextInt();
    Student std = new Student(id, name);
    std.setGrade(gradeKor, gradeEng, gradeMath);
    return std;
  }

  public static void main(String[] args) {
    MyList myList = new MyList();
    while (true) {
      try {
        int size = myList.getSize();
        float avg = myList.getAvg();
        printMenu(size, avg);
        int selectMenu = MyConsoleInput.getInputMenu();
        // selectMenu = sn.nextInt();
        if (selectMenu == 1) {
          myList.addNode(inputInfo());
        } else if (selectMenu == 2) {
          System.out.println(myList.toString());
        } else if (selectMenu == 3) {
          System.out.println("프로그램 종료.");
          break;
        }
      } catch (MyException e) {
        System.out.println(
          "에러 메세지 : " + e.getMessage()
        );
        System.out.println("ERR_CODE : " + e.errCode);
      } catch (Exception e) {
        System.out.println(
          "Undefined Exception, Get Input again."
        );
      }
    }
  }
}
