package subject;

import io.reactivex.rxjava3.subjects.AsyncSubject;

/**
 AsyncSubject emits the only last value followed by a completion event or the received error to Observers.
 */


public class AsyncSubjectExample {
    public static void main(String[] args) {
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();
        AsyncSubject<String>subject = AsyncSubject.create();

        subject.subscribe(value -> result1.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();

        //output will be d being last emitted item
        System.out.println(result1);
        //output will be d being last emitted item
        System.out.println(result2);
    }
}
