Observables represents the sources of data where as Observers (Subscribers) listen to them. In nutshell, an Observable emits items and a Subscriber then consumes these items.


https://github.com/ReactiveX/RxJava

Youtube tutorial : 
https://www.youtube.com/watch?v=OyVIGm0O7yY&list=PLYHDP_mF5KjYC-k2DEVtOZCmjHfQqnav4&index=1

Operators:-


Following are the operators which are used to create an Observable.
Sr.No.
Operator & Description
1
Create
Creates an Observable from scratch and allows observer method to call programmatically.
2
Defer
Do not create an Observable until an observer subscribes. Creates a fresh observable for each observer.
3
Empty/Never/Throw
Creates an Observable with limited behavior.
4
From
Converts an object/data structure into an Observable.
5
Interval
Creates an Observable emitting integers in sequence with a gap of specified time interval.
6
Just
Converts an object/data structure into an Observable to emit the same or same type of objects.
7
Range
Creates an Observable emitting integers in sequence of given range.
8
Repeat
Creates an Observable emitting integers in sequence repeatedly.
9
Start
Creates an Observable to emit the return value of a function.
10
Timer
Creates an Observable to emit a single item after given delay.





Following are the operators which are used to transform an item emitted from an Observable.
Sr.No.
Operator & Description
1
Buffer
Gathers items from Observable into bundles periodically and then emit the bundles rather than items.
2
FlatMap
Used in nested observables. Transforms items into Observables. Then flatten the items into single Observable.
3
GroupBy
Divide an Observable into set of Observables organized by key to emit different group of items.
4
Map
Apply a function to each emitted item to transform it.
5
Scan
Apply a function to each emitted item, sequentially and then emit the successive value.
6
Window
Gathers items from Observable into Observable windows periodically and then emit the windows rather than items.






 
 
 
Following are the operators which are used to create a single Observable from multiple Observables.
Sr.No.
Operator & Description
1
And/Then/When
Combine item sets using Pattern and Plan intermediaries.
2
CombineLatest
Combine the latest item emitted by each Observable via a specified function and emit resulted item.
3
Join
Combine items emitted by two Observables if emitted during time-frame of second Observable emitted item.
4
Merge
Combines the items emitted of Observables. 
5
StartWith
Emit a specified sequence of items before starting to emit the items from the source Observable
6
Switch
Emits the most recent items emitted by Observables.
7
Zip
Combines items of Observables based on function and emits the resulted items.




Following are the operators which are often useful with Observables.
Sr.No.
Operator & Description
1
Delay
Register action to handle Observable life-cycle events.
2
Materialize/Dematerialize
Represents item emitted and notification sent.
3
ObserveOn
Specify the scheduler to be observed.
4
Serialize
Force Observable to make serialized calls.
5
Subscribe
Operate upon the emissions of items and notifications like complete from an Observable
6
SubscribeOn
Specify the scheduler to be used by an Observable when it is subscribed to.
7
TimeInterval
Convert an Observable to emit indications of the amount of time elapsed between emissions.
8
Timeout
Issues error notification if specified time occurs without emitting any item.
9
Timestamp
Attach timestamp to each item emitted.
9
Using
Creates a disposable resource or same lifespan as that of Observable.





Following are the operators which evaluates one or multiple Observables or items emitted.
Sr.No.
Operator & Description
1
All
Evaluates all items emitted to meet given criteria.
2
Amb
Emits all items from the first Observable only given multiple Observables.
3
Contains
Checks if an Observable emits a particular item or not.
4
DefaultIfEmpty
Emits default item if Observable do not emit anything.
5
SequenceEqual
Checks if two Observables emit the same sequence of items.
6
SkipUntil
Discards items emitted by first Observable until a second Observable emits an item.
7
SkipWhile
Discard items emitted by an Observable until a given condition becomes false.
8
TakeUntil
Discards items emitted by an Observable after a second Observable emits an item or terminates.
9
TakeWhile
Discard items emitted by an Observable after a specified condition becomes false.




Following are the operators which operates on entire items emitted by an Observable.
Sr.No.
Operator & Description
1
Average
Evaluates averages of all items and emit the result.
2
Concat
Emits all items from multiple Observable without interleaving.
3
Count
Counts all items and emit the result.
4
Max
Evaluates max valued item of all items and emit the result.
5
Min
Evaluates min valued item of all items and emit the result.
6
Reduce
Apply a function on each item and return the result.
7
Sum
Evaluates sum of all items and emit the result.




Following are the operators which has more precisely control over subscription.
Sr.No.
Operator & Description
1
Connect
Instruct a connectable Observable to emit items to its subscribers.
2
Publish
Converts an Observable to connectable Observable.
3
RefCount
Converts a connectable Observable to ordinary Observable.
4
Replay
Ensure same sequence of emitted items to be seen by each subscriber, even after the Observable has begun emitting items and subscribers subscribe later.



Subject:-

As per the Reactive, a Subject can act as both Observable as well as Observer.Because it is an observer, it can subscribe to one or more Observables, and because it is an Observable, it can pass through the items it observes by reemitting them, and it can also emit new items.
There are four types of Subjects −
Sr.No.
Subject & Description
1
Publish Subject
Emits only those items which are emitted after time of subscription.
2
Replay Subject
Emits all the items emitted by source Observable regardless of when it has subscribed the Observable.
3
Behavior Subject
Upon subscription, emits the most recent item then continue to emit item emitted by the source Observable.
4
Async Subject
Emits the last item emitted by the source Observable after it's completes emission.


Schedulers:-
Schedulers are used in multi-threading environment to work with Observable operators. 
As per the Reactive,Scheduler are used to schedule how chain of operators will apply to different threads.
By default, an Observable and the chain of operators that you apply to it will do its work, and will notify its observers, on the same thread on which its Subscribe method is called. The SubscribeOn operator changes this behavior by specifying a different Scheduler on which the Observable should operate. The ObserveOn operator specifies a different Scheduler that the Observable will use to send notifications to its observers.
There are following types of Schedulers available in RxJava −
Sr.No.
Scheduler & Description
1
Schedulers.computation()
Creates and returns a Scheduler intended for computational work. Count of threads to be scheduled depends upon the CPUs present in the system. One thread is allowed per CPU. Best for event-loops or callback operations.
2
Schedulers.io()
Creates and returns a Scheduler intended for IO-bound work. Thread pool may extend as needed.
3
Schedulers.newThread()
Creates and returns a Scheduler that creates a new Thread for each unit of work.
4
Schedulers.trampoline()
Creates and returns a Scheduler that queues work on the current thread to be executed after the current work completes.
4
Schedulers.from(java.util.concurrent.Executor executor)
Converts an Executor into a new Scheduler instance.



Buffering:-
Buffering operator allows to gather items emitted by an Observable into a list or bundles and emit those bundles instead of items.


Windowing:-
Windowing operator works similar to buffer operator but it allows to gather items emitted by an Observable into another observable instead of collection and emit those Observables instead of collections. 


