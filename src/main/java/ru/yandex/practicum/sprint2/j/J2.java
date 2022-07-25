package ru.yandex.practicum.sprint2.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * J. Списочная очередь
 *
 * Та же задача, только со своей реализацией двусвязного списка.
 */
public final class J2 {

    static class Node {
        int value;
        Node prev;
        Node next;

        public Node(final int value, final Node prev, final Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    static class LinkedListQ {
        private Node head;
        private Node tail;
        private int size = 0;

        public void get() {
            if (size == 0) {
                System.out.println("error");
                return;
            }

            System.out.println(head.value);

            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }

            size--;
        }

        public void put(final int value) {
            if (size == 0) {
                final Node node = new Node(value, null, null);
                head = tail = node;
            } else if (size == 1) {
                final Node node = new Node(value, head, null);
                tail = node;
                head.next = node;
            } else {
                final Node node = new Node(value, tail, null);
                tail.next = node;
                tail = node;
            }

            size++;
        }

        public void size() {
            System.out.println(size);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int commandsAmount = Integer.parseInt(bufferedReader.readLine());

        final LinkedListQ q = new LinkedListQ();

        for (int i = 0; i < commandsAmount; i++) {
            final String line = bufferedReader.readLine();
            final StringTokenizer stringTokenizer = new StringTokenizer(line);

            final String command = stringTokenizer.nextToken();

            switch (command) {
                case "get":
                    q.get();
                    break;
                case "put":
                    final int argument = Integer.parseInt(stringTokenizer.nextToken());
                    q.put(argument);
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
