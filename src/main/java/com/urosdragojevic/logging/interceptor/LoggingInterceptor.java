package com.urosdragojevic.logging.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.Arrays;

@Logged
@Interceptor
@Slf4j
public class LoggingInterceptor {
    @AroundInvoke
    Object logInvocation(InvocationContext context) throws Exception {
        String clazz = context.getMethod().getDeclaringClass().getName();
        String method = context.getMethod().getName();
        int paramCount = context.getMethod().getParameterCount();
        Object[] parameter = context.getParameters();
        log.info(MessageFormat.format("Class: <{0}> Method: <{1}> Message: {2}", clazz, method, "Fetching posts"));
        if (parameter.length > 0) {
            log.info(MessageFormat.format("Method: <{0}> called with {1} parameter(s): {2}", method, paramCount, Arrays.toString(parameter)));
        }
        try {
            Object ret = context.proceed();
            log.info(MessageFormat.format("Class: <{0}> Method: <{1}> Message: {2}", clazz, method, ret));
            return ret;
        } catch (Exception exception) {
            log.error(MessageFormat.format("Class: <{0}> Method: <{1}> Message: {2}", clazz, method, exception));
            throw exception;
        }
    }
}
