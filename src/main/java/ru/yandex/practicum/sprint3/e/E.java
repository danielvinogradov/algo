package ru.yandex.practicum.sprint3.e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * E. Покупка домов
 */
public final class E {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer tokenizer1 = new StringTokenizer(bufferedReader.readLine());
        final int housesAmount = Integer.parseInt(tokenizer1.nextToken());
        final int initialBudget = Integer.parseInt(tokenizer1.nextToken());
        final StringTokenizer tokenizer2 = new StringTokenizer(bufferedReader.readLine());
        final int[] prices = new int[housesAmount];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(tokenizer2.nextToken());
        }

        Arrays.sort(prices);

        int result = 0;
        int budgetLeft = initialBudget;

        for (final int currentPrice : prices) {
            final int budgetAfterBuy = budgetLeft - currentPrice;

            if (budgetAfterBuy >= 0) {
                result++;
                budgetLeft = budgetAfterBuy;
            } else break;
        }

        System.out.println(result);
    }
}
