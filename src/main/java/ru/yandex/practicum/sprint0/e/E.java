package ru.yandex.practicum.sprint0.e;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * E. Две фишки - 2
 *
 * Решение через дополнительную структуру данных (дополнительная память).
 */
public final class E {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int n = Integer.parseInt(scanner.nextLine());
        final int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int k = Integer.parseInt(scanner.nextLine());

        final Set<Integer> set = new HashSet<>();
        for (int el : values) {
            final int y = k - el;
            if (set.contains(y)) {
                System.out.printf("%d %d", el, y);
                return;
            } else set.add(el);
        }

        System.out.println("None");

        scanner.close();
    }
}
