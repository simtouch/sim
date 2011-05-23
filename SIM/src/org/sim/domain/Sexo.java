

package org.sim.domain;

/**
 *
 * @author Franky Villadiego
 */
public enum Sexo {
    M{
        @Override
        public String toString() {
            return "M - " + "Masculino";
        }
    },F{
        @Override
        public String toString() {
            return "F - " + "Femenino";
        }
    };

}
