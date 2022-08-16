package ru.yandex.practicum.sprint3.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * D. Печеньки
 */
public final class D {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int childrenAmount = Integer.parseInt(bufferedReader.readLine());
        final int[] greedFactors = new int[childrenAmount];
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < greedFactors.length; i++) greedFactors[i] = Integer.parseInt(stringTokenizer.nextToken());
        final int cookiesAmount = Integer.parseInt(bufferedReader.readLine());
        final int[] cookiesSizes = new int[cookiesAmount];
        final StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < cookiesSizes.length; i++) cookiesSizes[i] = Integer.parseInt(stringTokenizer1.nextToken());

        Arrays.sort(greedFactors);
        Arrays.sort(cookiesSizes);

        int result = 0;

        int cookiePointer = 0;

        for (int i = 0; i < greedFactors.length && cookiePointer < cookiesSizes.length; i++) {
            final int greedFactor = greedFactors[i];
            while (cookiePointer < cookiesSizes.length) {
                final int cookieSize = cookiesSizes[cookiePointer];
                cookiePointer++;
                if (cookieSize >= greedFactor) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
