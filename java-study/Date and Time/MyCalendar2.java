import java.util.Calendar;

public class MyCalendar2 {

  public static void main(String[] args) {
    Calendar today = Calendar.getInstance();

    System.out.println(today.get(Calendar.YEAR) + "년");
    System.out.println(today.get(Calendar.MONTH) + "월");
    System.out.println(today.get(Calendar.DATE) + "일");
    System.out.println(
      today.get(Calendar.DAY_OF_WEEK) + "요일"
    );
    System.out.println(today.get(Calendar.HOUR) + "시");
    System.out.println(today.get(Calendar.MINUTE) + "분");
    System.out.println(today.get(Calendar.SECOND) + "초");
    System.out.println(
      today.get(Calendar.MILLISECOND) + "밀리초"
    );

    System.out.println(
      today.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "주/월"
    );
    System.out.println(
      today.get(Calendar.DAY_OF_YEAR) + "일/년"
    );
    System.out.println(
      today.get(Calendar.WEEK_OF_YEAR) + "주/년"
    );
  }
}
