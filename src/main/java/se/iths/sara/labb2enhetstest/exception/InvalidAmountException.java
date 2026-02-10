package se.iths.sara.labb2enhetstest.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException() {
        super("Beloppet måste vara större än 0.");
    }

    public InvalidAmountException(String message) {
        super(message);
    }
}
