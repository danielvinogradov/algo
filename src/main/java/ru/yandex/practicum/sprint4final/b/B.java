package ru.yandex.practicum.sprint4final.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;
import java.util.StringTokenizer;

/**
 * B. Хеш-таблица
 * <p>
 * -- ПРИНЦИП РАБОТЫ --
 * Хеш-таблица. Коллизии разрешаются с помощью метода цепочек (используется односвязный список).
 * <p>
 * Так как по условию задачи поддерживать рехеширование и масштабирование не требуется, а также зная максимальное кол-во
 * ключей можем подобрать размер массива так, чтобы проходить тесты, при этом не увеличивая его размер.
 * <p>
 * Я тестировал различный capacity, в частности ~500 (3.899s), 1171 (2.588s), 7919 (1.749s), 999331 (1.711s). Потребление
 * памяти при этом практически не изменялось, а разница в скорости между 7919 и 999331 на уровне погрешности.
 * В итоге оставил capacity = 7919.
 * <p>
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Тут вроде как все по теории :) Так как используем целые числа в качестве ключей использую простейший вариант
 * нахождения индекса – key % buckets.length, думается, что они должны быть достаточно равномерно распределены.
 * Константная сложность операций (в среднем) достигается за счет использования массивов, где операция получения элемента
 * по индексу так же константна.
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Для всех операций в HashMap в лучшем и среднем случаях сложность константна O(1). В худшем придется перебрать все значения,
 * хранимые в одном бакете, где используется связный список Такой перебор имеет линейную сложность O(N), где N – кол-во
 * элементов, хранимых в одном бакете из-за коллизий.
 * <p>
 * В контексте программы сложность линейная O(N), где N – кол-во совершаемых операций (get, put, delete).
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Пространственная сложность линейная O(N), и будет зависеть от кол-ва значений в таблице, потому что для каждого хранимого
 * значения создается экземпляр Node.
 *
 * @see <a href="https://contest.yandex.ru/contest/24414/run-report/69748228/">Run Report. ID 69748228</a>
 */
public final class B {

    public static final String NO_VALUE_MESSAGE = "None";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final HashMap hashMap = new HashMap();

        final StringBuilder result = new StringBuilder();

        final int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            final String line = bufferedReader.readLine();
            final StringTokenizer tokenizer = new StringTokenizer(line);
            final String action = tokenizer.nextToken();

            switch (action) {
                case "put":
                    final int keyToPut = Integer.parseInt(tokenizer.nextToken());
                    final int valueToPut = Integer.parseInt(tokenizer.nextToken());
                    hashMap.put(keyToPut, valueToPut);
                    break;
                case "get":
                    final int keyToGet = Integer.parseInt(tokenizer.nextToken());
                    final OptionalInt valueByKey = hashMap.get(keyToGet);
                    result.append(valueByKey.isPresent() ? valueByKey.getAsInt() : NO_VALUE_MESSAGE);
                    result.append('\n');
                    break;
                case "delete":
                    final int keyToDelete = Integer.parseInt(tokenizer.nextToken());
                    final OptionalInt deletedValue = hashMap.delete(keyToDelete);
                    result.append(deletedValue.isPresent() ? deletedValue.getAsInt() : NO_VALUE_MESSAGE);
                    result.append('\n');
                    break;
                default:
                    // no default specified
            }
        }

        System.out.println(result);

        bufferedReader.close();
    }

    private static class HashMap {

        private static final int CAPACITY = 7919;

        private static class Node {
            int key;
            int value;
            Node next = null;

            public Node(final int key, final int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final Node[] buckets = new Node[CAPACITY];

        private int getBucketIndex(final int key) {
            return key % buckets.length;
        }

        public void put(final int key, final int value) {
            final int i = getBucketIndex(key);

            Node lastNode = buckets[i];

            if (lastNode == null) {
                buckets[i] = new Node(key, value);
                return;
            }

            while (lastNode.next != null) {
                if (lastNode.key == key) {
                    lastNode.value = value;
                    return;
                }

                lastNode = lastNode.next;
            }

            if (lastNode.key == key) {
                lastNode.value = value;
                return;
            }

            lastNode.next = new Node(key, value);
        }

        public OptionalInt get(final int key) {
            final int i = getBucketIndex(key);

            Node node = buckets[i];
            while (node != null) {
                if (node.key == key) return OptionalInt.of(node.value);
                node = node.next;
            }

            return OptionalInt.empty();
        }

        public OptionalInt delete(final int key) {
            final int i = getBucketIndex(key);

            Node node = buckets[i];
            if (node == null) return OptionalInt.empty();
            if (node.key == key) {
                final int value = node.value;
                buckets[i] = node.next;
                return OptionalInt.of(value);
            }
            Node next = node.next;

            while (next != null) {
                if (next.key == key) {
                    final int value = next.value;
                    node.next = next.next;
                    return OptionalInt.of(value);
                }

                node = next;
                next = node.next;
            }

            return OptionalInt.empty();
        }

    }
}
