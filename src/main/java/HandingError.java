import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class HandingError {
    public static void main(String[] args) {
//        Flux<String> flux = Flux.just(1,0,2)
//                .map(i-> "100/"+i+"="+(100/i))
//                .onErrorResume(e->Flux.just("0"));
//        flux.subscribe(i-> System.out.println(i));
//        StepVerifier.create(flux)
//                .expectNext("100/1=100")
//                .expectNext("Divided by zero")
//                .expectComplete()
//                .verify();

        Flux flux = Flux.just(1,0,2)
                .flatMap(k -> divide(k))
                .onErrorResume(e->fallback());

       StepVerifier.create(flux)
               .expectNext("100/1=100")
               .expectNext(1,0,2)
               .expectComplete()
               .verify();
    }

    public static Flux divide(int k){
        return Flux.just("100/"+k+"="+(100/k));
    }
    public static Flux fallback(){
        return Flux.just(1,0,2);
    }
}

