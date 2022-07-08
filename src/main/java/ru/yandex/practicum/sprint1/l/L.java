package ru.yandex.practicum.sprint1.l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * L. Лишняя буква
 */
public final class L {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final String s1 = bufferedReader.readLine();
        final String s2 = bufferedReader.readLine();

        final long stringCharSum1 = s1.chars().sum();
        final long stringCharSum2 = s2.chars().sum();

        final char missingChar = (char) (stringCharSum2 - stringCharSum1);

        System.out.println(missingChar);
    }
}
