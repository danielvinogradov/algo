package ru.yandex.practicum.sprint4.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * G. Соревнование
 */
public final class G {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final String line = bufferedReader.readLine();
        final StringTokenizer tokenizer = new StringTokenizer(line);

        final Map<Integer, Integer> left = new HashMap<>();
        final Map<Integer, Integer> right = new HashMap<>();
        int score = 0;

        left.put(0, -1);
        right.put(0, -1);

        for (int i = 0; i < n; i++) {
            final int v = Integer.parseInt(tokenizer.nextToken());
            if (v == 0) score--;
            if (v == 1) score++;


            if (!left.containsKey(score)) {
                left.put(score, i);
            }

            right.put(score, i);
        }

        int max = -1;
        for (final int leftKey : left.keySet()) {
            final int leftValue = left.get(leftKey);
            final int rightValue = right.get(leftKey);
            final int delta = rightValue - leftValue;
            if (max < delta) max = delta;
        }

        System.out.println(max == -1 ? 0 : max);

    }
}
