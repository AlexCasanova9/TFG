package com.uc3m.foodanalyzerbot.domain.interactor;

public interface InteractorCallback<T> {

    void success(T data);

    void fail(Throwable t);
}
