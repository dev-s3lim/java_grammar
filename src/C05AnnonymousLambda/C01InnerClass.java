package C05AnnonymousLambda;

public class C01InnerClass {
    public static void main(String[] args) {
        MemberInnerClass m = new MemberInnerClass();
        System.out.println(m.getA());

        MemberInnerClass.StaticInnerClass ms1 = new MemberInnerClass.StaticInnerClass(); ///일반클래스명.
        ms1.display();
    }
}

/// (일반) 내부 클래스
class MemberInnerClass {
    private int a;

    public MemberInnerClass() {
        this.a = 10;
    }

    public int getA() {
        return this.a;
    }

    /// static 내부 클래스 : MemberInnerClass의 static 변수처럼 활용 (완전한 하나의 클래스로 볼 수 있음)
    static class StaticInnerClass {
        int b = 20;
        void display(){
            System.out.println(this.b);
        }
    }
}