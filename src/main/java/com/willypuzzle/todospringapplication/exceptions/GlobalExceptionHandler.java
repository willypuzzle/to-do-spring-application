package com.willypuzzle.todospringapplication.exceptions;

import com.willypuzzle.todospringapplication.exceptions.responses.connection.errors.JDBCErrorInfo;
import com.willypuzzle.todospringapplication.exceptions.responses.io.errors.IOExceptionErrorInfo;
import com.willypuzzle.todospringapplication.exceptions.responses.routes.methods.MethodNotSupportedErrorInfo;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(JDBCConnectionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JDBCErrorInfo handleConnectionError(HttpServletRequest request, Exception ex){
        return new JDBCErrorInfo(ex);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        pageNotFoundLogger.warn(ex.getMessage());
        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        if (!CollectionUtils.isEmpty(supportedMethods)) {
            headers.setAllow(supportedMethods);
        }

        return this.handleExceptionInternal(ex, new MethodNotSupportedErrorInfo(ex), headers, status, request);
    }

    @ResponseBody
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public IOExceptionErrorInfo handleIOException(HttpServletRequest request, Exception ex){
        return new IOExceptionErrorInfo(ex);
    }
}
