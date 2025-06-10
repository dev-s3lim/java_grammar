package C01Basic;

public class C03Operator {
    public static void main(String[] args) {
        // 사(오)칙연산 (산술연산)
        /*
        int n1 = 8;
        int n2 = 3;

        System.out.println("n1 * n2 = " + (n1*n2));
        System.out.println("n1 * n2 = " + (n1/n2));
        System.out.println("n1 * n2 = " + (n1%n2));

         */

        // 대입연산자
        /*
        int n1 = 7;
        int n2 = 7;
        int n3 = 7;

        n1 = n1 - 3;
        n2 -= 3;
        n3 = -3;

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        int n4 = 10;
        int n5 = 10;
        n4 /= 3;
        n5 %= 3;

        System.out.println(n4);
        System.out.println(n5);

         */

        // 증감연산자
        /*
        int a = 10;
        a = a + 1;
        a += 1;
        a++; //후위 증감 연산자
        ++a; //전위 증감 연산자
        System.out.println(a);

         */

        //a++ : 현재 라인의 명령문이 실행되고 나서 증가
        //++a : 현재 라인의 명령문이 실행괴기 전에 증가
        /*
        int a = 10;
        a++;
        System.out.println(a);
        int b = 5;
        int c = b++;
        int d = ++b;
        System.out.println(d);

         */

        // 논리 연산자 :
        // ==, !=, >, >= 등 (return 값은 boolean)
        /*
        char a = 'a';
        char b = 'b';

        System.out.println(ch1 == ch2);
        System.out.println(ch1 != ch2);

         */

        // 비교 연산자 :
        // &&, ||, !

        /*
        int num1 = 10;
        int num2 = 20;
        boolean b1 = num1 > 5 && num1 < 20;
        System.out.println(b1);

        // num2 가 10과 30사이에 있는지의 여부를 b2 값에 세팅
        boolean b2 = !(num2 < 10 || num2 > 30);
        System.out.println(b2);

        boolean b3 = !(num2 < 10 || num2 > 30);
        System.out.println(b3);

         */

        // 비트 연산자 : 컴퓨터의 2진 체계에서의 연산 방식 &, |, ^, <<, >>



    }
}
