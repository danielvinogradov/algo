package ru.yandex.practicum.sprint2.j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * J. Списочная очередь
 */
public final class J {

    static class LinkedListQ {
        private final List<Integer> data = new LinkedList<>();

        public void get() {
            if (data.isEmpty()) {
                System.out.println("error");
                return;
            }

            System.out.println(data.get(0));
            data.remove(0);
        }

        public void put(final int value) {
            data.add(value);
        }

        public void size() {
            System.out.println(data.size());
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
