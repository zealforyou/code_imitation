package rx.java;

//观察者
public interface Observer<T> {
    void onSubscribe();

    void onNext(T value);

    void onError(Throwable e);

    void onComplete();
}
