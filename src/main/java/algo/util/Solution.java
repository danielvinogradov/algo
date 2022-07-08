package algo.util;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Эффективный способ считывать строки.
 * <p>
 * Обратите внимание, что текст читается построчно, а для считывания двух чисел нужно применить класс StringTokenizer.
 * Он будет читать текст, пока не встретит разделитель. Этот класс поочерёдно вернёт сначала первое число, затем
 * второе. Такой способ работает существенно быстрее, чем класс Scanner или метод String.split.
 */
final class Solution {
    public static void main(String[] args) throws IOException {
        final StringBuilder outputBuffer = new StringBuilder();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        final int numLines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numLines; ++i) {
            final StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            final int value1 = Integer.parseInt(tokenizer.nextToken());
            final int value2 = Integer.parseInt(tokenizer.nextToken());

            final int result = value1 + value2;

            outputBuffer
                    .append(result)
                    .append("\n");
        }

        System.out.println(outputBuffer.toString());
    }
}
