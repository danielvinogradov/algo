package ru.yandex.practicum.sprint1.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * D. Хаотичность погоды
 */
public final class D {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        final int[] data = new int[n + 2]; // создаем массив для данных на 2 элемента больше
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < n + 1; i++) {
            data[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        data[0] = data[1] - 1; // устанавливаем первый элемент так, чтобы он не влиял на результат (был меньше полученного первого)
        data[data.length - 1] = data[data.length - 2] - 1; // то же самое с последним

        int counter = 0;
        // проходимся по данным, которые мы получили, т.е. не затрагивая новые элементы
        // новые элементы нужны для сравнения, чтобы не обрабатывать отдельно случаи с отсутствующими в начале
        // и в конце элементами
        for (int i = 1; i < data.length - 1; i++) {
            final int el = data[i];

            final int prev = data[i - 1];
            final int next = data[i + 1];

            if (el > prev && el > next) counter++;
        }

        System.out.println(counter);
    }
}
