package operators;

import io.reactivex.rxjava3.core.Observable;

import java.util.Locale;

/**
 Using take operator to filter an Observable

 */
public class SelectivelyEmitOperator {

    public static void main(String[] args) {
        String [] letters = {"a","b","c","d","e","f","g"};
        final StringBuilder result = new StringBuilder();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                //.take(7)
                .skipLast(2)
                .subscribe(letter -> result.append(letter.toUpperCase(Locale.ROOT)+" "));
        System.out.println(result);

    }
}
