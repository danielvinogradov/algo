package ru.yandex.practicum.sprint2final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.StringTokenizer;

/**
 * A. Дек
 * <p>
 * -- ПРИНЦИП РАБОТЫ --
 * – Создаем deque с помощью структуры данных кольцевой буфер, где данные хранятся в short[], а указатель на
 * запись "спереди" хранится в head, а на чтение "сзади" – в tail.
 * – При добавлении в начало записываем элемент на индекс head, а потом уменьшаем его. При pop_front наоборот сначала
 * увеличиваем указатель, а потом читаем. В случае с добавлением/удалением с конца все зеркально наоборот.
 * <p>
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * – Если указатели на head и tail смещаются корректно, то из-за того, что они смещаются в разных направлениях,
 * пересечения не будет, пока мы контролируем, что `size != capacity` и `size != 0` при операциях добавления.
 * – Указатели head и tail не указывают одновременно на запись для того, чтобы не возникало необходимости для одной
 * операции сдвигать и head, и tail одновременно (такая необходимость возникает, например, при добавлении первого
 * элемента).
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Линейная O(N), где N – кол-во команд.
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Линейная O(N), где N – это размер дека, заданный при инициализации (после инициализации дека его размерность
 * остается неизменной).
 *
 * @see <a href="https://contest.yandex.ru/contest/22781/run-report/69384989/">Run Report. ID 69384989</a>
 */
public final class A {

    static final class CircularBufferBasedShortDeque {

        public static final String GENERIC_ERROR_MESSAGE = "error";
        // start
        private final int capacity;
        private final short[] buffer;

        private int headWriteIndex = 0; // указатель на запись нового элемента с начала
        private int tailReadIndex = 0; // указатель на чтение элемента с конца
        private int size = 0;

        CircularBufferBasedShortDeque(final int capacity) {
            this.capacity = capacity;
            this.buffer = new short[this.capacity];
        }

        public void pushFront(final short value) {
            if (size == capacity) throw new UnsupportedOperationException(GENERIC_ERROR_MESSAGE);

            size++;

            buffer[headWriteIndex] = value;
            decrementHeadWriteIndex();
        }

        public void pushBack(final short value) {
            if (size == capacity) throw new UnsupportedOperationException(GENERIC_ERROR_MESSAGE);

            size++;

            incrementTailReadIndex();
            buffer[tailReadIndex] = value;
        }

        public Optional<Short> popFront() {
            Optional<Short> result = Optional.empty();
            if (size == 0) return result;

            size--;

            incrementHeadWriteIndex();
            result = Optional.of(buffer[headWriteIndex]);
            return result;
        }

        public Optional<Short> popBack() {
            Optional<Short> result = Optional.empty();
            if (size == 0) return result;

            size--;

            result = Optional.of(buffer[tailReadIndex]);
            decrementTailReadIndex();
            return result;
        }
        // end

        private void incrementHeadWriteIndex() {
            headWriteIndex = (headWriteIndex + 1) % capacity;
        }

        private void decrementHeadWriteIndex() {
            headWriteIndex = (headWriteIndex - 1 + capacity) % capacity;
        }

        private void incrementTailReadIndex() {
            tailReadIndex = (tailReadIndex + 1) % capacity;
        }

        private void decrementTailReadIndex() {
            tailReadIndex = (tailReadIndex - 1 + capacity) % capacity;
        }

    }

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int commandsAmount = Integer.parseInt(bufferedReader.readLine());
        final int dequeCapacity = Integer.parseInt(bufferedReader.readLine());

        final CircularBufferBasedShortDeque deque = new CircularBufferBasedShortDeque(dequeCapacity);

        for (int i = 0; i < commandsAmount; i++) {
            try {
                final String line = bufferedReader.readLine();
                final StringTokenizer stringTokenizer = new StringTokenizer(line);
                final String command = stringTokenizer.nextToken();

                switch (command) {
                    case "push_back":
                        deque.pushBack(Short.parseShort(stringTokenizer.nextToken()));
                        break;
                    case "push_front":
                        deque.pushFront(Short.parseShort(stringTokenizer.nextToken()));
                        break;
                    case "pop_front":
                        final Optional<Short> popFrontEl = deque.popFront();
                        System.out.println(popFrontEl.isPresent() ?
                                popFrontEl.get() : CircularBufferBasedShortDeque.GENERIC_ERROR_MESSAGE);
                        break;
                    case "pop_back":
                        final Optional<Short> popBackEl = deque.popBack();
                        System.out.println(popBackEl.isPresent() ?
                                popBackEl.get() : CircularBufferBasedShortDeque.GENERIC_ERROR_MESSAGE);
                        break;
                    default:
                        // no default
                }
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
