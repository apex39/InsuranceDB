package com.data;

import com.domain.exception.ErrorBundle;

/**
 * Created by mateusz on 04.01.15.
 */
public class DataErrorBundle implements ErrorBundle{
    Exception exception;

    public DataErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return exception.getMessage();
    }
}
