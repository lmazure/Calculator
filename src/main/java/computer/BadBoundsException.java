package computer;

@SuppressWarnings("serial")
public class BadBoundsException extends RuntimeException {

    public BadBoundsException(final String message) {
        super(message);
    }
}