public class NotEnoughPermissionsException extends ATMException{

    public NotEnoughPermissionsException() {
        super("WRONG PASSWORD");
    }
}
