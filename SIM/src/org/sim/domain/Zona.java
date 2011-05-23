
package org.sim.domain;

/**
 *
 * @author Franky Villadiego
 */
public enum Zona {
    U{
        @Override
        public String toString() {
            return "U - " + "Urbana";
        }
    },
    R{
        @Override
        public String toString() {
            return "R - " + "Rural";
        }
    }

}
