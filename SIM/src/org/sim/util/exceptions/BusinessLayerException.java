
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class BusinessLayerException extends SIMAppException{

    public BusinessLayerException(String message) {
        super(message);
    }

    public BusinessLayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessLayerException(Throwable cause) {
        super(cause);
    }

    
}
