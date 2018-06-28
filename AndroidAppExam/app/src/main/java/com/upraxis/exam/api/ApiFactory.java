package com.upraxis.exam.api;

import io.reactivex.Single;

public interface ApiFactory {

    /**
     * Create an implementation of an API class.
     */
    <T> Single<T> create(Class<T> apiClass);

    <T> Single<T> createWithApiKeys(Class<T> apiClass);

    /**
     * Pretty much just like {@link #create(Class)}, except without the standard HTTP headers.
     */
    <T> Single<T> createWithoutCookies(Class<T> apiClass);
}
