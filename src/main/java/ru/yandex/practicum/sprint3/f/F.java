package ru.yandex.practicum.sprint3.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * F. Периметр треугольника
 */
public final class F {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(bufferedReader.readLine());
        final int[] data = new int[n];
        final StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < data.length; i++) data[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(data);

        for (int i = data.length - 1; i > 1; i--) {
            final int a = data[i];
            final int b = data[i - 1];
            final int c = data[i - 2];

            if (a < b + c) {
                System.out.println(a + b + c);
                return;
            }
        }

        bufferedReader.close();
    }
}
