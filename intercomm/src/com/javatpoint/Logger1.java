package com.javatpoint;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Category;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * The <tt>Logger</tt> class acts as a simple wrapper of the Apache Log4j Package.
 * A <tt>Logger</tt> may be instantiated for use by calling the static method
 * <i>getLogger(Object)</i> or <i>getLogger(Class)</i> - each of which
 * will return a <tt>Logger</tt> ready for use.<p>
 *
 * The parameter passed to the <i>getLogger</i> function should be the Class or Object
 * in which the <tt>Logger</tt> is being instantiated and used.<p>
 *
 * The logging functionality may be altered at any time by modifying the Logger properties
 * file (represented by <tt>LOGGER_CFG</tt>.)  This allows any logging activities to
 * be activated/deactivated and appender changes to be made (where the logging messages are
 * printed) without recompiling.
 *
 * @author  
 */
public class Logger1 {
   // public static final String LOGGER_CFG = "MarketplaceUI_log4j.cfg";
    public static final String LOGGER_CFG = "log4j.properties";
    
	static {
		init();
    }


     /**
       * Logs the message <tt>Object</tt> as priority <em>DEBUG</em>.<p>
       *
       * <em>DEBUG</em>:<p>
       * - information useful during development and debugging (very verbose)<p>
       *
       * @param msg the message to be logged
     */
     public static void debug(Class<?> objClass, Object msg) {
    	 Category.getInstance(objClass).debug(msg);
     }

     /**
       * Logs the message <tt>Object</tt> and the exception information as
       * priority <em>DEBUG</em>.<p>
       *
       * <em>DEBUG</em>:<p>
       * - information useful during development and debugging (very verbose)<p>
       *
       * @param msg the message to be logged
       * @param thrown the information concerning the exception thrown
     */
     public static void debug(Class<?> objClass, Object msg, Throwable thrown) {
    	 Category.getInstance(objClass).debug(msg, thrown);
     }

     /**
       * Logs the message <tt>Object</tt> as priority <em>ERROR</em>.<p>
       *
       * <em>ERROR</em>:<p>
       * - non-fatal problems indiCategory.getInstance(objClass)ing that the system has failed to accomplish
       *    something that is was supposed to do<p>
       * - soap fault codes<p>
       * - soap fault messages<p>
       * - stack trace information (if necessary for tracking purposes)<p>
       *
       * @param msg the message to be logged
     */
     public static void error(Class<?> objClass, Object msg) {
    	 Category.getInstance(objClass).error(msg);
     }

     /**
       * Logs the message <tt>Object</tt> and the exception information
       * as priority <em>ERROR</em>.<p>
       *
       * <em>ERROR</em>:<p>
       * - non-fatal problems indiCategory.getInstance(objClass)ing that the system has failed to accomplish
       *    something that is was supposed to do<p>
       * - soap fault codes<p>
       * - soap fault messages<p>
       * - stack trace information (if necessary for tracking purposes)<p>
       *
       * @param msg the message to be logged
       * @param thrown the information concerning the exception thrown
       */
     public static void error(Class<?> objClass, Object msg, Throwable thrown) {
    	 Category.getInstance(objClass).error(msg, thrown);
     }

     /**
       * Logs the message <tt>Object</tt> as priority <em>FATAL</em>.<p>
       *
       * <em>FATAL</em>:<p>
       * - non-recoverable problems which require immediate attention<p>
       * - soap fault codes<p>
       * - soap fault messages<p>
       * - stack trace information (if necessary for tracking purposes)<p>
       *
       * @param msg the message to be logged
     */
     public static void fatal(Class<?> objClass, Object msg) {
    	 Category.getInstance(objClass).fatal(msg);
     }

     /**
       * Logs the message <tt>Object</tt> and the exception information
       * as priority <em>FATAL</em>.<p>
       *
       * <em>FATAL</em>:<p>
       * - non-recoverable problems which require immediate attention<p>
       * - soap fault codes<p>
       * - soap fault messages<p>
       * - stack trace information (if necessary for tracking purposes)<p>
       *
       * @param msg the message to be logged
       * @param thrown the information concerning the exception thrown
     */
     public static void fatal(Class<?> objClass, Object msg, Throwable thrown) {
    	 Category.getInstance(objClass).fatal(msg, thrown);
     }

     /**
       * Logs the message <tt>Object</tt> as priority <em>INFO</em>.<p>
       *
       * <em>INFO</em>:<p>
       * - events deemed important during the execution of the system<p>
       * - time the request is received<p>
       * - thread processing the request<p>
       * - host sending the request<p>
       * - service being used<p>
       * - method being invoked<p>
       * - time the response is sent<p>
       * - etc…<p>
       *
       * @param msg the message to be logged
     */
     public static void info(Class<?> objClass, Object msg) {
    	 Category.getInstance(objClass).info(msg);
     }

     /**
       * Logs the message <tt>Object</tt> and the exception information
       * as priority <em>INFO</em>.<p>
       *
       * <em>INFO</em>:<p>
       * - events deemed important during the execution of the system<p>
       * - time the request is received<p>
       * - thread processing the request<p>
       * - host sending the request<p>
       * - service being used<p>
       * - method being invoked<p>
       * - time the response is sent<p>
       * - etc…<p>
       *
       * @param msg the message to be logged
       * @param thrown the information concerning the exception thrown
     */
     public static void info(Class<?> objClass, Object msg, Throwable thrown) {
    	 Category.getInstance(objClass).info(msg, thrown);
     }

    /**
     * method for initialization
    */
     private static void init() {
    	 // read the file using class loader and init PropertyConfigurator with it
         Properties configProperties = new Properties();
         try {
        	 InputStream configStream = Logger1.class.getClassLoader().getResourceAsStream(LOGGER_CFG);
             if (configStream == null){
            	 configStream = new FileInputStream(ConfigFileReader.getConfigDir() + LOGGER_CFG); //use FileInputStream instead of getClass CAB                 
             }
             if (configStream != null) {
            	 configProperties.load(configStream);
                 PropertyConfigurator.configure(configProperties);
             }
         }
         catch (IOException ioe) {
        	 ioe.printStackTrace();
         }
         
      }//init

     /**
       * Logs the message <tt>Object</tt> as priority <em>WARN</em>.<p>
       *
       * <em>WARN</em>:<p>
       * - non-fatal problems that system has encountered and handled appropriately<p>
       * - soap fault codes<p>
       * - soap fault messages<p>
       * - stack trace information (if necessary for tracking purposes)<p>
       *
       * @param msg the message to be logged
     */
     public static void warn(Class<?> objClass, Object msg) {
    	 Category.getInstance(objClass).warn(msg);
     }

     /**
       * Logs the message <tt>Object</tt> and the exception information
       * as priority <em>WARN</em>.<p>
       *
       * <em>WARN</em>:<p>
       * - non-fatal problems that system has encountered and handled appropriately<p>
       * - soap fault codes<p>
       * - soap fault messages<p>
       * - stack trace information (if necessary for tracking purposes)<p>
       *
       * @param msg the message to be logged
       * @param thrown the information concerning the exception thrown
     */
     public static void warn(Class<?> objClass, Object msg, Throwable thrown) {
    	 Category.getInstance(objClass).warn(msg, thrown);
     }
      
}//end of class