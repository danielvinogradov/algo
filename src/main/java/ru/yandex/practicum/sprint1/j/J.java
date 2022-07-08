package ru.yandex.practicum.sprint1.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// dividend – делимое
// divisor – делитель

/**
 * J. Факторизация
 */
public final class J {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int input = Integer.parseInt(bufferedReader.readLine());

        final List<Integer> divisors = new ArrayList<>();

        int curN = input;
        final double n2sqrt = Math.sqrt(input) * 2;

        final List<Integer> divisorsToTry = new ArrayList<>();
        divisorsToTry.add(2);
        divisorsToTry.add(3);
        for (int i = 5; i < n2sqrt; i++) {
            if (i % 2 == 0 || i % 3 == 0) continue;
            divisorsToTry.add(i);
        }

        for (final int d : divisorsToTry) {
            while (curN % d == 0) {
                divisors.add(d);
                curN /= d;
            }
        }

        if (curN != 1) {
            divisors.add(curN);
        }

        Collections.sort(divisors);
        final String result = divisors.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
