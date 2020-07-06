package com.algaworks.algamoney.api.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ResponseError implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("error")
    private String error;

    public ResponseError(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
