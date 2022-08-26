package ru.yandex.practicum.sprint4.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * H. Странное сравнение
 */
public final class H {

    public static final String YES_MESSAGE = "YES";
    public static final String NO_MESSAGE = "NO";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final char[] l1 = bufferedReader.readLine().toCharArray();
        final char[] l2 = bufferedReader.readLine().toCharArray();

        if (l1.length != l2.length) {
            System.out.println(NO_MESSAGE);
            return;
        }

        final Map<Character, Character> m = new HashMap<>();
        for (int i = 0; i < l1.length; i++) {
            final char c1 = l1[i];
            final char c2 = l2[i];

            if (m.containsKey(c1)) {
                final char value = m.get(c1);
                if (value != c2) {
                    System.out.println(NO_MESSAGE);
                    return;
                }
            } else {
                if (m.containsValue(c2)) {
                    System.out.println(NO_MESSAGE);
                    return;
                }
                m.put(c1, c2);
            }
        }

        System.out.println(YES_MESSAGE);
    }
}
