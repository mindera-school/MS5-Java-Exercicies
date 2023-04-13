public class ATMException extends Exception{

    public ATMException(){
        super("Error");
    }

    public ATMException(String message){
        super(message);
    }
}
