package ru.yandex.practicum.sprint0.a;

import java.util.Scanner;

/**
 * A. A+B
 */
public final class A {

    private static int getSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(getSum(a, b));
        scanner.close();
    }
}
