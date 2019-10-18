package by.bsu.zmicier.utils;

import java.util.Collections;
import java.util.List;

public final class NotNullUtils {
    private NotNullUtils() {}

    public static <T> List<T> getList(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static String getString(String string) {
        return string == null ? "" : string;
    }
}
