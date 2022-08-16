package ru.yandex.practicum.sprint3.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * L. Два велосипеда
 */
public final class L {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(bufferedReader.readLine());
        final int[] moneyData = new int[n];
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            moneyData[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        final int s = Integer.parseInt(bufferedReader.readLine());

        final int[] result = new int[]{
                find(moneyData, s),
                find(moneyData, s * 2)
        };

        System.out.printf("%d %d%n", result[0], result[1]);
    }

    private static int find(final int[] data, final int left, final int right, final int el) {
        if (right <= left) return -1;

        final int midIndex = (left + right) / 2;
        final int midEl = data[midIndex];

        if (midEl >= el) {
            if (midIndex > left && data[midIndex - 1] >= el) return find(data, left, midIndex, el);
            return midIndex + 1;
        }

        return find(data, midIndex + 1, right, el);
    }

    private static int find(final int[] data, final int el) {
        return find(data, 0, data.length, el);
    }
}
