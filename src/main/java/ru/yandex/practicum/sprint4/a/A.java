package ru.yandex.practicum.sprint4.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A. Полиномиальный хеш
 */
public final class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int a = Integer.parseInt(bufferedReader.readLine());
        final int m = Integer.parseInt(bufferedReader.readLine());
        final char[] s = bufferedReader.readLine().toCharArray();

        long h = 0;
        for (char c : s) {
            h = (h * a + c) % m;
        }

        System.out.println(h);
    }
}
