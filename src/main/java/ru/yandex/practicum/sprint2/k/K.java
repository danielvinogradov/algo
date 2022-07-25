package ru.yandex.practicum.sprint2.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * K. Рекурсивные числа Фибоначчи
 */
public final class K {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(f(n));
    }

    private static int f(final int n) {
        if (n == 0 || n == 1) return 1;
        return f(n - 2) + f(n - 1);
    }
}
