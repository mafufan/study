import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalendar {

  public static void main(String[] args) {
    // 현 시스템(운영체제) 시간과 지역 설정에 따라 객체 생성
    // 태국의 경우 BuddhistCalendar 그 외 지역은 GregorianCalendar

    // Calendar 클래스는 추상클래스, static getInstance() 메서드 이용객체 생성

    Calendar today = Calendar.getInstance();

    if (today instanceof GregorianCalendar) {
      System.out.println("true");
    }
  }
}
