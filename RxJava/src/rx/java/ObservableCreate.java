package rx.java;

/**
 * 观察源创建类
 *
 * @param <T>
 */
public class ObservableCreate<T> extends Observable<T> {
    //source 为create 中创建的ObservableOnSubscribe对象
    final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    /**
     * 实际的订阅方法
     *
     * @param observer
     */
    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        //传入的observer为被订阅的观察者
        CreateEmitter<T> emitter = new CreateEmitter<T>(observer);
        //通知观察者被订阅，
        observer.onSubscribe();
        try {
            //emitter开始执行，其发出的事件会传递到observer
            source.subscribe(emitter);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * 把Emitter发出的事件分发给observer
     *
     * @param<T>
     */

    static final class CreateEmitter<T> implements ObservableEmitter<T> {

        final Observer<? super T> observer;

        CreateEmitter(Observer<? super T> observer) {

            this.observer = observer;

        }


        public void onNext(T t) {
            observer.onNext(t);
        }

        public void onError(Throwable e) {
            observer.onError(e);
        }

        public void onComplete() {
            observer.onComplete();
        }

        public void serialize() {

        }
    }

}
