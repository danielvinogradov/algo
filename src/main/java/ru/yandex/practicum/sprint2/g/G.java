package ru.yandex.practicum.sprint2.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * G. Стек - MaxEffective
 */
public final class G {

    static class Element {
        private final int value;
        private final int max;

        public Element(final int value, final int max) {
            this.value = value;
            this.max = max;
        }
    }

    static class StackMaxEffective {
        private List<Element> data = new LinkedList<>();

        private void push(final int val) {
            final int max;
            if (data.isEmpty()) max = val;
            else {
                final int currentMax = data.get(data.size() - 1).max;
                max = Math.max(currentMax, val);
            }

            final Element el = new Element(val, max);
            data.add(el);
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

            final Element lastEl = data.get(data.size() - 1);
            System.out.println(lastEl.max);
        }

    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int commandsAmount = Integer.parseInt(bufferedReader.readLine());

        final StackMaxEffective stackMax = new StackMaxEffective();

        for (int i = 0; i < commandsAmount; i++) {
            final String[] commandAndArgumentTuple = bufferedReader.readLine().split(" ");
            final String command = commandAndArgumentTuple[0];

            switch (command) {
                case "push":
                    stackMax.push(Integer.parseInt(commandAndArgumentTuple[1]));
                    break;
                case "pop":
                    stackMax.pop();
                    break;
                case "get_max":
                    stackMax.getMax();
                    break;
                default:
                    // no default
            }
        }
    }
}
