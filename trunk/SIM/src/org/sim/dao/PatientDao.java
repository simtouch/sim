

package org.sim.dao;

import org.sim.util.BeanContainer;

/**
 *
 * @author Franky Villadiego
 */
public interface PatientDao extends GenericDao {


    public static class Impl{
        public static PatientDao getInstance(){
            return (PatientDao)BeanContainer.getBean(PatientDao.class);
        }
    }
}
