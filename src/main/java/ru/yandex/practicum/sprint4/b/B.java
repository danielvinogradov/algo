package ru.yandex.practicum.sprint4.b;

import java.util.HashMap;
import java.util.Map;

public final class B {

    private static final char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static final Map<Long, String> map = new HashMap<>();

    public static void main(String[] args) {
//        genString("");
        System.out.println(h("aaaaaamaaac"));
        System.out.println(h("aaaaabahmda"));

    }

    private static void genString(final String prefix) {
        for (char c : alphabet) {
            final String newString = prefix + c;
            final long hash = h(newString);

            if (prefix.length() > 10) {
                return;
            }

            if (map.containsKey(hash)) {
                System.out.println(map.get(hash));
                System.out.println(newString);
//                return;
                throw new RuntimeException();
            }

            map.put(hash, newString);
            genString(newString);
        }
    }

    private static long h(final String s) {
        final long a = 1000;
        final long m = 123987123;
        final char[] chars = s.toCharArray();

        long h = 0;
        for (char c : chars) {
            h = (h * a + c) % m;
        }

        return h;
    }
}
