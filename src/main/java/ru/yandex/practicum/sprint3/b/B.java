package ru.yandex.practicum.sprint3.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * B. Комбинации
 */
public final class B {

    private static final Map<Integer, char[]> map = new HashMap<>();

    static {
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String line = bufferedReader.readLine();
        final int[] buttonsPressed = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();

        final StringBuilder result = new StringBuilder();
        gen(result, "", 0, buttonsPressed);

        System.out.println(result);
    }

    private static void gen(final StringBuilder result, final String prefix, final int n, final int[] buttonsPressed) {
        if (n == buttonsPressed.length) {
            result.append(prefix);
            result.append(' ');
            return;
        }

        final int buttonCode = buttonsPressed[n];
        final char[] letters = map.get(buttonCode);
        for (char letter : letters) {
            gen(result, prefix + letter, n + 1, buttonsPressed);
        }
    }

}
