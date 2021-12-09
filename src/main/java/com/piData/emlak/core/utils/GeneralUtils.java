package com.piData.emlak.core.utils;

import java.util.Collection;

public class GeneralUtils {
    public static <T> boolean valueNullOrEmpty(final T value) {
        return value == null ||
                (value instanceof String && ((String) ((String) value).trim()).isEmpty()) ||
                (value instanceof Collection && ((Collection<?>) value).isEmpty()) ||
                (value instanceof byte[] && ((byte[]) value).length == 0);
    }

}
