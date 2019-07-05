import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> evenNumbers = Flux
                .range(1, 10)
                .filter(x -> x % 2 == 0); // 2 4 6 8 10

        Flux<Integer> oddNumbers = Flux
                .range(1, 10)
                .filter(x -> x % 2 > 0);  //1 3 5 7 9


//        Flux<Integer> flux = Flux.concat(evenNumbers,oddNumbers);
//        flux.subscribe(System.out::println);

//        Flux<Integer> flux = Flux.combineLatest(
//                oddNumbers,
//                evenNumbers,
//                (a,b)-> a+b
//                );

//        Flux<Integer> fluxOfIntegers = Flux.zip(
//                evenNumbers,
//                oddNumbers,
//                (a, b) -> a + b);

        Flux<Integer> fluxOfIntegers = evenNumbers
                .zipWith(oddNumbers, (a, b) -> a * b);
        fluxOfIntegers.subscribe(System.out::println);
    }
}
