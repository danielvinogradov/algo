package algo.primes;

public final class PrimeNumberUtils {

    /**
     * Проверяет, является ли число простым.
     *
     * @param n Проверяемое число.
     * @return true, если число простое, false, если составное.
     *
     *
     * From codewars comments: you could start the counter (i) at 3 and always add 2 to it (i+=2), so you need to check if the number is divisible by 2 before (except if it is 2)
     */
    public static boolean isPrime(final int n) {
        if (n < 2) return false;

        int divisorsCounter = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) divisorsCounter++;
        }

        return divisorsCounter == 0;
    }
}
