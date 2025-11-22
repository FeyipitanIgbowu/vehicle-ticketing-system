package exceptions;

public class IncorrectVehicleIdException extends RuntimeException {
    public IncorrectVehicleIdException(String message) {
        super(message);
    }
}
