package ru.yandex.practicum.sprint2.f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * F. Стек - Max
 */
public final class F {

    public enum Command {
        GET_MAX,
        PUSH,
        POP;

        public static Command from(final String s) {
            final String normalizedString = s.toUpperCase();
            for (final Command command : Command.values()) {
                if (command.name().equals(normalizedString)) {
                    return command;
                }
            }
            throw new NullPointerException();
        }
    }

    static class StackMax {

        private final List<Integer> data = new LinkedList<>();

        private void push(final int val) {
            data.add(val);
        }

        private void pop() {
            if (data.isEmpty()) {
                System.out.println("error");
                return;
            }

            data.remove(data.size() - 1);
        }

        private void getMax() {
            if (data.isEmpty()) {
                System.out.println("None");
                return;
            }

            int max = data.get(0);
            for (final int cur : data) {
                if (max < cur) max = cur;
            }

            System.out.println(max);
        }

    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int commandsAmount = Integer.parseInt(bufferedReader.readLine());

        final StackMax stackMax = new StackMax();

        for (int i = 0; i < commandsAmount; i++) {
            final String[] commandAndArgumentTuple = bufferedReader.readLine().split(" ");
            final Command command = Command.from(commandAndArgumentTuple[0]);

            switch (command) {
                case PUSH:
                    stackMax.push(Integer.parseInt(commandAndArgumentTuple[1]));
                    break;
                case POP:
                    stackMax.pop();
                    break;
                case GET_MAX:
                    stackMax.getMax();
                    break;
                default:
                    // no default
            }
        }
    }

}
