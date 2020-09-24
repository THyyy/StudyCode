package basice.multithread;

import lombok.extern.slf4j.Slf4j;

/**
 * 水壶煮茶线程训练
 *
 * @author yuancome
 * @date 2020/9/8
 */
@Slf4j
public class TrainTest {

    public static void main(String[] args) {
        final Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info("洗水壶");
                try {
                    sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("烧开水");
                try {
                    sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                log.info("洗茶壶");
                try {
                    sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("洗茶杯");
                try {
                    sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("拿茶叶");
                try {
                    sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("水烧开了，开始泡茶");
            }
        };
        t2.start();
    }
}
