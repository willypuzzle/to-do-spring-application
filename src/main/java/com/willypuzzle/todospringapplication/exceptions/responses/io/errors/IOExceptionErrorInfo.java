package com.willypuzzle.todospringapplication.exceptions.responses.io.errors;

import com.willypuzzle.todospringapplication.exceptions.responses.BaseErrorInfo;

public class IOExceptionErrorInfo extends BaseErrorInfo {
    public IOExceptionErrorInfo(Exception ex) {
        super(ex);
    }
}
