public class InvalidInputException extends RuntimeException {
    private final static String EXP_MESSAGE = "Input Is Invalid";

    public InvalidInputException() {
        super(EXP_MESSAGE);
    }
}
