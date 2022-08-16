package ru.yandex.practicum.sprint3.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * H. Большое число
 *
 * @see <a href="https://ru.stackoverflow.com/a/1308328">Решение на Stack Overflow</a>
 */
public final class H {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final String[] array = new String[n];
        final StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < array.length; i++) array[i] = tokenizer.nextToken();

        Arrays.sort(array, (o1, o2) -> {
            final int ab = Integer.parseInt(o1 + o2);
            final int ba = Integer.parseInt(o2 + o1);
            return ba - ab;
        });

        final String result = String.join("", array);
        System.out.println(result);
    }

}
