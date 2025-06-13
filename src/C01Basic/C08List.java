package C01Basic;

import java.io.IOException;
import java.util.*;

public class C08List {
    public static void main(String[] args) throws IOException {
        //List 선언 방법
        /*
        ArrayList<String> myList1 = new ArrayList<String>();
        ArrayList<String> myList2 = new ArrayList<>();

        //가장 일반적인 List 선언 방법
        List<String> myList3 = new ArrayList<>();

        //초기값 세팅 방법 #1
        myList3.add("java");
        myList3.add("python");
        myList3.add("c++");

        System.out.println(myList3); //toSting 내장됨

        //초기값 세팅 방법 #2
        String[] arr = {"java", "python", "c++"};
        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));

        int[] intArr = {10,20,30};
        List<Integer> myIntList = new ArrayList<>();
        for(int i : intArr){
            myIntList.add(i);
        }

         */

        // add 메서드 : 리스트에 값을 하나씩 추가 하는 메서드
        /*
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(0, 30); //좋은 방법이 아님 (성능 비효율적) -> 중간 데이터 삽입 및 삭제는 성능 비효율적

        System.out.println(myList);

        // get(index) : 특정 index의 요소 반환
        System.out.println(myList.get(0));

        // size() : list의 개수(길이 수) 반환
        System.out.println(myList.size());

        for (int i = 0; i < myList.size(); i++){
            System.out.println(i);
        }

         */
/*
        // remove : 요소 삭제
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        // 1)index를 통한 삭제 2) value를 통한 삭제 (중복때문에 일반적이지 않음)

        myList.remove(0);

 */
/*
        int size = myList.size();
        for(int i = 0; i < size; i++){
            myList.remove(i);
        }

        myList.remove(Integer.valueOf(30));
        System.out.println(myList);

        myList.clear();
        System.out.println(myList.isEmpty());

 */
/*
        // indexOf : 특정 값을 찾아 index return (중복되면 가장 먼저 나오는 값을 return)
        List<Integer> myList2 = new ArrayList<>();
        myList2.add(10);
        myList2.add(20);
        myList2.add(30);
        myList2.add(30);

        System.out.println(myList2.indexOf(30));

        // contains : 값이 있는지 없는지 리턴
        System.out.println(myList2.contains(20));

 */

        // n의 배수 고르기
        /*
        int n = 3;
        int [] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};

        List<Integer> myList = new ArrayList<>();

        for (int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0){
                myList.add(numlist[i]);
            }
        }
        int[] answer = new int [myList.size()];

        for (int i = 0; i < answer.length; i++){
            answer[i] = myList.get(i);
        }
        System.out.println(Arrays.toString(answer));

         */

        //정렬 (nlogn)
        //1. collections
        /*
        List<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(3);
        myList.add(2);
        myList.add(1);
        myList.add(4);
        myList.add(6);

        Collections.sort(myList);
        Collections.sort(myList, Comparator.reverseOrder());

        System.out.println(myList);

        //2. 객체명.sort 객체(ArrayList클래스).sort
        myList.sort(Comparator.naturalOrder());
        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);

         */

        // 2중 리스트
        // [[1,2],[3,4],[5,6]] - 길이 지정 필요 없음
        /*
        List<List<Integer>> myList = new ArrayList();
        List<Integer> myList1 = new ArrayList<>();
        myList.add(myList1);
        // =
        myList.add(new ArrayList<>());

        myList.get(0).add(1);
        myList.get(0).add(2); // [[1,2],[,]]
        myList.get(1).add(3);
        myList.get(1).add(4); // [[1,2],[3,4]]

         */

        //for문을 이용해서 [[1,2,3],[4,5,6],[7,8,9],[10,11,12]] 생성
        /*
        List<List<Integer>> myList = new ArrayList();
        int num = 1;

        for (int i = 0; i < 4; i++){
            myList.add(new ArrayList<>());
            for (int j = 0; j < 3; j++){
                myList.get(i).add(num);
                num++;
            }
        }
        System.out.println(myList);

         */

        //리스트 안에 배열 만들기
        //[{1,2}{1,2,3}{1,2,3,4}]

        List<int[]> myList = new ArrayList();

        myList.add(new int [2]);
        myList.get(0)[0] = 1;
        myList.get(0)[1] = 2;
        myList.add(new int [3]);
        myList.get(1)[0] = 1;
        myList.get(1)[1] = 2;
        myList.get(1)[2] = 3;
        myList.add(new int []{1,2,3,4});
/*
        for (int i = 0; i < myList.size(); i++){
            System.out.println(Arrays.toString(myList.get(i)));
        }

 */
        for (int [] m : myList){
            System.out.println(Arrays.toString(m));
        }
    }
}
