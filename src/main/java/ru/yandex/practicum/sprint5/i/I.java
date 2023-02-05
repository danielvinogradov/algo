package ru.yandex.practicum.sprint5.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class I {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        BigInteger dividend = factorial(2 * n);
        BigInteger divisor = factorial(n).multiply(factorial(n + 1));

        BigInteger result = dividend.divide(divisor);
        System.out.println(result);
    }

    private static BigInteger factorial(final int n) {
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
          bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        return bigInteger;
    }
}
