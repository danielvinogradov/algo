package ru.yandex.practicum.sprint2.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * A. Мониторинг
 */
public final class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int rowsAmount = Integer.parseInt(bufferedReader.readLine());
        final int columnsAmount = Integer.parseInt(bufferedReader.readLine());

        final int[][] matrix = new int[columnsAmount][rowsAmount];

        for (int i = 0; i < rowsAmount; i++) {
            final String row = bufferedReader.readLine();
            final StringTokenizer stringTokenizer = new StringTokenizer(row);

            for (int j = 0; j < columnsAmount; j++) {
                matrix[j][i] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (final int[] row : matrix) {
            stringBuilder.append(Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}
