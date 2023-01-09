package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import io.micronaut.http.util.HttpHeadersUtil;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.micronaut.http.annotation.Filter.MATCH_ALL_PATTERN;

@Filter(MATCH_ALL_PATTERN)
public class LoggingFilter implements HttpServerFilter {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        HttpHeadersUtil.trace(LOG, request.getHeaders());
        return chain.proceed(request);
    }
}
