import java.util.Calendar;
import java.util.Scanner;

public class MyCalendar2_1 {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println(
      "기준일을 입력하세요(예: 2020.05.16)"
    );

    // 키보드로부터 입력 받은 기준일을"." 구분으로 분리
    String[] rcvdDate = scn.nextLine().split("\\.");

    // 입력 받은 날짜 값을 Calendar 객체에 저장
    Calendar baseDate = Calendar.getInstance();
    baseDate.set(
      Integer.valueOf(rcvdDate[0]),
      Integer.valueOf(rcvdDate[1]) - 1,
      Integer.valueOf(rcvdDate[2])
    );

    // 현 시스템(OS)의 날짜 정보 획득
    Calendar curDate = Calendar.getInstance();

    // 오늘 - 기준일 연산
    long diffTimeStamp =
      curDate.getTimeInMillis() -
      baseDate.getTimeInMillis();

    // 날짜로 환산 : 60초 * 1000ms * 60분 * 24시간
    long diffDate = diffTimeStamp / (3600000 * 24);

    System.out.println(
      "오늘은 기준일로 부터 " +
      diffDate +
      "째 되는 날입니다."
    );
  }
}
