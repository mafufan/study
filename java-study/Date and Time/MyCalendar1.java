import java.util.Calendar;

public class MyCalendar1 {

  public static void main(String[] args) {
    // 현재 시간 획득
    Calendar today = Calendar.getInstance();

    // 시간 변경 -> 2020년 6월 16일 13시 20분 30초
    today.set(2020, 05, 16, 13, 20, 30);

    // 시간 정보 출력
    System.out.println(
      today.get(Calendar.YEAR) +
      ":" +
      today.get(Calendar.MONTH) +
      ":" +
      today.get(Calendar.DATE) +
      " " +
      today.get(Calendar.HOUR_OF_DAY) +
      ":" +
      today.get(Calendar.MINUTE) +
      ":" +
      today.get(Calendar.SECOND)
    );
  }
}
