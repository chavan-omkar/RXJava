package buffering;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 Buffering operator allows to gather items emitted by an Observable into a list or bundles and emit those bundles instead of items. In the example below, we've created an Observable to emit 9 items and using buffering, 3 items will be emitted together.
 */

public class BufferingExample {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9);

        observable.subscribeOn(Schedulers.io())
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .buffer(2)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("Subscribed");
                    }

                    @Override
                    public void onNext(@NonNull List<Integer> integers) {
                        System.out.println("onNext: ");
                        for (Integer value : integers) {
                            System.out.println(value);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed..!");
                    }
                });
        Thread.sleep(3000);
    }


}
