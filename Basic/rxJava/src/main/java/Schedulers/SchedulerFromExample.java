package Schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 Schedulers.from(Executor) method converts an Executor into a new Scheduler instance.
 */


public class SchedulerFromExample {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("A","AB","ABC")
                .flatMap(v -> getLengthWithDelay(v)
                        .doOnNext(s -> System.out.println("Processing Thread "
                        +Thread.currentThread().getName()))
                        .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(3))))
                .subscribe(length -> System.out.println("Receiver Thread "
                        +Thread.currentThread().getName()
                        +", Item length "+length));
        Thread.sleep(10000);
    }

    private static Observable<Integer> getLengthWithDelay(String v) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3)*1000);
            return Observable.just(v.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return null;
    }
}
