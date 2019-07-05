import reactor.core.publisher.Flux;

public class DemoMapAndFlatMap {
    public static void main(String[] args) {
        //map
        System.out.println("MAP:");
        Flux.range(1,3)
                .map(i->Flux.just(i,i*2).subscribe(j-> System.out.println(j)))
                .subscribe();


        System.out.println("FLATMAP:");
        //flatmap
        Flux.range(1,3)
                .flatMap(i-> Flux.just(i,i*2))
                .subscribe(i-> System.out.println(i));
    }
}
