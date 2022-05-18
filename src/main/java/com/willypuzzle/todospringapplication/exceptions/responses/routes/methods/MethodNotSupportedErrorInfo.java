package com.willypuzzle.todospringapplication.exceptions.responses.routes.methods;

import com.willypuzzle.todospringapplication.exceptions.responses.BaseErrorInfo;

public class MethodNotSupportedErrorInfo extends BaseErrorInfo {
    public MethodNotSupportedErrorInfo(Exception ex) {
        super(ex);
    }

    @Override
    protected String getProdMessageError(){
        return "Method not allowed";
    }
}
