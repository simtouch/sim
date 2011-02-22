
package org.sim.util;

import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Franky Villadiego
 */
public class DateUtil {

    private static DateFormat formatDate=DateFormat.getDateInstance(DateFormat.MEDIUM);
    private static DateFormat formatTime=DateFormat.getTimeInstance(DateFormat.SHORT);

    private DateUtil(){}

    public static String formatDate(Date date){
        return formatDate.format(date);
    }

    public static String formatTime(Date time){
        return formatTime.format(time);
    }


}
