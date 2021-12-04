package observable;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableMaybeObserver;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**

 The CompositeDisposable class represents a container which can hold multiple disposable and offers O(1) complexity of adding and removing disposables.
 */


public class CompositeDisposableObservableTester {

    public static void main(String[] args) throws InterruptedException{
        CompositeDisposable compositeDisposable = new CompositeDisposable();

        //create an Single Observer
        Disposable disposableSingle = Single.just("Hello RxJava World")
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableSingleObserver<String>(){

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(@NonNull String s) {
                        System.out.println(s);
                    }
                });

        //create an observer
        Disposable disposableMayBe = Maybe.just("Hii")
                .delay(2,TimeUnit.SECONDS,Schedulers.io())
                .subscribeWith(new DisposableMaybeObserver<String>(){
                    @Override
                    public void onError( Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(@NonNull String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done...");
                    }
                });
        Thread.sleep(3000);

        compositeDisposable.add(disposableSingle);
        compositeDisposable.add(disposableMayBe);

        //start observing
        compositeDisposable.dispose();

    }
}
