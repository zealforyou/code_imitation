package rx.java;

public abstract class Observable<T> {
    abstract void subscribeActual(Observer<? super T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> onSubscribe) {
        return new ObservableCreate<T>(onSubscribe);
    }

    public void subscribe(Observer<T> observer) {
        subscribeActual(observer);
    }

    public <R> Observable<R> map(final Function<T, R> fun) {
        return new ObservableCreate<R>(new ObservableOnSubscribe<R>() {
            public void subscribe(final ObservableEmitter<R> emitter) {
                Observable.this.subscribe(new Observer<T>() {
                    public void onSubscribe() {

                    }

                    public void onNext(T value) {
                        R apply = fun.apply(value);
                        emitter.onNext(apply);
                    }

                    public void onError(Throwable e) {

                    }

                    public void onComplete() {

                    }
                });
            }
        });
    }

    public Observable<T> subscribeOnThread() {
        return new ObservableCreate<T>(new ObservableOnSubscribe<T>() {
            public void subscribe(final ObservableEmitter<T> emitter) {
                new Thread(new Runnable() {
                    public void run() {
                        Observable.this.subscribe(new Observer<T>() {
                            public void onSubscribe() {

                            }

                            public void onNext(T value) {
                                emitter.onNext(value);
                            }

                            public void onError(Throwable e) {

                            }

                            public void onComplete() {

                            }
                        });
                    }
                }).start();
            }
        });
    }
}
