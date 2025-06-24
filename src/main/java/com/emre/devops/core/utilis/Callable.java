package com.emre.devops.core.utilis;

@FunctionalInterface
public interface Callable<T, R> {
    T call(R r);
}
