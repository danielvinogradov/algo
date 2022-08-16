package ru.yandex.practicum.sprint3.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A. Генератор скобок
 */
public final class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        gen(n * 2 - 1, n - 1, n, "(");
    }

    private static void gen(final int n, final int left, final int right, final String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }

        if (left > 0) {
            gen(n - 1, left - 1, right, prefix + "(");
        }

        if (right > 0 && left < right) {
            gen(n - 1, left, right - 1, prefix + ")");
        }
    }
}
