package C02ClassBasic;

public class C04Person {
    //    private 접근제어자는 해당 클래스 내에서만 접근가능
//    클래스에서 객체변수는 일반적으로 변수의 안정성을 위해 private으로 설정
//
    private String name;

    private String email;

    private int age;

    //    메서드는 public하게 별도로 만들어서 의도를 명확히하여 변수의 안정성 향상
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.println("이름은 : " + getName() + " 이메일은 : " + getEmail() + " 나이는 : " + getAge());
    }

    /// 내가 만든 메서드

    public String printPerson2() {
        return "이름은 : " + this.name + " 이메일은 : " + this.email + " 나이는 : " + this.age;
    }/// 강사님이 만든 메서드

//    객체 메서드들끼리의 호출은 객체가 만들어져 있다라는 것을 가정하고 있으므로 문제없이 호출 가능

    public String printPerson3() { /// 객체 메서드에서 또다른 객체 메서드를 호출할 때 this를 사용하여 호출할 수 있다.
        String temp = this.printPerson2();
        return temp;
    }

//    클래스 메서드는 기본적으로 객체 생성을 가정하지 않으므로, 클래스메서드 내에서 객체메서드를 호출하는 것은 논리적 모순
//    public static String printPerson4(){ ///불가능
//        String temp = this.printPerson2();
//        return temp;
//    }


}