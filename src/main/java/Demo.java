import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Demo {
    public static void main(String[] args) {
//        Flux<Integer> ints = Flux.range(1, 3);
//        ints.subscribe(i -> System.out.println(i));

//        Flux<Integer> ints = Flux.range(1,4);
//                .map(i-> {
//                   if (i<=3) return i;
//                   throw new RuntimeException("Got to 4");
//                });
//        ints.subscribe(i-> System.out.println(i),
//                error -> System.err.println(error),
//                () -> System.out.println("Done"),
//                sub -> sub.request(2)
//        );
//
//        Mono<Integer> intt = Mono.just(1);

//        SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
//        Flux<Integer> ints = Flux.range(1, 4);
//        ints.subscribe(i -> System.out.println(i),
//                error -> System.err.println("Error " + error),
//                () -> {System.out.println("Done");},
//                s -> s.request(10));
//        ints.subscribe(ss);

//        Flux.range(1,10)
//                .doOnRequest(r-> System.out.println("request of "+r))
//                .subscribe(new BaseSubscriber<Integer>() {
//                    @Override
//                    protected void hookOnSubscribe(Subscription subscription) {
//                        request(5);
//                    }
//
//                    @Override
//                    protected void hookOnNext(Integer value) {
//                        if (value<=3)
//                        System.out.println("Cancelling after having received " + value);
//                        else cancel();
//                    }
//                });

//        Flux<String> flux = Flux.generate(
//                AtomicLong::new,
//                (state, sink) -> {
//                    long i = state.getAndIncrement();
//                    sink.next("3 x " + i + " = " + 3*i);
//                    if (i == 10) sink.complete();
//                    return state;
//                }, (state) -> System.out.println("state: " + state));
//        flux.subscribe(i-> System.out.println(i));

//        Flux<String> bridge = Flux.create(sink -> {
//            myEventProcessor.register(
//                    new MyEventListener<String>() {
//
//                        public void onDataChunk(List<String> chunk) {
//                            for (String s : chunk) {
//                                sink.next(s);
//                            }
//                        }
//
//                        public void processComplete() {
//                            sink.complete();
//                        }
//                    });
//        });

//        Flux<String> alphabet = Flux.just(-1, 30, 13, 9, 20)
//                .handle((i, sink) -> {
//                    String letter = alphabet(i);
//                    if (letter != null)
//                        sink.next(letter);
//                });
//
//        alphabet.subscribe(System.out::println);

        try {
            final Mono<String> mono = Mono.just("hello ");
            new Thread(() -> mono
                    .map(msg -> msg + "thread ")
                    .subscribe(v ->
                            System.out.println(v + Thread.currentThread().getName())
                    )
            ).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }
}
