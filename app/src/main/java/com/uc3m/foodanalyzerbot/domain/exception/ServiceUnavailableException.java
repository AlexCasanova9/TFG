package com.uc3m.foodanalyzerbot.domain.exception;


public class ServiceUnavailableException extends RepositoryException {

    public ServiceUnavailableException() {
        super("Service not available");
    }

    public ServiceUnavailableException(String detailMessage) {
        super(detailMessage);
    }
}
