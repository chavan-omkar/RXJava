package windowing;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**

 Windowing operator works similar to buffer operator but it allows to gather items emitted by an Observable into another observable instead of collection and emit those Observables instead of collections.
 */

public class WindowingExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer>observable = Observable.just(1,2,3,4,5,6,7,8,9);

        observable.subscribeOn(Schedulers.io())
                .delay(2, TimeUnit.SECONDS,Schedulers.io())
                .window(3)
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("Subscribed");
                    }

                    @Override
                    public void onNext(@NonNull Observable<Integer> integerObservable) {
                        System.out.println("onNext: ");
                        integerObservable.subscribe(value -> System.out.println(value));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done..!");

                    }
                });
        Thread.sleep(3000);
    }
}
