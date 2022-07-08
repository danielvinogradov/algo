package ru.yandex.practicum.sprint0.b;

import java.util.Scanner;

/**
 * B. Застёжка-молния
 */
public final class B {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int numberOfElements = scanner.nextInt();

        final int[] result = new int[numberOfElements * 2];

        for (int i = 0; i < numberOfElements; i++) {
            final int el = scanner.nextInt();
            result[i * 2] = el;
        }

        for (int i = 0; i < numberOfElements; i++) {
            final int el = scanner.nextInt();
            result[i * 2 + 1] = el;
        }

        for (int el : result) {
            System.out.printf("%d ", el);
        }

        scanner.close();
    }
}
