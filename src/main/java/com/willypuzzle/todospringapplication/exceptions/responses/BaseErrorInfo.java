package com.willypuzzle.todospringapplication.exceptions.responses;

import com.willypuzzle.todospringapplication.config.Environment;
import com.willypuzzle.todospringapplication.exceptions.responses.connection.errors.JDBCErrorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseErrorInfo {

    protected final String message;

    protected final String prodMessageError =  "Internal Server Error";

    protected static final Logger LOGGER = LogManager.getLogger(JDBCErrorInfo.class);

    public BaseErrorInfo(Exception ex){
        if(Environment.isProduction()){
            this.message = this.prodMessageError;
        }else{
            this.message = ex.getMessage();
        }


        LOGGER.error("A JDBC Error occurred", ex);
    }

    public String getMessage() {
        return message;
    }
}
