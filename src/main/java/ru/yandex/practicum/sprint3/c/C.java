package ru.yandex.practicum.sprint3.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * C. Подпоследовательность
 */
public final class C {

    private static final String TRUE_MESSAGE = "True";
    private static final String FALSE_MESSAGE = "False";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final String sequence = bufferedReader.readLine();
        final String input = bufferedReader.readLine();

        int inputPointerIndex = 0;
        boolean elPresent = true;
        for (int i = 0; i < sequence.length(); i++) {

            if (!elPresent || (inputPointerIndex >= input.length())) {
                System.out.println(FALSE_MESSAGE);
                return;
            }

            final char elToFind = sequence.charAt(i);

            elPresent = false;
            for (int j = inputPointerIndex; j < input.length(); j++) {
                final char inputPointerEl = input.charAt(j);
                if (inputPointerEl == elToFind) {
                    inputPointerIndex = j + 1;
                    elPresent = true;
                    break;
                }
            }
        }

        final String result = elPresent ? TRUE_MESSAGE : FALSE_MESSAGE;
        System.out.println(result);
    }
}
