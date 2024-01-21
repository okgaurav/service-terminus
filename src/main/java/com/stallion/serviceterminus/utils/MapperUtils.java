package com.stallion.serviceterminus.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperUtils {
    public static boolean isNotNull(Object one) {
        return one != null;
    }
    public static <T, R> R mapIfNotNull(Function<T, R> mapperFn, T arg) {
        if (arg == null) {
            return null;
        } else {
            return mapperFn.apply(arg);
        }
    }
    public static <T> T checkNull(T arg) {
        if (arg == null)
            return null;
        else
            return arg;
    }

    public static <T, R> List<R> mapListIfNotNull(Function<T, R> mapper, List<T> list) {
        if (list == null) {
            return null;
        }
        return list.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}