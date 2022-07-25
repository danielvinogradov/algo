package ru.yandex.practicum.sprint2final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * B. Калькулятор
 * <p>
 * -- ПРИНЦИП РАБОТЫ --
 * Полностью совпадает с описанным в задаче:
 * – Считываем элемент.
 * – Если это число, то добавляем в стек.
 * – Если это оператор, то выполняем операцию над последними двумя элементами в стеке и кладем результат
 * обратно на стек.
 * – Когда данные закончились, возвращаем последний элемент на стеке.
 * <p>
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Так как стек хранит данные в порядке добавления, то получение последних двух элементов стека всегда вернет
 * последние два элемента последовательности или вычисленные значения. Корректность последовательности (входных данных)
 * гарантирована по условию задачи.
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Временная сложность линейно зависит от кол-ва элементов, т.е. O(N), где N – кол-во элементов.
 * <p>
 * Временная сложность также может незначительно колебаться в зависимости от кол-ва операторов (чем больше операторов,
 * тем больше вычислений) и необходимости расширения стека.
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Дополнительное место в памяти занимает только стек. Если входные данные сбалансированы, то есть дельта между
 * кол-вом операторов и операндов небольшая (~меньше 16), и они идут упорядоченно, то есть не существует длинных
 * последовательностей из чисел без операторов, например, `2 4 5 3 1 ... 1 3 * 2 +`, то пространственная
 * сложность константна, т.е. O(1), т.к. массив внутри ArrayDeque никогда не увеличится (16 элементов будет хватать
 * всегда, даже при больших входных данных).
 * <p>
 * В противном случае пространственная сложность может очень сильно зависеть от входных данных и их представления вплоть
 * до O(N), например, если во входных данных не будет операторов вообще (тогда придется хранить все элементы на стеке).
 * Или если все операторы будут идти после операндов, в таком случае пространственная сложность также будет линейная O(N),
 * где N – входные данные.
 *
 * @see <a href="https://contest.yandex.ru/contest/22781/run-report/69384881/">Run Report. ID 69384881</a>
 */
public final class B {

    private static final Pattern isNumberRegExPattern = Pattern.compile("-?\\d+");

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String input = bufferedReader.readLine();

        // start
        final Deque<Integer> stack = new ArrayDeque<>();

        final StringTokenizer stringTokenizer = new StringTokenizer(input);
        while (stringTokenizer.hasMoreTokens()) {
            final String el = stringTokenizer.nextToken();

            if (isNumberRegExPattern.matcher(el).matches()) { // если это число
                stack.addLast(Integer.parseInt(el)); // то добавляем на стек
                continue;
            }

            // в противном случае это оператор
            final int operand2 = stack.pollLast(); // числа в обратном порядке
            final int operand1 = stack.pollLast();
            final int result = calculate(el.charAt(0), operand1, operand2); // делаем вычисления
            stack.addLast(result); // кладем обратно на стек
        }

        final int result = stack.getLast(); // последнее число на стеке – результат
        // end

        System.out.println(result);
    }

    private static int calculate(final char operator, final int o1, final int o2) {
        switch (operator) {
            case '+':
                return o1 + o2;
            case '-':
                return o1 - o2;
            case '*':
                return o1 * o2;
            case '/':
                return Math.floorDiv(o1, o2);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
