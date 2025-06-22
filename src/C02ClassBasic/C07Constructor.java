package C02ClassBasic;

import java.io.IOException;
import java.util.*;

public class C07Constructor {
    public static void main(String[] args) throws IOException {
        //toString() 메서드는 특별한 메서드로 객체명을 출력할 때 자동으로 실행
        //ex)
        /*
        List<Integer> myList = new ArrayList<>();
        myList.add(10);

         */
        MyCalendar d1 = new MyCalendar();
        d1.dateInfo("2025", "06", "18");
        System.out.println(d1.printDate());
    }

    public static class MyCalendar {
        private String year;
        private String month;
        private String day;

        //생성자를 통해 객체변수값들을 객체가 만들어지는 시점에 초기화 (세팅)
        public void dateInfo(String year, String month, String day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        //메서드 (생성자) 오버로딩 예시
        public void dateInfo(String year, String month) {
            this.year = year;
            this.month = month;
        }

        // 별도 생성자를 추가할 경우, 초기 (기본) 생성자는 무시가되므로, 필요 시 별도로 추가
        public String printDate() {
            return this.year + "년 " + this.month + "월 " + this.day + "일";
        }

        //객체 = instance
        //클래스는 객체는 아님
        //객체를 생성시, 고유의 힙 메모리가 할당됨
        //생성자는 보통 public, 그리고 return 안함
    }
}
