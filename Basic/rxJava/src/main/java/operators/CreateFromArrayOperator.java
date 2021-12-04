package operators;

import io.reactivex.rxjava3.core.Observable;

/**
 Using fromArray and map operator to transform an Observable
 */
public class CreateFromArrayOperator {

    public static void main(String[] args) {
        String [] letters = {"a","b","c","d","e","f","g"};

        final StringBuilder result = new StringBuilder();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                .map(String::toUpperCase)
                .subscribe(letter -> result.append(letter+" "));
        System.out.println(result);
    }
}
