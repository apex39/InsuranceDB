package com.domain.exception;

/**
 * Created by mateusz on 28.12.14.
 */
public interface ErrorBundle {
    Exception getException();
    String getErrorMessage();
}