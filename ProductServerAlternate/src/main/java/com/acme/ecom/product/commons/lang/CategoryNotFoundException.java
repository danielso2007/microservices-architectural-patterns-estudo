package com.acme.ecom.product.commons.lang;

public class CategoryNotFoundException extends Exception {

    private static final long serialVersionUID = 2596358000793420126L;

    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(Throwable cause) {
        super(cause);
    }

}
