package ru.yandex.practicum.sprint1.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * G. Работа из дома
 */
public final class G {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int input = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder sb = new StringBuilder();

        int n = input;
        int remainder;
        while (n > 0) {
            int nextN = n / 2;
            remainder = n - nextN * 2; // чтобы не использовать %
            n = nextN;

            sb.append(remainder);
        }

        // удаляем все нули с начала строки
        final String result = sb.reverse().toString().replace("^0", "");

        System.out.println(result);
    }
}
