package com.jeecourse.account.service;

public class AccountServiceException extends RuntimeException {
    private static final long serialVersionUID = -8334988626147289624L;

    private String message;

    public AccountServiceException(String message) {
        super(message);
        this.message = message;
    }

    public AccountServiceException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
