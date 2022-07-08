package ru.yandex.practicum.sprint0.c;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * C. Скользящее среднее
 */
public final class C {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = Integer.parseInt(scanner.nextLine());
        final double[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        final int k = Integer.parseInt(scanner.nextLine());

        final double[] result = new double[n - k + 1];

        double sum = 0;
        for (int i = 0; i < k; i++) sum += values[i];
        double avg = sum / k;
        result[0] = avg;

        for (int i = 1; i < result.length; i++) {
            sum -= values[i - 1];
            sum += values[i + k - 1];
            avg = sum / k;
            result[i] = avg;
        }

        System.out.println(
                Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        );

        scanner.close();
    }
}
