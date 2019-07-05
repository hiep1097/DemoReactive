import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ReactorSnippets {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    public static void simpleCreation() {
        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);
        System.out.println();
        manyWords.subscribe(System.out::println);
    }

    public static void findingMissingLetter() {
        Mono<String> missing = Mono.just("s");
        Flux<String> manyLetters = Flux
                .fromIterable(words)
                .concatWith(missing)
                .flatMap(word->{
                    return Flux.fromArray(word.split(""));
                })
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));

        manyLetters.subscribe(System.out::println);
    }

    public static void shortCircuit() {
        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(Mono.just("world").delaySubscription(Duration.ofMillis(500)));

        helloPauseWorld.subscribe(System.out::println);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void blocks() {
        Flux<String> helloPauseWorld =
                Mono.just("Hello")
                        .concatWith(Mono.just("world")
                                .delaySubscription(Duration.ofMillis(1000)));

        helloPauseWorld.toStream()
                .forEach(System.out::println);
    }

    public static void firstEmitting() {
        Mono<String> a = Mono.just("oops I'm late")
                .delaySubscription(Duration.ofMillis(450));
        Flux<String> b = Flux.just("let's get", "the party", "started")  .delayElements(Duration.ofMillis(400));


        Flux.first(a, b)
                .toIterable()
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
//        simpleCreation();
//        findingMissingLetter();
//        shortCircuit();
//        blocks();
        firstEmitting();
    }
}
