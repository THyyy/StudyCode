package basice.multithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask测试
 *
 * @author yuancome
 * @date 2020/9/3
 */
@Slf4j
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() throws Exception {
                log.info("test future task");
                Thread.sleep(2000L);
                return 1;
            }
        });
        Thread t1 = new Thread(futureTask, "taskThread");
        t1.start();

        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        log.info("----end-----");

    }
}
