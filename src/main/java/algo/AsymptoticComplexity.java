package algo;

public enum AsymptoticComplexity {

    /**
     * O(N!).
     */
    FACTORIAL,

    /**
     * Экспоненциальная сложность. O(2^N).
     */
    EXPONENTIAL,

    /**
     * Кубическая сложность. O(N^3).
     */
    CUBIC,

    /**
     * Квадратичная сложность. O(N^2).
     */
    QUADRATIC,

    /**
     * O(N log N).
     */
    N_LOG_N,

    /**
     * Линейная сложность. O(N).
     */
    LINEAR,

    /**
     * Логарифмическая сложность. O(log N).
     */
    LOGARITHMIC,

    /**
     * Константная сложность. O(1).
     */
    CONSTANT;
}
