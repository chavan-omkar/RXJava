package subject;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

/**
 BehaviorSubject emits the most recent item it has observed and then all subsequent observed items to each subscribed Observer.
 */


public class BehaviorSubjectExample {

    public static void main(String[] args) {

        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();
        BehaviorSubject<String>subject = BehaviorSubject.create();
        subject.subscribe(value -> result1.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onComplete();

        //output will be abcd
        System.out.println(result1);

        //output will be cd being BehaviorSubject
        //c is the last emitted item before subscribe

        System.out.println(result2);

    }
}
