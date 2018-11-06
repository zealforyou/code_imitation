package rx.java;

public class Main {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("lkjsljs");
            }
        }).map(new Function<String, String>() {
            public String apply(String s) {
                return "帅哥" + s;
            }
        }).subscribe(new Observer<String>() {
            public void onSubscribe() {

            }

            public void onNext(String value) {
                System.out.println(value);
            }

            public void onError(Throwable e) {

            }

            public void onComplete() {

            }
        });
    }
}
