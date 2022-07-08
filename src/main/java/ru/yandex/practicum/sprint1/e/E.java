package ru.yandex.practicum.sprint1.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * E. Самое длинное слово
 */
public final class E {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine(); // пропускаем первую строку с кол-вом символов

        final String s = bufferedReader.readLine().trim();

        final Pattern pattern = Pattern.compile("\\w+");
        final Matcher matcher = pattern.matcher(s);

        int maxLength = 0;
        String maxLengthWord = null;
        while (matcher.find()) {
            final String word = matcher.group();
            final int length = word.length();

            if (length > maxLength) {
                maxLength = length;
                maxLengthWord = word;
            }
        }

        System.out.println(maxLengthWord);
        System.out.println(maxLength);
    }
}
