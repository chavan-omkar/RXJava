package operators;


import io.reactivex.rxjava3.core.Observable;

/**
 Using subscribe operator to subscribe to an Observable
 */
public class SubscribeUtilityOperator {

    public static void main(String[] args) {
        String [] letters = {"a","b","c","d","e","f","g"};
        final StringBuilder result = new StringBuilder();
        Observable<String>observable = Observable.fromArray(letters);
        observable.subscribe(letter -> result.append(letter));

        System.out.println(result);
    }
}
