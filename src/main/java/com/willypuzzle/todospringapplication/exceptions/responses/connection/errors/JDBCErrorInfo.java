package com.willypuzzle.todospringapplication.exceptions.responses.connection.errors;

import com.willypuzzle.todospringapplication.exceptions.responses.BaseErrorInfo;

public class JDBCErrorInfo extends BaseErrorInfo {

    public JDBCErrorInfo(Exception ex){
        super(ex);
    }
}
