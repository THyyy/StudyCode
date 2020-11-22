package basice.multithread;

import lombok.extern.slf4j.Slf4j;

/**
 * java 线程状态测试
 *
 * @author yuancome
 * @date 2020/9/8
 */
@Slf4j
public class ThreadStatusTest {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {

            @Override
            public void run() {
                log.info("running....");
            }
        };

        final Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                while (true) {

                }
            }
        };
        t2.start();

        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                log.info("running....");
            }
        };
        t3.start();

        Thread t4 = new Thread("t4") {
            @Override
            public void run() {
                synchronized (ThreadStatusTest.class) {
                    try {
                        Thread.sleep(1000000000000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t4.start();

        Thread t5 = new Thread("t5") {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t5.start();

        Thread t6 = new Thread("t6") {
            @Override
            public void run() {
                synchronized (ThreadStatusTest.class) {
                    try {
                        Thread.sleep(1000000000000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t6.start();

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("t1 status：{}", t1.getState());
        log.info("t2 status：{}", t2.getState());
        log.info("t3 status：{}", t3.getState());
        log.info("t4 status：{}", t4.getState());
        log.info("t5 status：{}", t5.getState());
        log.info("t6 status：{}", t6.getState());
    }
}
