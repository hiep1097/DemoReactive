import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.time.Duration.ofSeconds;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.stream.Collectors.toList;

public class vd2 {
//    public List<Either<String, User>> loadUsers(List<String> cwids) {
//        Scheduler scheduler = Schedulers.fromExecutor(newFixedThreadPool(10));
//
//        Flux<Either<String, User>> eventualUsers = Flux.fromIterable(cwids)
//                .flatMap(cwid -> Mono.fromCallable(() -> fetchUser(cwid))
//                        .timeout(ofSeconds(2))
//                        .map((Function<User, Either<String, User>>) Either::right)
//                        .doOnError(error -> log.error("An error occurred while fetching user {}", cwid))
//                        .otherwiseReturn(left(cwid))
//                        .subscribeOn(scheduler));
//
//        log.info("Starting to fetch users");
//        List<Either<String, User>> maybeUsers = eventualUsers
//                .toStream()
//                .collect(toList());
//        log.info("Finished to fetch users");
//
//        return maybeUsers;
//    }
    public static void main(String[] args) throws InterruptedException {
        for (int i=1;i<=1000000000;i++){
            int j = i+1;
        }
    }
}
