package com.xcw.freemarker.demo.core.error;


public enum CommonErrorCode implements ErrorCode {
	
	NON_AUTHORITATIVE_INFORMATION("203", "Non-Authoritative Information {0}"),
	
    /**
     * 错误请求
     */
    INVALID_REQUEST("400", "Invalid request, for reason: {0}"),
    
    /**
     * 错误返回
     */
    INVALID_RESPONSE("500", "Invalid response, for reason: {0}"),
    /**
     * 参数验证错误
     */
    INVALID_ARGUMENT("400", "Validation failed for argument [{0}], hints: {1}"),
    
    /**
     * 反序列化错误
     */
    INVALID_DESERIALIZE("500","Invalid Format parse {0} "),
    
    /**
     * 未找到资源
     */
    NOT_FOUND("404","Resource {0} not found."),
    
    /**
     * 未知错误
     */
    UNKNOWN_ERROR("UnknownError", "Unknown server internal error."),
    
    /**
     * 默认提示
     */
    NATIVE_RESPONSE("500", "{0}"),
	
	/**
     * 默认提示
     */
    NATIVE_REQUEST("500", "{0}");

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Customized error code
     */
    private String code;
    /**
     * Error message details
     */
    private String message;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
