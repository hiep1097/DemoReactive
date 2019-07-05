import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertThat;

public class Testing {
    public static void main(String[] args) {
//        Mono mono = Mono.just(1);
//        StepVerifier.create(mono)
//                .expectNext(1)
//                .expectComplete()
//                .verify();


//        Flux flux = Flux.just("1", "2");
//        StepVerifier.create(flux)
//                .expectNext("1")
//                .expectNext("2")
//                .expectComplete()
//                .verify();

//        List<String> words = Arrays.asList(
//              "1","2","3"
//        );
//        Flux flux = Flux.fromIterable(words);
//                StepVerifier.create(flux)
//                .expectNext("1")
//                .expectNext("2")
//                .expectNext("3")
//                .expectComplete()
//                .verify();

//        Flux flux = Flux.just(1,2,3)
//                .map(i->{
//                   if (i<=2) return i;
//                   throw new RuntimeException("Error with 3");
//                });
//
//        StepVerifier.create(flux)
//                .expectNext(1,2)
//                .expectError()
//                .verify();

//        Flux flux = Flux.just(1,2,3)
//                .flatMap(i->{
//                   return Flux.just(i,i*2);
//                });
//        StepVerifier.create(flux)
//                .expectNext(1,2)
//                .expectNext(2,4)
//                .expectNext(3,6)
//                .expectComplete()
//                .verify();

//

//        Flux<Integer> evenNumbers = Flux
//                .range(1, 5)
//                .filter(x -> x % 2 == 0); // i.e. 2, 4
//
//        Flux<Integer> oddNumbers = Flux
//                .range(1, 5)
//                .filter(x -> x % 2 > 0);  // ie. 1, 3, 5
//
//        Flux<Integer> fluxOfIntegers = Flux.zip(
//                evenNumbers,
//                oddNumbers,
//                (a,b)->a*b);
//
//        StepVerifier.create(fluxOfIntegers)
//                .expectNext(2)
//                .expectNext(12)
//                .expectComplete()
//                .verify();

//        Flux flux = Flux.generate(
//                ()->0,
//                (state,sink)->{
//                    sink.next("3x"+state+"="+3*state);
//                    if (state==3) sink.complete();
//                    return state+1;
//                }, (state)-> System.out.println(state)
//        );
//
//        StepVerifier.create(flux)
//                .expectNext("3x0=0")
//                .expectNext("3x1=3")
//                .expectNext("3x2=6")
//                .expectNext("3x3=9")
//                .expectComplete()
//                .verify();

//        Flux flux = Flux.empty()
//                .defaultIfEmpty(1);
//        StepVerifier.create(flux)
//                .expectNext(1)
//                .expectComplete()
//                .verify();

        Flux.range(1, 3)
                .subscribe(i -> System.out.println(i),
                        err -> System.err.println(err),
                        () -> System.out.println("done"),
                        sub->sub.request(2));
    }
}
