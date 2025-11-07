package Exception;

public class IncorrectTicketIdException extends VehicleAlreadyParkedException{
    public IncorrectTicketIdException(String message) {
        super(message);
    }
}
