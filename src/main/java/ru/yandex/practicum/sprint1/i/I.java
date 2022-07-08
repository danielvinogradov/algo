package ru.yandex.practicum.sprint1.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * I. Степень четырёх
 */
public final class I {

    public static final String TRUE_MESSAGE = "True";
    public static final String FALSE_MESSAGE = "False";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        while (n != 1) {
            if (n % 4 != 0) {
                System.out.println(FALSE_MESSAGE);
                return;
            }
            n /= 4;
        }

        System.out.println(TRUE_MESSAGE);
    }
}
