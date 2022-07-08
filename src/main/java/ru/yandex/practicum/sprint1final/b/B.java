package ru.yandex.practicum.sprint1final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * B. Ловкость рук
 * <p>
 * ID посылки на Яндекс.Контесте: 69338555
 * <a href="https://contest.yandex.ru/contest/22450/run-report/69338555/">Яндекс.Контест run-report 69338555</a>
 *
 *
 * <p>
 * Суть решения:
 * – Создаем byte[], где индекс – это цифра на кнопке минус 1, а значение – количество таких кнопок на игровом поле.
 * Точки игнорируются.
 * – Считаем, сколько из элементов встречаются реже или столько же, как k (максимум нажатий одного игрока) * 2.
 * <p>
 * Вычислительная сложность O(2N). Проходимся по каждому элементу игрового поля + проходимся по значениям массива
 * с кол-вом каждой кнопки.
 * Пространственная сложность O(N), где N – кол-во уникальных элементов (кнопок).
 * <p>
 * P.S. для хранения элементов и их кол-ва использую byte, т.к. элементы и их кол-во жестко ограничены условиями.
 */
public final class B {

    private static final int MAX_CHARACTERS = 9;
    private static final int LINES_COUNT = 4;
    private static final int PLAYERS_COUNT = 2;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int maxButtonsForOnePlayer = Integer.parseInt(bufferedReader.readLine());
        final int maxButtons = maxButtonsForOnePlayer * PLAYERS_COUNT;

        // start
        final byte[] charactersAmountArray = new byte[MAX_CHARACTERS];

        for (int i = 0; i < LINES_COUNT; i++) {
            bufferedReader.readLine().chars()
                    .forEach(el -> {
                        if (el != '.') {
                            final int idx = el - '1';
                            charactersAmountArray[idx] = (byte) (charactersAmountArray[idx] + 1);
                        }
                    });
        }

        int result = 0;
        for (final byte el : charactersAmountArray) {
            if (el <= maxButtons && el != 0) result++;
        }
        // end

        System.out.println(result);

        bufferedReader.close();
    }
}
