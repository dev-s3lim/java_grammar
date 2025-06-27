package C08Thread;

public class MyThread extends Thread{

    /// Thread 클래스에 저장된 run 메서드는 비었음
    /// run 메서드는 Thread가 시작될 때 자동으로 시작되는 메서드다.
    /// Thread 실행 시, 특정 작업을 수행하고 싶다면, run 메서드를 overriding 해서 코드 작성
    @Override
    public void run() {
        System.out.println("스레드 실행시작 (MyThread)");
    }
}
