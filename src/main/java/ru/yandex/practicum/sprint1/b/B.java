package ru.yandex.practicum.sprint1.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * B. Чётные и нечётные числа
 *
 * Решение через множество.
 */
public final class B {

    private static final String WIN_MESSAGE = "WIN";
    private static final String FAIL_MESSAGE = "FAIL";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());
        final int c = Integer.parseInt(stringTokenizer.nextToken());
        final int[] elements = new int[]{a, b, c};

        final Set<Integer> integerSet = new HashSet<>();
        for (final int el : elements) {
            integerSet.add(Math.abs(el % 2));
        }

        final String message;
        if (integerSet.size() == 1) {
            message = WIN_MESSAGE;
        } else {
            message = FAIL_MESSAGE;
        }

        System.out.println(message);
    }
}
