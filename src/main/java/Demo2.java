import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
//        final Mono<String> mono = Mono.just("hello ");
//
//        new Thread(() -> mono
//                .map(msg -> msg + "thread ")
//                .subscribe(v ->
//                                System.out.println(v + Thread.currentThread().getName()),
//                        err-> System.err.println("error")
//                )
//        ).start();

//        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
//
//        final Flux<String> flux = Flux
//                .range(1, 2)
//                .map(i -> 10 + i)
//                .publishOn(s)
//                .map(i -> "value " + i);
//
//        new Thread(() -> flux.subscribe(System.out::println)).start();

//        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
//
//        final Flux<String> flux = Flux
//                .range(1, 2)
//                .map(i -> 10 + i)
//                .subscribeOn(s)
//                .map(i -> "value " + i);
//
//        new Thread(() -> flux.subscribe(System.out::println)).start();

//        Flux<Integer> flux2 = Flux.range(0, 2).delayElements(Duration.ofMillis(1));
//        createSubscribers(flux2);

//        Flux<String> flux1 = Flux.just("foo", "bar");
//        Flux<String> flux2 = flux1.map(s -> s.toUpperCase());
//        flux2.subscribe(s -> System.out.println(s));

//        Flux.just("a", "b", "c") //this is where subscription triggers data production
//                //this is influenced by subscribeOn
//                .doOnNext(v -> System.out.println("before publishOn: " + Thread.currentThread().getName()))
//                .publishOn(Schedulers.elastic())
//                //the rest is influenced by publishOn
//                .doOnNext(v -> System.out.println("after publishOn: " + Thread.currentThread().getName()))
//                .subscribeOn(Schedulers.parallel())
//                .subscribe(v -> System.out.println("received " + v + " on " + Thread.currentThread().getName()));
//        Thread.sleep(1000);


        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        ExecutorService executorService2 = Executors.newFixedThreadPool(3);
        System.out.println( Thread.currentThread().getName());
        Flux.range(1,10)
                .flatMap(integer -> {  return Mono.just(integer).subscribeOn(Schedulers.fromExecutorService(executorService1));}
                )
                .subscribe(s ->  {
                    System.out.println(s+ " "+ Thread.currentThread().getName());
                });

//        Flux.range(50,5)
//                .flatMap(integer -> {  return Mono.just(integer).subscribeOn(Schedulers.fromExecutorService(executorService1));}
//                )
//                .subscribeOn(Schedulers.fromExecutorService(executorService2))
//                .subscribe(s ->  {
//                    System.out.println(s+ " "+ Thread.currentThread().getName());
//                });

    }
}
