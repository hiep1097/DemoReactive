package democallable;

import org.w3c.dom.events.UIEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class FluxCallableExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        long t1 = System.currentTimeMillis();
        AtomicLong sum = new AtomicLong(0);
        Flux.range(1,99999999)
                .map(i->i*i)
                .subscribeOn(Schedulers.elastic())
                .subscribe(i -> {
                            sum.addAndGet(i);
                        }, err -> System.err.println(err),
                        () -> {
                            long t2 = System.currentTimeMillis();
                            System.out.println("done with sum = " + sum+" after " + (t2 - t1) + " ms");
                        });
        System.out.println("ok");
        while (true){
        }

    }
}
