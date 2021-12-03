package com.example.jpaHibernate.config.exception;

import lombok.Getter;

import java.util.Date;


@Getter
public class CustomError
{

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getHttpCode() {
        return HttpCode;
    }

    public void setHttpCode(int httpCode) {
        HttpCode = httpCode;
    }

    private Date timeStamp;
    private String mensaje;
    private int HttpCode;

    public CustomError(Date timeStamp, String mensaje, int HttpCode){
        super();
        this.timeStamp = timeStamp;
        this.mensaje = mensaje;
        this.HttpCode = HttpCode;
    }









}
