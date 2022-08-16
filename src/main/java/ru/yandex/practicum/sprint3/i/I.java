package ru.yandex.practicum.sprint3.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * I. Любители конференций
 */
public final class I {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        final Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final Integer id = Integer.valueOf(tokenizer.nextToken());
            m.computeIfPresent(id, (key, value) -> value + 1);
            m.putIfAbsent(id, 1);
        }

        final int k = Integer.parseInt(bufferedReader.readLine());

        final String result = m.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed().thenComparing(Entry::getKey))
                .limit(k)
                .map(Map.Entry<Integer, Integer>::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
