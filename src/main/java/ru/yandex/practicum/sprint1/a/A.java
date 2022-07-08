package ru.yandex.practicum.sprint1.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A. Значения функции
 */
public final class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int x = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());
        final int c = Integer.parseInt(stringTokenizer.nextToken());

        final int y = (a * x * x) + (b * x) + c;

        System.out.println(y);
    }
}
