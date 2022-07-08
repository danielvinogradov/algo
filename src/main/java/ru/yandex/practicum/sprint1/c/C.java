package ru.yandex.practicum.sprint1.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * C. Соседи
 */
public final class C {

    private static final List<Integer> neighbours = new ArrayList<>();

    private static void addNeighbour(final String neighbour) {
        neighbours.add(Integer.parseInt(neighbour));
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // все равно придется прочитать все строки, чтобы дойти до ввода координат
        final List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        if (lines.get(lines.size() - 1).isBlank()) { // если есть пустая строка на конце, то убираем ее
            lines.remove(lines.size() - 1);
        }

        final int rows = Integer.parseInt(lines.get(0)); // кол-во рядов
        final int cols = Integer.parseInt(lines.get(1)); // кол-во колонок

        final int LINES_OFFSET = 2; // это индекс первой строки матрицы в lines
        final int x = Integer.parseInt(lines.get(lines.size() - 2)); // ряд
        final int y = Integer.parseInt(lines.get(lines.size() - 1)); // колонка

        if (x > 0) { // значит верхний ряд существует
            final String line = lines.get(LINES_OFFSET + x - 1);
            final StringTokenizer stringTokenizer = new StringTokenizer(line);
            for (int i = 0; i < y; i++) stringTokenizer.nextToken(); // пропускаем ненужные элементы
            addNeighbour(stringTokenizer.nextToken());// добавляем элемент, который над координатой
        }

        if (x + 1 < rows) { // значит верхний ряд существует
            final String line = lines.get(LINES_OFFSET + x + 1);
            final StringTokenizer stringTokenizer = new StringTokenizer(line);
            for (int i = 0; i < y; i++) stringTokenizer.nextToken(); // пропускаем ненужные элементы
            addNeighbour(stringTokenizer.nextToken()); // добавляем элемент, который под координатой
        }

        {
            final String line = lines.get(LINES_OFFSET + x);
            final StringTokenizer stringTokenizer = new StringTokenizer(line);

            final boolean leftNeighbourExists = y > 0;
            final boolean rightNeighbourExists = y + 1 < cols;

            // пропускаем элементы слева до left neighbour
            // или до координаты, если left neighbour отсутствует
            for (int i = 0; i < y - 1; i++) stringTokenizer.nextToken();
            if (leftNeighbourExists) {
                addNeighbour(stringTokenizer.nextToken());
            }
            if (rightNeighbourExists) {
                stringTokenizer.nextToken(); // пропускаем саму координату
                addNeighbour(stringTokenizer.nextToken()); // и добавляем right neighbour
            }
        }

        neighbours.sort(Comparator.naturalOrder());
        System.out.println(
                neighbours.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );

        bufferedReader.close();
    }
}
