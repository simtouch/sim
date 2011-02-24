
package org.sim.util.exceptions;

/**
 *
 * @author Franky Villadiego
 */
public class RepositoryException extends SIMAppException{

    public RepositoryException(String message) {
        super(message);
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    
}
