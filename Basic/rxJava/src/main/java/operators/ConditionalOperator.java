package operators;

import io.reactivex.rxjava3.core.Observable;

/**
 Using defaultIfEmpty operator to operate on an Observable
 */

public class ConditionalOperator {

    public static void main(String[] args) {
        final StringBuilder result = new StringBuilder();
        Observable.empty()
                .defaultIfEmpty("No Data")
                .subscribe(s -> result.append(s));
        System.out.println(result);

        String [] letters ={"a", "b", "c", "d", "e", "f", "g"};

        final StringBuilder result1 = new StringBuilder();

        Observable.fromArray(letters)
                .firstElement()
                .defaultIfEmpty("No Data1")
                .subscribe(s -> result1.append(s));

        System.out.println(result1);




    }

}
