package ru.yandex.practicum.sprint4.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class E {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final String line = bufferedReader.readLine();
        final char[] chars = line.toCharArray();

        int max = 0;
        int counter = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            final int current = chars[i];

            if (!map.containsKey(current)) {
                counter++;
                if (counter > max) max = counter;
                map.put(current, i);
                continue;
            }

            i = map.get(current);
            counter = 0;
            map.clear();

        }

        System.out.println(max);

    }
}
