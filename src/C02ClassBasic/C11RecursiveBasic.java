package C02ClassBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C11RecursiveBasic {
    public static void main(String[] args) throws IOException {
        //recur1(0, 3);
        recur2(new ArrayList<>(), 0, 3);
    }

    /*
    public static void recur0(int cnt, int i){
        if(cnt == i){
            return;
        }
        System.out.println("재귀 호출 전 Count" + " " + (cnt)); /// 0(첫번째) -> 1(두번째) -> 2(세번째)
        recur0(cnt + 1, 3);

        System.out.println("재귀 호출 후 Count" + " " + (cnt)); /// 0(여섯째) -> 1(다섯째) -> 2(네번째)
                                                             /// 스택 구조라서 거꾸로 출력
                                                             /// 0 > 1 > 2 > 3 > 2(return) > 1 > 0
    }

     */

    /*
    /// 아래 함수 출력 순서 : 전 c: 0 -> c: 1 -> c: 2 -> 후 c:3 (재귀하기 전의 시점까지) c: 2 -> c: 1
    public static void recur1(int cnt, int i){
        if(cnt == i){
            return;
        }
        System.out.println("재귀 호출 전 Count" + " " + (cnt)); ///
        cnt = cnt + 1;
        recur1(cnt + 1, 3);

        System.out.println("재귀 호출 후 Count" + " " + (cnt)); ///
    }

     */

    // 객체를 매개변수로 활용한 재귀함수에서는 객체는 힙메로리를 통해 원본 객체가 지속적으로 변경될 수 있으므로, 재귀함수간에 값이 일치되는 현상이 일치하는 현상 발생

    public static void recur2(List<Integer> myList, int num, int i){
        if(myList.size() == i){
            return;
        }
        myList.add(num);
        recur2(myList, num+1, i); /// 원시자료형이 아니므로 힙메모리를 전달하기 때문에 전체 함수가 동시에 변경된다.
        System.out.println(myList);
    }
}
