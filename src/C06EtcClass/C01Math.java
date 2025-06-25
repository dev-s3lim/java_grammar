package C06EtcClass;

public class C01Math {
    public static void main(String[] args) {
        /// 임의 수 반환 Math.random() 0.0~1.0 사이의 더블형 반환
        System.out.println(Math.random());

        /// 로또번호 7개 뽑기
        for (int i = 0; i < 7; i++){
            System.out.println((int)(Math.random() * 100));
        }

        /// 절대값
        System.out.println(Math.abs(-5));

        /// 올림
        System.out.println(Math.ceil(5.7));
        /// 내림
        System.out.println(Math.floor(5.7));
        /// 반올림
        System.out.println(Math.round(5.7));

        /// 큰수
        System.out.println(Math.max(10, 20));

        /// 작은수
        System.out.println(Math.min(10, 20));

        /// 제곱
        System.out.println(Math.pow(2, 3));

        /// 제곱 근
        System.out.println(Math.sqrt(25));
    }
}
