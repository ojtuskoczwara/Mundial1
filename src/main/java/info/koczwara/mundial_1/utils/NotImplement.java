package info.koczwara.mundial_1.utils;

/**
 * Created by Mroziqella on 22.04.2017.
 */
public class NotImplement extends RuntimeException {
    public NotImplement() {
    }

    public NotImplement(String message) {
        super(message);
    }

    public NotImplement(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplement(Throwable cause) {
        super(cause);
    }
}
