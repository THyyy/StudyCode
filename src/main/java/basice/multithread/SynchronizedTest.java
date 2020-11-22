package basice.multithread;

import lombok.extern.slf4j.Slf4j;

/**
 * synchronized 测试
 *
 * @author yuancome
 * @date 2020/9/18
 */
@Slf4j
public class SynchronizedTest {
    static int count = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 5000; i++) {
                synchronized (SynchronizedTest.class) {
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 5000; i++) {
                synchronized (SynchronizedTest.class) {
                    count--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{}", count);
    }
}
