
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class ObjectNotFoundException extends BusinessException{

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    
}
