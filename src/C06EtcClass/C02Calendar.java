package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.function.LongConsumer;

public class C02Calendar {
    public static void main(String[] args) {
        //java.util 패키지 안에 캘린더 있음
        /*
        Calendar myCalendar = Calendar.getInstance();
        System.out.println(myCalendar.getTime());
        System.out.println(myCalendar.get(Calendar.YEAR));
        System.out.println(myCalendar.get(Calendar.MONTH));
        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK)); /// 요일
        System.out.println(myCalendar.get(Calendar.HOUR)); /// 24시 체계
        System.out.println(myCalendar.get(Calendar.HOUR_OF_DAY)); /// 24시 체계
        System.out.println(myCalendar.get(Calendar.MINUTE));
        System.out.println(myCalendar.get(Calendar.SECOND));

         */

        //java.time 패키지 안에 localDateTime, LocalDate, LocalTime 클래스
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getHour());

        //get 메서드와 크로노필드 매개변수로 다양한 형식의 날짜/시간정보 조회
        System.out.println(localDateTime.get(ChronoField.YEAR));
        System.out.println(localDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDateTime.get(ChronoField.AMPM_OF_DAY)); //0 오전 : 1 오후
        System.out.println(localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY)); //24시 체계

        /// .of 임의로 특정시간 정보객체를 만들어 내고 싶을 때
        LocalDate birthDay = LocalDate.of(2000, 11, 12);
        System.out.println(birthDay);

        LocalDateTime bdt = LocalDateTime.of(2000, 11, 12, 15, 30, 10, 5);
        System.out.println(bdt);
    }
}
