package com.willypuzzle.todospringapplication.exceptions.responses;

import com.willypuzzle.todospringapplication.config.Environment;
import com.willypuzzle.todospringapplication.exceptions.responses.connection.errors.JDBCErrorInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseErrorInfo {

    protected final String message;

    protected static final Logger LOGGER = LogManager.getLogger(JDBCErrorInfo.class);

    public BaseErrorInfo(Exception ex){
        if(Environment.isProduction()){
            this.message = this.getProdMessageError();
        }else{
            this.message = ex.getMessage();
        }


        LOGGER.error(this.getProdMessageError(), ex);
    }

    public String getMessage() {
        return message;
    }

    protected String getProdMessageError(){
        return "Internal Server Error";
    }
}
