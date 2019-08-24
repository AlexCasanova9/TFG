package com.uc3m.foodanalyzerbot.domain.exception;

public class RepositoryException extends RuntimeException {

    private String code = "";
    private String solution = "";

    public RepositoryException(String detailMessage) {
        super(detailMessage);
    }

    public RepositoryException(String code, String detailMessage, String solution) {
        super(detailMessage);
        this.code = code;
        this.solution = solution;
    }

    public String getCode() {
        return code;
    }

    public String getSolution() {
        return solution;
    }

}
