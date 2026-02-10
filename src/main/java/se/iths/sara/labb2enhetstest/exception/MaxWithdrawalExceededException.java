package se.iths.sara.labb2enhetstest.exception;

public class MaxWithdrawalExceededException extends RuntimeException {
    public MaxWithdrawalExceededException() {
        super("Det maximala uttagsbeloppet har överskridits");
    }

    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
