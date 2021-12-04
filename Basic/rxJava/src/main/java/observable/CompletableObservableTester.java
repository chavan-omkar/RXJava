package observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**

 The Completable class represents deferred response. Completable observable can either indicate a successful completion or error.

 */


public class CompletableObservableTester {

    public static void main(String[] args) throws InterruptedException {

        //create an Observer
        Disposable disposable = Completable.complete()
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableCompletableObserver(){

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    protected void onStart() {
                        System.out.println("Started..");
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
