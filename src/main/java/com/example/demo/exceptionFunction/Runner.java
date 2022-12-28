package com.example.demo.exceptionFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class Runner {
    private static final Map<Integer, Function<String, Exception>> ERROR_CODE_EXCEPTION_MAP;

    static {
        ERROR_CODE_EXCEPTION_MAP = new HashMap<>();
        ERROR_CODE_EXCEPTION_MAP.put(403, IllegalAccessException::new);
        ERROR_CODE_EXCEPTION_MAP.put(404, ClassNotFoundException::new);
    }

    public static void main(String[] args) {
        var errMsg = "Error Message";
        Exception exception = getException(402, errMsg);
        System.out.println(exception);
    }

    private static Exception getException(int statusCode, final String errMsg) {
        return Optional.ofNullable(ERROR_CODE_EXCEPTION_MAP.get(statusCode))
                .map(exceptionFunction -> exceptionFunction.apply(errMsg))
                .orElseGet(() -> new RuntimeException(errMsg));

//        Function<String, Exception> exceptionFunction = ERROR_CODE_EXCEPTION_MAP.getOrDefault(statusCode, RuntimeException::new);
//        return exceptionFunction.apply(errMsg);
    }
}
