package C08Thread;

import jdk.swing.interop.LightweightContentWrapper;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        /// 단일 스레드 작업 - 작업이 주체 (1명 vs N명이 이 코드를 실행했냐?) -> 문제 없음
        /*
        for (int i = 0; i < 1000; i++){
            Library.borrow();
        }
        System.out.println(Library.getBookCnt());

         */

        /*
        /// 여기서는 멀티 스레드 작업 (여러명이 동시에 이 코드 실행)
        /// 멀티스레스 생성 방법
        /// 방법 1 (스레드 클래스 상속 방식)
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();

        /// Thread 클래스 메서드 안에 start 메서드 내장되어 있고, start 메서드는 run 메서드 호출하면서 스레드 생성
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        /// 멀티스레드 4개 생성됨 (thread들 간 순서가 보장이 되지 않음)
        System.out.println("hello world");

         */
        /*
        /// 방법 2 (Runnable을 직접 구현한 객체를 Thread 클래스 생성자에 주입하는 방식)
        new Thread(() -> System.out.println("스레드 실행 시작(MyThread)1")).start();
        new Thread(() -> System.out.println("스레드 실행 시작(MyThread)2")).start();
        new Thread(() -> System.out.println("스레드 실행 시작(MyThread)3")).start();
        new Thread(() -> System.out.println("스레드 실행 시작(MyThread)4")).start();
        System.out.println("Hello World");

         */
        /// 멀티 스레드 동시성 이슈테스트
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    Library.borrow();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t1.start();

            /// 한 thread 작업이 모두 완료될 때, 다른 스레드 생성하여 작업 수행 -> 사실상 단일 스레드처럼 동작하므로 성능저하 발생
            t1.join();
            /// 미세한 시점 차이에도 동시성 이슈 발생
        }
        Thread.sleep(20000);
        System.out.println(Library.getBookCnt()); /// 나중에는 그냥 redis 쓰면됨
    }
}

class Library {
    private static int bookCount = 100; /// 멀티 스레드에서 100명 이상 들어옴

    /// rdb에 재고 관리 할 경우, synchronized를 통한다 하더라도, query와 commit 실행시점의 차이로 인해 동시성 이슈 발생 (완벽하지 않음)
    /// synchronized = 메서드 내에서 1개의 스레드만 실행되게 함 (이 부분 --메서드 앞--에서 대기할 예정)
    public synchronized static void borrow() throws InterruptedException { /// <- 여기에 동시에 사용자가 접근 중... (동시성 이슈 발생)
        if (bookCount > 0) { ///  <--- ✅ 싱글 스레드에서는 if 조건을 통과한 후 순차 실행되지만,
        /// 멀티 스레드에서는 if 조건문이 존재한다 해도, 여러 스레드가 '동시'에 조건을 만족해버려,
        /// 조건 판단과 감소 로직 사이에 데이터 충돌이 발생할 수 있음 (재고, 포인트, 좌석 수 등의 요소는 동시성 이슈 주의!)

            Thread.sleep(100); /// 순식간에 -- 되므로, 인위적으로 대기 시간 추가
            bookCount -= 1; /// -1 되는게 수백명한테 적용될 수도...
            System.out.println("대출 완료");
        } else System.out.println("대출 불가");
    }

    public static int getBookCnt() { /// getter
        return bookCount;
    }
}

/// 매번 값이 다르게 출력 되는 이유 :
    /// 병렬 실행	- 여러 스레드가 동시에 실행되며 순서가 보장되지 않음
    /// 조건 통과 중복 - if (bookCount > 0)를 여러 스레드가 동시에 true로 판단
    /// 원자성 없음 - bookCount--는 원자적 연산이 아니라서 여러 스레드가 동시에 변경
    /// sleep 지연 - Thread.sleep(300)으로 진입 타이밍을 인위적으로 겹치게 만들어 충돌 발생
    /// 결과 불확정 - 실행할 때마다 충돌 타이밍이 달라 결과도 계속 달라짐