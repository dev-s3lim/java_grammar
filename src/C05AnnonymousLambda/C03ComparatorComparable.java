package C05AnnonymousLambda;

import java.util.*;

public class C03ComparatorComparable {
    /// java에서는 비교를 위한 인터페이스가 대표적으로 2개 제공됨
    /// 1. Comparable : compareTo
    /// 2. Comparator : compare (추천)

    public static void main(String[] args) {

        /// String 클래스 및 java의 많은 클래스에서 Comparable을 상속하여 compareTo 메서드 구현
        String a = "Hello";
        String b = "World";
        System.out.println(a.compareTo(b)); // 마이너스

        List<String> myList = new ArrayList<>();
        myList.add("java");
        myList.add("python");
        myList.add("javascript");

        /// String 안에 compareTo 메서드를 사용하여 정렬이 이뤄짐
        // Collections.sort(myList);

        /// 직접 만든 student를 리스트에 담아 정렬
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("Kim", 24);
        Student s2 = new Student("Lee", 22);
        Student s3 = new Student("Choi", 25);
        Student s4 = new Student("Hong", 23);
        Student s5 = new Student("Park", 21);

        list.add(new Student("Kim", 24));
        list.add(new Student("Lee", 22));
        list.add(new Student("Choi", 25));
        list.add(new Student("Hong", 23));
        list.add(new Student("Park", 21));

        /// 정렬 방법 1 - Student 객체에서 comparable을 직접 구현
        /// 단점 : Student 객체를 직접 구현해야하므로, 유연성이 떨어짐
        /// Collections.sort에서 Comparable을 구현한 객체를 요구
        //Collections.sort(list);
        //System.out.println(list);

        /// 정렬 방법 2 - Comparator를 구현한 익명 객체 사용

        list.sort(new Comparator<Student>() {
            @Override
            ///                 this.         o.
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
/*
        System.out.println(list);
        /// Comparator는 활용도 높음 - 많은 정렬 메서드에서 요구하기 때문

 */


        String[] stArr = {"hello", "java", "python", "C++"};
        Arrays.sort(stArr);
        Arrays.sort(stArr, Comparator.reverseOrder());

        /// 글자 길이를 기준으로 내림차순 정렬
        Arrays.sort(stArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        System.out.println(Arrays.toString(stArr));


        /// 2차원 배열 정렬
        /// [4,5],[1,2],[5,0],[3,1]
    }

static class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
    }
}

/// 정렬은 결국 2개의 값을 비교하는 것으로 A와 B대상 두개만 있으면 충분
/// 2개의 수, 또는 문자의 비교 경우, 음수, 0, 양수 세 값중에 하나만 return. 이를 통해 정렬 수행
/// this.가 앞에 있을때는 오름차 순, this.가 뒤에 있으면 내림차순으로 내부적으로 정렬 로직 작동