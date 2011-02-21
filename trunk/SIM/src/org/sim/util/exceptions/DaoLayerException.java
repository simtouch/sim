
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class DaoLayerException extends SIMAppException{

    public DaoLayerException(String message) {
        super(message);
    }

    public DaoLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoLayerException(Throwable cause) {
        super(cause);
    }

    
}
