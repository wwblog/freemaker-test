package com.xcw.freemarker.demo.core.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Author xcw
 * @Date 2021/1/18 11:26
 * @Description 异常类
 */
@Data
public class AppException extends RuntimeException {
    private ErrorCode errorCode;
    private HttpStatus status;
    private Object[] args;

    public static AppException of(ErrorCode errorCode, HttpStatus status, Object... args) {
        AppException ex = new AppException();
        ex.setErrorCode(errorCode);
        ex.setStatus(status);
        ex.setArgs(args);
        return ex;
    }
}
