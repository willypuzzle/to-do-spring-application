package com.willypuzzle.todospringapplication.libraries.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLogger {
    public static Logger logger(Class<?> cl){
        return LoggerFactory.getLogger(cl);
    }

    public static Logger logger(String cl){
        return LoggerFactory.getLogger(cl);
    }

    public static Logger logger(){
        try{
            Class<?> cl = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            return logger(cl);
        }catch (ClassNotFoundException | ArrayIndexOutOfBoundsException ex){
            return logger(ApplicationLogger.class);
        }
    }
}
