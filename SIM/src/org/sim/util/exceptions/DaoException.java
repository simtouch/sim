
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class DaoException extends SIMAppException{

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    
}
