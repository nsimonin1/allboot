package org.simon.pascal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author simon.pascal.ngos
 *
 */
public class DateUtil {
	/**
	 * 
	 */
	private final static SimpleDateFormat sdfTime;

    static {
        sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 
     * @return
     */
    public static String getTime() {
        return sdfTime.format(new Date());
    }
}
