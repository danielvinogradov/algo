package ru.yandex.practicum.sprint2.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * L. Фибоначчи по модулю
 */
public final class L {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final String line = bufferedReader.readLine();
        final StringTokenizer stringTokenizer = new StringTokenizer(line);

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        final long result = f(n, k);

        System.out.println(result);
    }

    private static long f(final int n, final int k) {
        long result = 1;
        long max = (long) Math.pow(10, k);

        if (n > 1) result++;
        if (n > 2) result++;

        long prev1 = 1;
        long prev2 = 1;

        for (int i = 3; i < n; i++) {
            final long num = (prev1 + prev2) % max;
            prev1 = prev2;
            prev2 = num;
            result += prev2;
        }

        return result % max;
    }
}
