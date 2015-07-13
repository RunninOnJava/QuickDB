package quick.db.exceptions;

/**
 * Exception is thrown if incorrect parameters are 
 * passed to QuickDBConnect.getConnection()
 * 
 * @author JordanF
 */
public class InvalidInputException extends Exception {
    
    public InvalidInputException() {
        
    }
    
    public InvalidInputException(String message) {
        super(message);
    }
    
}
