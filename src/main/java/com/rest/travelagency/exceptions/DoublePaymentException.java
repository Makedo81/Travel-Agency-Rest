package com.rest.travelagency.exceptions;

public class DoublePaymentException extends Exception {
    public DoublePaymentException(final String message) {
        super(message);
    }
}
