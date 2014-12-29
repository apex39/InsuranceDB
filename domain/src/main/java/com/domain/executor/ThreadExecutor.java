package com.domain.executor;

/**
 * Created by mateusz on 28.12.14.
 */
public interface ThreadExecutor {
    void execute(Runnable runnable);
}
