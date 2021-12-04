package operators;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

/**
 Using connect operator on a ConnectableObservable
 */

public class ConnectableOperator {

    public static void main(String[] args) {
        String[]letters =  {"a", "b", "c", "d", "e", "f", "g"};
        final StringBuilder result = new StringBuilder();
        ConnectableObservable<String>conectable = Observable.fromArray(letters).publish();

        conectable.subscribe(letter -> result.append(letter));
        System.out.println(result.length());
        conectable.connect();
        System.out.println(result.length());
        System.out.println(result);
    }
}
