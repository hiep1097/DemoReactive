package democallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class NonCallableExample {
    static long t1=0,t2=0;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long sum = 0;
        t1 = System.currentTimeMillis();
        for (int i=1;i<=100000000;i++){
            int res = i*i;
            list.add(res);
        }
        for (Integer f : list) {
            sum+= f;
        }
        t2 = System.currentTimeMillis();
        System.out.println("Finished all threads after "+((t2-t1))+"ms");
        System.out.println("Sum all = " + sum);
    }
}
