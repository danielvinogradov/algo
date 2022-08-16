package ru.yandex.practicum.sprint3final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B. Эффективная быстрая сортировка
 * <p>
 * -- ПРИНЦИП РАБОТЫ --
 * In-place quick sort.
 * <p>
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Я самостоятельно алгоритм не придумал, поэтому реализовывал из статьи, которую ты скидывал в slack, а именно
 * {@link <a href="https://neerc.ifmo.ru/wiki/index.php?title=%D0%91%D1%8B%D1%81%D1%82%D1%80%D0%B0%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0">
 * ИТМО Быстрая сортировка
 * </a>}.
 * Думается, что переписывать оттуда описание алгоритма избыточно.
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * В лучшем и среднем случаях временная сложность логарифмическая O(N log N). В худшем – квадратичная O(N^2).
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность линейно зависит от максимальной глубины рекурсии. В лучшем и среднем случае
 * пространственная сложность будет O(log N), а в худшем – O(N).
 * <p>
 * P.S. В оценках пространственной и временной сложности оцениваю только сам алгоритм сортировки, без учета
 * необходимости считывать и сохранять данные об участниках и т.д.
 *
 * @see <a href="https://contest.yandex.ru/contest/23815/run-report/69571908/">Run Report. ID 69571908</a>
 */
public final class B {

    /**
     * Для хранения данных участников. Не стал писать геттеры, чтобы не добавлять лишний boilerplate, все равно
     * все поля immutable (примитивы и String) и final.
     */
    private static class Contestant {
        public final String login;
        public final int solvedProblemsAmount;
        public final int penalty;

        public Contestant(final String data) {
            final StringTokenizer tokenizer = new StringTokenizer(data);
            this.login = tokenizer.nextToken();
            this.solvedProblemsAmount = Integer.parseInt(tokenizer.nextToken());
            this.penalty = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final Contestant[] contestants = new Contestant[n];
        for (int i = 0; i < contestants.length; i++) contestants[i] = new Contestant(bufferedReader.readLine());

        quickSort(contestants, 0, contestants.length - 1);
        print(contestants);

        bufferedReader.close();
    }

    /**
     * @param to index inclusive
     */
    private static void quickSort(final Contestant[] array, final int from, final int to) {
        if ((to - from) < 1) return;

        final int q = partition(array, from, to);
        quickSort(array, from, q);
        quickSort(array, q + 1, to);
    }

    /**
     * @param to index inclusive
     */
    private static int partition(final Contestant[] array, final int from, final int to) {
        final Contestant pivot = array[(from + to) / 2];

        int leftIndex = from;
        int rightIndex = to;

        while (leftIndex <= rightIndex) {
            while (isOrderCorrect(array[leftIndex], pivot)) leftIndex++;
            while (isOrderCorrect(pivot, array[rightIndex])) rightIndex--;
            if (leftIndex >= rightIndex) break;

            swap(array, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }

        return rightIndex;
    }

    /**
     * Проверяет, что элемент c1 "меньше" элемента c2.
     */
    private static boolean isOrderCorrect(final Contestant c1, final Contestant c2) {
        if (c1.solvedProblemsAmount != c2.solvedProblemsAmount) return c1.solvedProblemsAmount > c2.solvedProblemsAmount;
        if (c1.penalty != c2.penalty) return c1.penalty < c2.penalty;
        return c1.login.compareTo(c2.login) < 0;
    }

    private static void swap(final Contestant[] array, final int firstIndex, final int secondIndex) {
        final Contestant temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static void print(final Contestant[] array) {
        final StringBuilder sb = new StringBuilder();
        for (final Contestant contestant : array) {
            sb.append(contestant.login);
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
