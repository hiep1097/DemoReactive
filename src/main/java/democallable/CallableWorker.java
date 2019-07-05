package democallable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableWorker implements Callable<Integer> {
    private int num;
    private Random random;
    public CallableWorker(int num){
        this.num = num;
        random = new Random();
    }

    @Override
    public Integer call() throws Exception {
        //Thread.sleep(random.nextInt(10)*1000);
        int res = num*num;
        //System.out.println("Complete "+num);
        return res;
    }
}
