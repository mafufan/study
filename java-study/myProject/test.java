import java.time.LocalDateTime;

class Student {

  int id;
  String name;
  int gradeKor;
  int gradeEng;
  int gradeMath;
  int sum;
  float avg;
  LocalDateTime inputDateTime;

  Student(int argId, String argName) {
    id = argId;
    name = argName;
  }

  void setGrade(int argKor, int argEng, int argMath) {
    gradeKor = argKor;
    gradeEng = argEng;
    gradeMath = argMath;
    sum = gradeKor + gradeEng + gradeMath;
    avg = (float) (sum / 3);
  }

  int getSum() {
    return sum;
  }

  float getAvg() {
    return avg;
  }

  LocalDateTime inputDateTime() {
    inputDateTime = LocalDateTime.now();
    return inputDateTime;
  }

  public String toString() {
    return String.format(
      "[학번 : %d 이름 : %s 국어 : %d 영어 : %d 수학 : %d 총점 : %d 평균 : %.1f 등록 시간 : %s년 %s월 %s일 %s시 %s분 %s초]",
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

class Node {

  Student value;
  Node nextNode;

  Node(Student argValue, Node argNode) {
    value = argValue;
    nextNode = argNode;
  }

  Node getNextNode() {
    return nextNode;
  }

  Student getValue() {
    return value;
  }

  void setNextNode(Node argNode) {
    nextNode = argNode;
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
    while (temp.getNextNode() != null) {
      temp = temp.getNextNode();
    }
    Node newNode = new Node(argValue, tail);
    temp.setNextNode(newNode);
    return numOfNode++;
  }

  int getSize() {
    return numOfNode;
  }

  float getAvg() {
    Node temp = head.getNextNode();
    if (numOfNode != 0) {
      int sum = 0;
      while (temp.getClass() != null) {
        sum += temp.getValue().getAvg();
        temp = temp.getNextNode();
      }
      avg = (float) (sum / numOfNode);
    }
    return avg;
  }

  public String toString() {
    String str = "";
    Node temp = head;
    while (temp.getNextNode() != null) {
      System.out.println(temp);
      temp = temp.getNextNode();
    }
    return str;
  }
}

public class test {

  public static void main(String[] args) {
    MyList myList = new MyList();
    System.out.println(myList.getSize());
    System.out.println(myList.getAvg());
    Student std = new Student(1701162, "HuiJae");
    std.setGrade(100, 70, 80);
    myList.addNode(std);
  }
}
