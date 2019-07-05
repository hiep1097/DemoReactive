package democallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    static long t1=0,t2=0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Callable<Integer> callable;
        t1 = System.currentTimeMillis();
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            callables.add(new CallableWorker(i));
        }
        List<Future<Integer>> futures = executorService.invokeAll(callables);

        long sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        executorService.shutdown();
        t2 = System.currentTimeMillis();
        System.out.println("Finished all threads after "+((t2-t1))+"ms");
        System.out.println("Sum all = " + sum);
    }
}
