import java.time.LocalDateTime;
import java.util.Scanner;

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
    // 학생 ID, 이름 입력
    // 현재 날짜 시간 inputDateTime 멤버변수에 저장
    id = argId;
    name = argName;
    getInputDateTime();
  }

  void setGrade(int argKor, int argEng, int argMath) {
    // 국어, 영어, 수학 성적 저장
    // 입력 후 합계, 평균 계산 후 sum, avg 멤버변수에 저장
    gradeKor = argKor;
    gradeEng = argEng;
    gradeMath = argMath;
  }

  int getSum() {
    // 성적 합계 : sum 멤버변수 값 반환
    sum = gradeKor + gradeEng + gradeMath;
    return sum;
  }

  float getAvg() {
    // 성적 평균 : avg 멤버변수 값 반환
    avg = (float) (sum / 3);
    return avg;
  }

  LocalDateTime getInputDateTime() {
    // 입력 날짜 시간 : inputDateTime 멤버변수 값 반환
    return inputDateTime = LocalDateTime.now();
  }

  public String toString() {
    // 데이터 값 출력, 아래 포맷 준수
    return String.format(
      "id : %d name : %s kor : %d eng : %d math : %d sum : %d avg : %.1f date : %d년 %d월 %d일 %d시 %d분 %d초",
      id,
      name,
      gradeKor,
      gradeEng,
      gradeMath,
      getSum(),
      getAvg(),
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
    // head, tail 노드 생성
    tail = new Node(null, null);
    head = new Node(tail, null);
  }

  int addNode(Student argValue) {
    // 입력 데이터를 리스트 제일 끝에 추가
    Node temp = head;
    while (temp.getNextNode() != tail) {
      temp = temp.getNextNode();
    }

    Node newNode = new Node(tail, argValue);

    temp.setNextNode(newNode);

    return numOfNode++;
  }

  int getSize() {
    // 리스트 내 데이터 갯수
    return numOfNode;
  }

  float getAvg() {
    // 평균 값 : 리스트 내 모든 Student 객체의 각 평균값에 대한 전체 평균 값
    int sum = 0;

    Node temp = head;
    while (temp.getNextNode() != tail) {
      temp = temp.getNextNode();
      sum += temp.value.getAvg();
    }

    if (numOfNode != 0) {
      avg = (float) (sum / numOfNode);
    }

    return avg;
  }

  public String toString() {
    Node temp = head.getNextNode();
    while (temp != tail) {
      System.out.println(temp.getValue().toString());
      temp = temp.getNextNode();
    }
    return null;
  }
}

class Node {

  Node nextNode;
  Student value;

  Node(Node argNextNode, Student argValue) {
    nextNode = argNextNode;
    value = argValue;
  }

  Node getNextNode() {
    return nextNode;
  }

  void setNextNode(Node argNode) {
    nextNode = argNode;
  }

  Student getValue() {
    return value;
  }

  void setValue(Student argValue) {
    value = argValue;
  }
}

public class Quiz14 {

  public static void main(String[] args) {
    Scanner sn = new Scanner(System.in);
    MyList myList = new MyList();
    int inputMenu = 0;
    while (inputMenu != 3) {
      System.out.println("================");
      System.out.println("1. 학생 성적 입력");
      System.out.println("2. 학생 목록 출력(입력 순)");
      System.out.println("3. 프로그램 종료\n");
      System.out.println(
        "현 입력데이터 갯수 : " + myList.getSize()
      );
      System.out.println(
        "전체 학생 평균 값 : " + myList.getAvg()
      );
      System.out.println("================");
      inputMenu = sn.nextInt();
      if (inputMenu == 1) {
        int inputId;
        String inputName;
        int inputGradeKor;
        int inputGradeEng;
        int inputGradeMath;
        System.out.println("학번을 입력하세요.");
        inputId = sn.nextInt();
        System.out.println("이름을 입력하세요.");
        sn.nextLine();
        inputName = sn.nextLine();
        System.out.println("국어 성적을 입력하세요.");
        inputGradeKor = sn.nextInt();
        System.out.println("영어 성적을 입력하세요.");
        inputGradeEng = sn.nextInt();
        System.out.println("수학 성적을 입력하세요.");
        inputGradeMath = sn.nextInt();
        Student student = new Student(inputId, inputName);
        student.setGrade(
          inputGradeKor,
          inputGradeEng,
          inputGradeMath
        );
        System.out.println(student.toString());
        myList.addNode(student);
      } else if (inputMenu == 2) {
        System.out.println(myList.toString());
      }
    }
  }
}
