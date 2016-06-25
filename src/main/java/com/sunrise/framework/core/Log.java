/**
 * @(#)Log.java 12-8-10
 * CopyRight 2012.  All rights reserved
 *
 */
package com.sunrise.framework.core;

import org.apache.commons.logging.LogFactory;

/**
 * @author kinz
 * @version 1.0 12-8-10
 * @since JDK1.6
 */
public class Log {

    private static final org.apache.commons.logging.Log l = LogFactory.getLog(Log.class);

    public static void trace(Object o) {
        l.trace(o);
    }

    public static void trace(Object o, Throwable throwable) {
        l.trace(o, throwable);
    }

    public static void debug(Object o) {
        l.debug(o);
    }

    public static void debug(Object o, Throwable throwable) {
        l.debug(o, throwable);
    }

    public static void info(Object o) {
        l.info(o);
    }

    public static void info(Object o, Throwable throwable) {
        l.info(o, throwable);
    }

    public static void warn(Object o) {
        l.warn(o);
    }

    public static void warn(Object o, Throwable throwable) {
        l.warn(o, throwable);
    }


    public static void error(Object o) {
        l.error(o);
    }

    public static void error(Object o, Throwable throwable) {
        l.error(o, throwable);
    }

    public static void fatal(Object o) {
        l.fatal(o);
    }

    public static void fatal(Object o, Throwable throwable) {
        l.fatal(o, throwable);
    }
}
