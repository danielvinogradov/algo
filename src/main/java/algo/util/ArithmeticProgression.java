package algo.util;

public final class ArithmeticProgression {

    /**
     * Находит сумму членов арифметической прогрессии.
     *
     * @param elementsCount Кол-во элементов в прогрессии.
     * @param firstEl       Первый элемент прогрессии.
     * @param lastEl        Второй элемент прогрессии.
     * @return Сумма членов прогрессии.
     */
    public static int calculateArithmeticSeriesSum(final int elementsCount, final int firstEl, final int lastEl) {
        return (elementsCount * (firstEl + lastEl)) / 2;
    }
}
