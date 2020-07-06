package com.algaworks.algamoney.api.enums;

public enum ExceptionEnum {

    BAD_REQUEST_MESSAGE("Houve um problema na requisição."),
    BAD_REQUEST_INVALID_ARGUMENT_MESSAGE("Os campos não podem ser nullos.");

    private String httpErrors;

    ExceptionEnum(String httpErrors) {
        this.httpErrors = httpErrors;
    }

    public String getHttpErrors() {
        return httpErrors;
    }

    public void setHttpErrors(String httpErrors) {
        this.httpErrors = httpErrors;
    }
}
