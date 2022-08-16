package ru.yandex.practicum.sprint3.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * J. Пузырёк
 */
public final class J {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final int[] array = new int[n];
        final StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < array.length; i++) array[i] = Integer.parseInt(tokenizer.nextToken());
        sort(array);
    }

    private static void sort(int[] array) {
        int j = array.length - 1;

        boolean changed = true;
        while (changed) {
            changed = false;

            for (int i = 0; i < j; i++) {
                final int firstIndex = i;
                final int secondIndex = i + 1;

                final int firstEl = array[firstIndex];
                final int secondEl = array[secondIndex];

                if (firstEl > secondEl) {
                    swap(array, firstIndex, secondIndex);
                    changed = true;
                }
            }

            if (changed) print(array);

            j--;
        }

        if (j == array.length - 2) {
            print(array);
        }
    }

    private static void swap(int[] array, final int firstIndex, final int secondIndex) {
        final int firstElValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = firstElValue;
    }

    private static void print(final int[] array) {
        System.out.println(
                Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        );
    }
}
