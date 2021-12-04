package subject;


import io.reactivex.rxjava3.subjects.ReplaySubject;

/**

 ReplaySubject replays events/items to current and late Observers.
 */


public class ReplaySubjectExample {

    public static void main(String[] args) {
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();

        ReplaySubject<String>subject = ReplaySubject.create();

        subject.subscribe(value -> result1.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();

        //output will be abcd
        System.out.println(result1);

        //output will be abcd being RplaySubject
        // as ReplaySubject emitts all the items

        System.out.println(result2);

    }

}
