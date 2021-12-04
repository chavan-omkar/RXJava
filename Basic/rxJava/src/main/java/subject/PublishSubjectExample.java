package subject;

import io.reactivex.rxjava3.subjects.PublishSubject;

/**
 PublishSubjectExample emits items to currently subscribed Observers and terminal events to current or late Observers.
 */


public class PublishSubjectExample {
    public static void main(String[] args) {
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();

        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(value -> result1.append(value));
       // subject.subscribe(value -> result2.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");

        subject.onComplete();
        //output will be abcd
        System.out.println(result1);

        //output will be d only
        //as subscribed after c item emitted.
        System.out.println(result2);

    }
}
