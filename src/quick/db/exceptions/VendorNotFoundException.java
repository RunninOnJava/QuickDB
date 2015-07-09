package quick.db.exceptions;

/**
 * Exception is thrown if a null or incorrect vendor 
 * is passed into QuickDBConnect.getConnection()
 * Message will display valid vendors to choose from
 * 
 * @author JordanF
 */
public class VendorNotFoundException extends Exception {
    
    public VendorNotFoundException(){
        
    }
    
    public VendorNotFoundException(String message){
        super(message);
    }
    
}
