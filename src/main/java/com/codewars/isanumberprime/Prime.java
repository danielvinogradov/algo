package com.codewars.isanumberprime;

/**
 * Is a number prime?
 *
 * @see <a href="https://www.codewars.com/kata/5262119038c0985a5b00029f/train/java">Codewars: Is a number prime?</a>
 */
public class Prime {

    public static boolean isPrime(final int n) {
        if (n < 2) return false;

        int divisorsCounter = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) divisorsCounter++;
        }

        return divisorsCounter == 0;
    }
}
