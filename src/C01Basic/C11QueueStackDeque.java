package C01Basic;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class C11QueueStackDeque {
    public static void main(String[] args) throws IOException {
        //queue 인터페이스를 LinkedList가 구현한 아래와 같은 방식을 가장 많이 사용 (삽입과 삭제의 성능이 좋으나, 조회 성능이 떨어짐)
        /*
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);
        myQue.add(20);
        myQue.add(30);

        //poll : queue에서 데이터를 삭제하면서 동시에 리턴 (성능 올라감)
        int tmp = myQue.poll(); //10
        System.out.println(tmp);
        System.out.println(myQue); //20, 30

        //peek은 queue에서 데이터를 삭제하지 않고, 가장 앞의 데이터를 반환
        int tmp2 = myQue.peek(); //20
        System.out.println(tmp2);
        System.out.println(myQue);

        //LinkedList와 ArrayList의 성능 차이
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < 100000; i++){
            link.add(0, i);
        }

        ArrayList<Integer> arrlist = new ArrayList<>();
        for (int i = 0; i < 100000; i++){
            arrlist.add(0, i);

         */

        Queue<String> myQue = new LinkedList<>();
        myQue.add("doc 1");
        myQue.add("doc 2");
        myQue.add("doc 3");
        myQue.add("doc 4");

        /*
        for (int i = 0; i < myQue.size(); i++){
            System.out.println(myQue.poll());
        }
        // *** 이렇게 쓰면 안됨
         */
        //Queue는 일반적으로 while문을 통해서 값을 소모한다.
/*
        while(!myQue.isEmpty()){ //empty 되면 종료되는 조건문
            System.out.println(myQue.poll());
            //2개씩 poll을 할 경우에는 queue에서 empty가 되지 않도록 유의
        }

 */
/*
        // 길이제한큐
        Queue<String> blockingQue = new ArrayBlockingQueue<>(3);
        blockingQue.add("doc 1");
        blockingQue.add("doc 2");
        blockingQue.add("doc 3");
        //blockingQue.add("doc 4"); //에러남

        System.out.println(blockingQue);

        // 제한된 길이까지만 insert
        blockingQue.offer("doc 1");
        blockingQue.offer("doc 2");
        blockingQue.offer("doc 3");
        blockingQue.offer("doc 4"); //offer 쓰면 에러처리 안해줌

        System.out.println(blockingQue); //실제로는 while 에러가 아닐때까지로

 */
        // *** 전체 데이터가 지속적으로 변경되면서 지속적으로 최소값을 추출해야하는 경우 PriorityQue 사용
        // 우선순위 큐 (데이터를 poll할때 정렬된 데이터 결과값 보장
        /*
        Queue<Integer> pq = new PriorityQueue<>(); // 정렬은 n Log(n)이다. pq는 시장(실무)에서 많이 쓰임
        pq.add(30);
        pq.add(20);
        pq.add(10);
        pq.add(40);
        pq.add(50);
        System.out.println(pq); //add 할때까지는 전체 정렬이 되어있지 않음

        while(!pq.isEmpty()){
            System.out.println(pq.poll()); // 하나씩 뽑을때는 Log(n) - 즉, 한개씩 poll할 때마다 '최소값'을 뽑아낸다.
        }

         */
/*
        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder()); // 최대수로 정렬
        pq2.add(30);
        pq2.add(20);
        pq2.add(10);
        pq2.add(40);
        pq2.add(50);
        System.out.println(pq2); //add 할때까지는 전체 정렬이 되어있지 않음

        while(!pq2.isEmpty()){
            System.out.println(pq2.poll()); // 하나씩 뽑을때는 Log(n) - 즉, 한개씩 poll할 때마다 '최소값'을 뽑아낸다.
        }

 */

        // stack : 후입선출
        /*
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

         */

        // Deque : addFirst, addLast, pollLast, pollFirst, peekFirst, peekLast
        Deque<Integer> d1 = new ArrayDeque<>();
        d1.addLast(10);
        d1.addLast(20);
        d1.addFirst(5);

        System.out.println(d1.pollLast());
        System.out.println(d1.pollFirst());
        System.out.println(d1.peekLast());
    }
}
