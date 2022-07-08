package ru.yandex.practicum.sprint1.k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class K {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int n = Integer.parseInt(bufferedReader.readLine()); // кол-во чисел в x (не используется)
        final int x = Integer.parseInt(bufferedReader.readLine().replaceAll(" ", ""));
        final int k = Integer.parseInt(bufferedReader.readLine());

        final int sum = x + k;

        final String result = String.join(" ", String.valueOf(sum).split(""));

        System.out.println(result);
    }
}
