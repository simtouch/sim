
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class SIMAppException extends RuntimeException{

    public SIMAppException() {
    }

    public SIMAppException(Throwable cause) {
        super(cause);
    }

    public SIMAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public SIMAppException(String message) {
        super(message);
    }


}
