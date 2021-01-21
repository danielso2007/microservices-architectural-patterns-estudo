package com.acme.ecom.product.commons.lang;

public class ProductConflictException extends RuntimeException {

    private static final long serialVersionUID = -4734226815637107601L;

    public ProductConflictException() {
        super();
    }

    public ProductConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ProductConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductConflictException(String message) {
        super(message);
    }

    public ProductConflictException(Throwable cause) {
        super(cause);
    }

}
