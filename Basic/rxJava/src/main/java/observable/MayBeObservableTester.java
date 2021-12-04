package observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
The MayBe class represents deferred response. MayBe observable can emit either a single successful value or no value.
 */

public class MayBeObservableTester {

    public static void main(String[] args) throws InterruptedException{

        //create an observer
        Disposable disposable = Maybe.just("Hello RxJava")
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableMaybeObserver<String>(){
                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(@NonNull String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
        Thread.sleep(3000);
        //start observing
        disposable.dispose();
    }
}
