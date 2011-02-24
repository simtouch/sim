
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class BusinessException extends SIMAppException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    
}
