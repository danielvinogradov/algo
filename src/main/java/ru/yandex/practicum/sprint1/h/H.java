package ru.yandex.practicum.sprint1.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * H. Двоичная система
 */
public final class H {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int[] number1 = inputStringToIntArray(bufferedReader.readLine());
        final int[] number2 = inputStringToIntArray(bufferedReader.readLine());

        final StringBuilder sb = new StringBuilder();

        int pointer1 = number1.length - 1;
        int pointer2 = number2.length - 1;
        int remainder = 0; // что перенести в следующий разряд

        while (pointer1 >= 0 || pointer2 >= 0 || remainder != 0) {
            final int a = getOrZero(number1, pointer1);
            final int b = getOrZero(number2, pointer2);
            final int c = remainder;

            final int sum = a + b + c;

            sb.append(sum % 2);
            remainder = sum / 2;

            pointer1--;
            pointer2--;
        }

        final String result = sb.reverse().toString();
        System.out.println(result);

        bufferedReader.close();
    }

    private static int getOrZero(final int[] array, final int index) {
        if (index < array.length && index >= 0) {
            return array[index];
        }
        return 0;
    }

    private static int[] inputStringToIntArray(final String s) {
        final int length = s.length();
        final int[] array = new int[length];
        for (int i = 0; i < length; i++) array[i] = Character.digit(s.charAt(i), 2);
        return array;
    }
}
