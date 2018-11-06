package rx.java;

//观察源订阅监听器
public interface ObservableOnSubscribe<T> {
    void subscribe(ObservableEmitter<T> emitter);
}
