package ru.yandex.practicum.sprint2.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * I. Ограниченная очередь
 */
public final class I {

    static class MyQueueSized {
        private final int[] data;
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        MyQueueSized(final int capacity) {
            this.data = new int[capacity];
        }

        public void push(final int value) {
            if (size == data.length) {
                System.out.println("error");
                return;
            }

            data[tail] = value;

            tail++;
            if (tail == data.length) tail = 0;
            size++;
        }

        private void peek() {
            if (size == 0) {
                System.out.println("None");
                return;
            }

            System.out.println(data[head]);
        }

        private void pop() {
            if (size == 0) {
                System.out.println("None");
                return;
            }

            System.out.println(data[head]);

            head++;
            if (head == data.length) head = 0;
            size--;
        }

        private void size() {
            System.out.println(size);
        }

    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int commandsAmount = Integer.parseInt(bufferedReader.readLine());
        final int queueCapacity = Integer.parseInt(bufferedReader.readLine());

        final MyQueueSized q = new MyQueueSized(queueCapacity);

        for (int i = 0; i < commandsAmount; i++) {
            final String line = bufferedReader.readLine();
            final StringTokenizer stringTokenizer = new StringTokenizer(line);

            final String command = stringTokenizer.nextToken();

            switch (command) {
                case "push":
                    final int argument = Integer.parseInt(stringTokenizer.nextToken());
                    q.push(argument);
                    break;
                case "pop":
                    q.pop();
                    break;
                case "peek":
                    q.peek();
                    break;
                case "size":
                    q.size();
                    break;
                default:
                    // no default
            }
        }
    }
}
