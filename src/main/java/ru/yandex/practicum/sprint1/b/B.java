package ru.yandex.practicum.sprint1.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * B. Чётные и нечётные числа
 */
public final class B {

    private static final String WIN_MESSAGE = "WIN";
    private static final String FAIL_MESSAGE = "FAIL";

    /**
     * Вариант с множеством.
     */
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

    /**
     * Вариант с циклом.
     */
    public static void main2(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());
        final int c = Integer.parseInt(stringTokenizer.nextToken());
        final int[] elements = new int[]{a, b, c};

        int prev = Math.abs(elements[0]) % 2;
        for (int i = 1; i < elements.length; i++) {
            int current = Math.abs(elements[i]) % 2;
            if (prev != current) {
                System.out.println(FAIL_MESSAGE);
                return;
            }
        }

        System.out.println(WIN_MESSAGE);
    }
}
