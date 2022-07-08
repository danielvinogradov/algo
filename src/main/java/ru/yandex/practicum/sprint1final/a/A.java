package ru.yandex.practicum.sprint1final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * A. Ближайший ноль
 * <p>
 * ID посылки на Яндекс.Контесте: 69336571
 * <a href="https://contest.yandex.ru/contest/22450/run-report/69336571/">Яндекс.Контест run-report 69336571</a>
 *
 * <p>
 * Суть решения:
 * – Проходим по массиву, сохраняя индекс последнего встретившегося нуля.
 * – Расстояние до нуля рассчитываем как дельта между текущим индексом и индексом последнего встретившегося нуля.
 * – Если встречаем ноль, то идем назад (налево) до середины между нулями (разница между текущим индексом и последним
 * индексом нуля деленная на 2 с округлением в меньшую сторону) и переписываем элементы. Т.е. превращаем, например,
 * `0 1 2 3 0` в `0 1 2 1 0`. Если ноль не встречался, то идем до начала.
 * <p>
 * Вычислительная сложность в худшем случае O(2N), когда 0 в конце. Пример входных данных: `1 2 3 4 5 0`.
 * Вычислительная сложность в лучшем случае O(N), когда 0 в начале. Пример входных данных: `0 1 2 3 4 5`.
 * Средняя – где-то по середине, O(1.5N).
 * <p>
 * Пространственная сложность O(N). Используется 1 массив из N элементов.
 */
public final class A {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int elementsCount = Integer.parseInt(bufferedReader.readLine());
        final String elementsRaw = bufferedReader.readLine();
        final StringTokenizer elementsRawTokenizer = new StringTokenizer(elementsRaw);

        // start
        final int[] array = new int[elementsCount];

        int prevZeroIdx = -1;

        for (int i = 0; i < elementsCount; i++) {
            if ("0".equals(elementsRawTokenizer.nextToken())) {
                array[i] = 0;
                final int idxToRewriteTo = prevZeroIdx == -1 ? 0 : i - ((i - prevZeroIdx) / 2);
                for (int j = i - 1; j >= idxToRewriteTo; j--) {
                    array[j] = i - j;
                }
                prevZeroIdx = i;
            } else {
                array[i] = i - prevZeroIdx;
            }
        }
        // end

        final String result = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);

        bufferedReader.close();
    }
}
