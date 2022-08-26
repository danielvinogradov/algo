package ru.yandex.practicum.sprint4.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * D. Кружки
 */
public final class D {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final Set<String> s = new HashSet<>();
        final List<String> l = new ArrayList<>();

        final int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            final String line = bufferedReader.readLine();
            if (!s.contains(line)) {
                s.add(line);
                l.add(line);
            }
        }

        final String result = String.join("\n", l);
        System.out.println(result);
    }
}
