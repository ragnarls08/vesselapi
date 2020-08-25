package dev.raggi.helpers;

public final class StringHelpers {
    private StringHelpers() {}

    public static boolean IsNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

}
