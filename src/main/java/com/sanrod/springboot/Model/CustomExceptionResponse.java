package com.sanrod.springboot.Model;

import java.util.Date;

public class CustomExceptionResponse {

    private Date date;
    private String message;
    private String details;

    public CustomExceptionResponse() {
    }

    public CustomExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
