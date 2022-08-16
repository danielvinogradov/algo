package ru.yandex.practicum.sprint3final.a;

/**
 * A. Поиск в сломанном массиве
 * <p>
 * -- ПРИНЦИП РАБОТЫ --
 * Нерекурсивный бинарный поиск с измененной проверкой.
 * <p>
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Хотя сам массив не отсортирован по возрастанию, участки, на которые мы разделяем массив при бинарном поиске
 * могут быть отсортированными. Так как все элементы уникальные, то отдельно взятый участок будет отсортированным,
 * если его крайний левый элемент строго меньше крайнего правого. Если попадаем на отсортированный участок, то
 * если искомое значение находится в диапазоне между крайним левым и крайним правым значением, значит имеет смысл
 * продолжить поиск в только на этом участке.
 * <p>
 * Если участок поиска не отсортирован, мы все равно можем сделать вывод о том, может ли искомое значение
 * принадлежать промежутку: искомое значение должно быть либо больше крайнего правого, либо меньше крайнего левого.
 * Точнее, в этом случае мы можем сделать вывод о том, что значения может точно не быть. Например, возьмем
 * последовательность [10, ..., 2] и искомый элемент 3. Можем сделать однозначный вывод, что искомого элемента в
 * последовательности нет. Т.к. "вправо" последовательность может только возрастать, а "влево" только убывать.
 * <p>
 * Элементы уникальные, а "неотсортированный" участок при разделении массива на части может быть только 1 (или 0), а
 * значит, можем сделать однозначный вывод, в какой части, левой или правой, продолжать поиск и продолжать ли его
 * в принципе.
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * В среднем и худшем случае временная сложность логарифмическая O(log N). В лучшем случае (например, последовательность
 * из одного элемента) временная сложность будет константной O(1).
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Константная O(1).
 *
 * @see <a href="https://contest.yandex.ru/contest/23815/run-report/69572886/">Run Report. ID 69572886</a>
 */
public final class Solution {

    private static final int NOT_FOUND = -1;

    public static int brokenSearch(final int[] arr, final int k) {
        int left = 0;
        int mid = arr.length / 2;
        int right = arr.length - 1;

        while (left <= right) {
            if (left == right) return arr[left] == k ? left : NOT_FOUND;
            else if (arr[mid] == k) return mid;
            else if (isInRange(k, arr[left], arr[mid])) right = mid - 1;
            else if (isInRange(k, arr[mid], arr[right])) left = mid + 1;
            else return NOT_FOUND;
            mid = (left + right + 1) / 2;
        }

        return NOT_FOUND;
    }

    private static boolean isInRange(final int k, final int leftElement, final int rightElement) {
        return leftElement < rightElement ? (leftElement <= k && k <= rightElement) : (leftElement <= k || k <= rightElement);
    }

}