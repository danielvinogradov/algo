package ru.yandex.practicum.sprint0.d;

import java.util.Arrays;
import java.util.Scanner;

/**
 * D. Две фишки
 */
public final class D {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = Integer.parseInt(scanner.nextLine());
        final int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int k = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (i == j) continue;
                if (values[i] + values[j] == k) {
                    System.out.printf("%d %d", values[i], values[j]);
                    return;
                }
            }
        }

        System.out.println("None");

        scanner.close();
    }
}
