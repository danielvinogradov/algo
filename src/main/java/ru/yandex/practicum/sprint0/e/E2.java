package ru.yandex.practicum.sprint0.e;

import java.util.Arrays;
import java.util.Scanner;

/**
 * E.Две фишки - 2
 *
 * Решение через 2 указателя.
 */
public class E2 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = Integer.parseInt(scanner.nextLine());
        final int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int k = Integer.parseInt(scanner.nextLine());

        int left = 0;
        int right = n - 1;

        while (left < right) {
            final int v1 = values[left];
            final int v2 = values[right];
            final int sum = v1 + v2;
            if (sum == k) {
                System.out.printf("%d %d", v1, v2);
                return;
            }
            if (sum < k) left++;
            if (sum > k) right--;
        }

        System.out.println("None");

        scanner.close();
    }
}
