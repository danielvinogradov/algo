package ru.yandex.practicum.sprint1.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * F. Палиндром
 */
public final class F {

    public static final String TRUE_MESSAGE = "True";
    public static final String FALSE_MESSAGE = "False";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String s = bufferedReader.readLine();

        int start = 0; // индекс первого элемента строки
        int end = s.length() - 1; // индекс последнего элемента строки

        while (start < end) {
            if (!Character.isAlphabetic(s.charAt(start))) {
                start++;
                continue;
            }

            if (!Character.isAlphabetic(s.charAt(end))) {
                end--;
                continue;
            }

            final char startChar = Character.toLowerCase(s.charAt(start));
            final char endChar = Character.toLowerCase(s.charAt(end));

            if (startChar != endChar) {
                System.out.println(FALSE_MESSAGE);
                return;
            }

            start++;
            end--;
        }

        System.out.println(TRUE_MESSAGE);
    }
}
