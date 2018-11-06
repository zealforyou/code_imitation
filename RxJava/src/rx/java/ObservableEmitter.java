package rx.java;

//观察员发射器
public interface ObservableEmitter<T> {
    void onNext(T t);

    void onError(Throwable e);

    void onComplete();

    void serialize();
}
