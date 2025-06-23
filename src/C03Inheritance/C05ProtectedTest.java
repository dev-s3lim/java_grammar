package C03Inheritance;

public class C05ProtectedTest {
    public static void main(String[] args) {
        C04ProtectedClass c1 = new C04ProtectedClass();
        c1.st1 = "hello python";
        /// C04ProtectedClass.st2 = "hello python 2"; 접근 불가
        c1.st3 = "hello python 3";
    }
}
