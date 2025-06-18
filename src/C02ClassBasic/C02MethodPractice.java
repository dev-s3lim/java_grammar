package C02ClassBasic;

import java.io.IOException;
import java.util.Scanner;

public class C02MethodPractice {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println((C02MethodPractice.isPrime(input)));

    }
    /*
    public static boolean isPrime (int n) {
        boolean isPrime = true;

        for (int i = 2; i*i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("입력하신 숫자는 소수입니다.");
        } else {
            System.out.println("입력하신 숫자는 소수가 아닙니다.");
        }

        return isPrime;
    }

     */

    // 또는 이렇게도 사용 가능
    public static boolean isPrime (int n) {
        boolean isPrime = true;

        for (int i = 2; i*i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        if (isPrime) {
            System.out.println("입력하신 숫자는 소수입니다.");
        } else {
            System.out.println("입력하신 숫자는 소수가 아닙니다.");
        }

        return true;
    }

    // 반환할 것이 없는 경우 void
}
