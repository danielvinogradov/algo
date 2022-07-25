package com.codewars.primesinumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Primes in numbers
 *
 * @see <a href="https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/java">Codewars: Primes in numbers</a>
 */
public final class PrimeDecomp {

    public static String factors(final int input) {
        final Map<Integer, Integer> divisorsMap = new LinkedHashMap<>();

        final int[] divisorsToTry = getPrimes((int) Math.sqrt(input) + 1);

        int curN = input;
        for (final int divisor : divisorsToTry) {
            while (curN % divisor == 0) {
                if (divisorsMap.containsKey(divisor)) {
                    divisorsMap.put(divisor, divisorsMap.get(divisor) + 1);
                } else {
                    divisorsMap.put(divisor, 1);
                }
                curN /= divisor;
            }
        }

        if (curN != 1) {
            divisorsMap.put(curN, 1);
        }

        return format(divisorsMap);
    }

    private static String format(final Map<Integer, Integer> divisors) {
        return divisors.entrySet().stream()
                .map(el -> {
                    if (el.getValue() == 1) return String.format("(%d)", el.getKey());
                    return String.format("(%d**%d)", el.getKey(), el.getValue());
                }).collect(Collectors.joining());
    }

    private static int[] getPrimes(final int toInclusive) {
        if (toInclusive < 2) throw new IllegalArgumentException();

        final int NOT_PRIME_IDENTIFIER = -1;
        final int[] numbers = IntStream.rangeClosed(2, toInclusive)
                .toArray();

        int lastPrimeIndex = 0;
        int lastPrime = numbers[lastPrimeIndex];
        while (true) {
            for (int i = lastPrimeIndex + lastPrime; i < numbers.length; i += lastPrime) {
                numbers[i] = NOT_PRIME_IDENTIFIER;
            }

            int prevLastPrimeIndex = lastPrimeIndex;
            for (int i = lastPrimeIndex + 1; i < numbers.length; i++) {
                if (numbers[i] != NOT_PRIME_IDENTIFIER) {
                    lastPrimeIndex = i;
                    lastPrime = numbers[i];
                    break;
                }
            }
            if (prevLastPrimeIndex == lastPrimeIndex) break;
        }

        return Arrays.stream(numbers)
                .filter(el -> el != NOT_PRIME_IDENTIFIER)
                .toArray();
    }

}
