package ru.yandex.practicum.sprint2.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * H. Скобочная последовательность
 */
public final class H {

    public static final String IS_VALID_MESSAGE = "True";
    public static final String IS_NOT_VALID_MESSAGE = "False";

    private static final Map<Character, Character> bracketsMap = new HashMap<>();

    static {
        bracketsMap.put('(', ')');
        bracketsMap.put('{', '}');
        bracketsMap.put('[', ']');
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String input = bufferedReader.readLine();
        final char[] chars = input.toCharArray();

        final List<Character> stack = new LinkedList<>();

        for (final char ch : chars) {
            if (bracketsMap.containsKey(ch)) {
                stack.add(ch);
                continue;
            }

            if (stack.isEmpty()) {
                System.out.println(IS_NOT_VALID_MESSAGE);
                return;
            }

            final int lastElIndex = stack.size() - 1;
            final char prev = stack.get(lastElIndex);
            if (bracketsMap.get(prev) == ch) {
                stack.remove(lastElIndex);
            } else {
                System.out.println(IS_NOT_VALID_MESSAGE);
                return;
            }
        }

        System.out.println(stack.isEmpty() ? IS_VALID_MESSAGE : IS_NOT_VALID_MESSAGE);
    }

}
