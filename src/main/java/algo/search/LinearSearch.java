package algo.search;

import algo.AsymptoticComplexity;

/**
 * Линейный поиск (Linear Search).
 *
 * @see AsymptoticComplexity#LINEAR
 */
public final class LinearSearch {

    public static int find(final int[] array, final int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        throw new IllegalArgumentException();
    }

}
