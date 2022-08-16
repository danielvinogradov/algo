package ru.yandex.practicum.sprint3.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G. Гардероб
 */
public final class G {


    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final String l = bufferedReader.readLine();

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        int ptr = 0;
        for (int i = 0; i < n; i++) {
            final char c = l.charAt(ptr);
            ptr += 2;

            if (c == '0') {
                c0++;
            } else if (c == '1') {
                c1++;
            } else if (c == '2') {
                c2++;
            }
        }

        final String result = String.format("%s%s%s",
                "0 ".repeat(c0),
                "1 ".repeat(c1),
                "2 ".repeat(c2)
        );
        System.out.println(result);
    }
}
