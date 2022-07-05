import java.util.Scanner;

class People {

  public int age; //나이
  public String name; //이름
  public boolean club; //클럽 참여 여부
  public int clubMember; //클럽 인원

  public void peoplePrint() { //객체 정보 출력
    System.out.println("나이: " + age);
    System.out.println("이름: " + name);
    System.out.println("클럽 참여 여부: " + club);
    System.out.println("클럽인원:" + clubMember);
  }
}

public class prac {

  public static void main(String[] args) {
    People people = new People(); //객체 생성
    Scanner sc = new Scanner(System.in);
    System.out.println("나이를 입력하세요");
    people.age = sc.nextInt();
    people.name = "peemang";
    people.club = true;
    people.clubMember = 5;

    people.peoplePrint(); //객체 정보 출력
  }
}
