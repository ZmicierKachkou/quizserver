package by.bsu.zmicier.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class NotNullUtils {
    private NotNullUtils() {}

    public static <T> List<T> getList(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <K, V> Map<K, V> getMap(Map<K, V> map) {
        return map == null ? Collections.emptyMap() : map;
    }

    public static String getString(String string) {
        return string == null ? "" : string;
    }
}
