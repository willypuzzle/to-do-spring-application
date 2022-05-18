package com.willypuzzle.todospringapplication.exceptions.responses.routes.methods;

import com.willypuzzle.todospringapplication.exceptions.responses.BaseErrorInfo;

public class MethodNotSupportedErrorInfo extends BaseErrorInfo {

    protected final String prodMessageError =  "Method not allowed";
    public MethodNotSupportedErrorInfo(Exception ex) {
        super(ex);
    }
}
