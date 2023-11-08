package br.edu.unijui.utils;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public  class LoggerUtils {
    
    private static  LoggerUtils loggerUtils;
    private static final  Logger logger = Logger.getLogger(LoggerUtils.class.getPackage().getName());

    private LoggerUtils() {                
        try {
            Properties conf = getLogConf();

            Handler handler = new FileHandler(conf.getProperty("arquivo"), Boolean.parseBoolean(conf.getProperty("acrescentar")));
            Logger.getLogger("").addHandler(handler);

            if (conf.getProperty("formato-saida").equalsIgnoreCase("XML")) {
                handler.setFormatter(new XMLFormatter());
            } else if (conf.getProperty("formato-saida").equalsIgnoreCase("SIMPLE")) {
                handler.setFormatter(new SimpleFormatter());
            }
            
        } catch (IOException | SecurityException ex) {
            System.out.println(ex);
        }
    }
    
    public static LoggerUtils getLoggerUtils (){
        if(loggerUtils == null){
            loggerUtils = new LoggerUtils();
        }
        return loggerUtils;
    }
    
    public void logMessage(String msg){
        logger.info(msg);   
    }
       
    private static Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("arquivo", "logViagens.log");
        conf.setProperty("acrescentar", "true");
        conf.setProperty("formato-saida", "SIMPLE");

        return conf;
    }
}
