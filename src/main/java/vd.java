import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class vd {
    public static Mono<Integer> countMono(int x) {
        return Mono.just(x + 1);
    }

    public static Flux<Integer> countFlux(int x) {
        return Flux.just(x + 1, x + 2, x + 3 ,x +4 ,x +5);
    }

    public static void main(String[] args) {

        //ExecutorService service1 = Executors.newFixedThreadPool(10);
        ExecutorService service2 = Executors.newFixedThreadPool(2);
        //ExecutorService service3 = Executors.newFixedThreadPool(10);
        int x = 100;

        countFlux(8)
// .flatMap(integer -> Mono.just(integer+"####"+x).subscribeOn(Schedulers.fromExecutorService(service1)))
                .flatMap(str -> Mono.just(str + "####" + x).subscribeOn(Schedulers.fromExecutorService(service2))
                )
                .subscribe(s -> {
                    System.out.println(x + "---" + s + "---" + Thread.currentThread().getName());
                });

// countMono(9)
// .subscribeOn(Schedulers.fromExecutorService(service))
// .subscribe(s -> {
// System.out.println(s+"---"+Thread.currentThread().getName());
// });


// countFlux(10)
// .subscribeOn(Schedulers.fromExecutorService(service))
// .subscribe(s -> {
// System.out.println(x+"---"+Thread.currentThread().getName());
// });

        System.out.println("Nhungggg---" + Thread.currentThread().getName());
    }
}