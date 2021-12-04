package observable;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;


/*
Following is the sequential protocol that Single Observable operates −

onSubscribe (onSuccess | onError)?
 */
public class SingleObservableTester {

    public static void main(String[] args) throws InterruptedException{
       //  final Logger LOG = LoggerFactory.getLogger(observable.SingleObservableTester.class);
        //Create Observable
        Single<String> testSingle = Single.just("Hello rxJava!");

        //Create an observer
        Disposable disposable = testSingle
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(
                        new DisposableSingleObserver<String>(){
                            @Override
                            public void onError(@NonNull Throwable e) {
                            e.printStackTrace();
                            }

                            @Override
                            public void onSuccess(@NonNull String value) {
                              //  LOG.info(value);
                            System.out.println(value);

                            }
                        });
        Thread.sleep(3000);
        //start observing
        disposable.dispose();

    }
}
