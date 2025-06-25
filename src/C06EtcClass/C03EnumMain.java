package C06EtcClass;

public class C03EnumMain {

    public static void main(String[] args) {
        /// classGrade를 일반 문자열로 세팅할 경우 -> 정해진 룰의 문자열이 아닌, 개별적인 문자열이 삽입될 수 있다.
        /*
        Student s1 = new Student("Hong", Grade.g1);
        Student s2 = new Student("Kim", Grade.g2);
        Student s3 = new Student("Lee", Grade.g3);
         */
        /// static final을 통해 변수값 관리하는 방법 -> 타입이 String이므로, 얼마든지 자유롭게 세팅이 가능한 문제점 존재

        Student s1 = new Student("Hong", enumGrade.FIRST_GRADE);
        Student s2 = new Student("Kim", enumGrade.SECOND_GRADE); ///String으로 넣으면 타입 불일치 및 에러남
        Student s3 = new Student("Lee", enumGrade.THIRD_GRADE);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        /// Enum 클래스 내부에는 값이 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s1.getClassGrade().ordinal());
    }
}

class Student {
    private String name;
    private enumGrade classGrade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enumGrade getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(enumGrade classGrade) {
        this.classGrade = classGrade;
    }

    public Student(String name, enumGrade classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classGrade=" + classGrade +
                '}';
    }
}
/*
class Grade {
    static final String g1 = "FIRST_GRADE";
    static final String g2 = "SECOND_GRADE";
    static final String g3 = "THIRD_GRADE";
}

 */

enum enumGrade {
    FIRST_GRADE,
    SECOND_GRADE,
    THIRD_GRADE
    /// 각 enum에 숫자값이 할당되어 있음
}