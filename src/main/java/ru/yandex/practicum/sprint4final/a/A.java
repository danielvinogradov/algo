package ru.yandex.practicum.sprint4final.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A. Поисковая система
 * <p>
 * -- ПРИНЦИП РАБОТЫ --
 * Сначала обрабатываются документы, и создается структура данных (Map), которая хранит, сколько раз каждое слово
 * встречается в конкретном документе. Изначально я реализовал на массивах (потом заменил на Map, чтобы не тратить
 * лишнюю память), но на массивах наиболее наглядно получается объяснить.
 * <p>
 * Создаем map, где ключом будет слово, а значением – int[], где индекс – порядковый номер документа, в котором
 * встречается слово, а значение – сколько раз оно[слово] встречается.
 * <p>
 * Таким образом, документы:
 * – "i love coffee"
 * – "coffee with milk and sugar"
 * – "free tea for everyone"
 * Их хранение (массивы для наглядности, в коде заменены на Map<Integer, Integer>):
 * "i":        [1, 0, 0]
 * "love":     [1, 0, 0]
 * "coffee":   [1, 1, 0]
 * "with":     [0, 1, 0]
 * "milk":     [0, 1, 0]
 * "and":      [0, 1, 0]
 * "sugar":    [0, 1, 0]
 * "free":     [0, 0, 1]
 * "tea":      [0, 0, 1]
 * "for":      [0, 0, 1]
 * "everyone": [0, 0, 1]
 * <p>
 * Для поисковой строки "i like black coffee without milk" берем те слова, которые есть в документах, т.е.:
 * "i":        [1, 0, 0]
 * "coffee":   [1, 1, 0]
 * "milk":     [0, 1, 0]
 * "Складываем массивы в столбик" и получаем:
 * -           [2, 2, 0]
 * Наиболее релевантны документы с индексами 0 и 1, то есть правильный ответ будет "1 2".
 * -- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
 * Сортировка при одинаковых показателях не ломается, т.к. находим 5 наиболее релевантных документов с помощью
 * циклов, а scores документов хранятся в массиве, т.е. идут по порядку.
 * <p>
 * -- ВРЕМЕННАЯ СЛОЖНОСТЬ --
 * Для создания поискового индекса: O(N), где N – кол-во неуникальных слов в документах.
 * <p>
 * Поиск. Поиск состоит из нескольких операций:
 * – O(N), где N – кол-во неуникальных слов в поисковой строке (так или иначе обрабатываем каждое слово)
 * – O(M), где M – кол-во уникальных слов в поисковой строке, которые также встречаются в поисковом индексе (если слово
 * есть в поисковом индексе, то выполняем дополнительные операции)
 * – O(k * X), где k – число от 1 до 5, сколько раз выполняется операция поиска в массиве релевантных документов, а X –
 * кол-во добавленных документов
 * Таким образом, получаем сложность O(N + M + k*X). Хотя фактическое время выполнения будет отличаться в зависимости
 * от характера входных параметров, думается, что можно обобщить и сказать, что характер асимптотической сложности будет
 * сохраняться линейным O(N).
 * <p>
 * Можно было бы сказать, что в контексте программы есть линейная зависимость от кол-ва поисковых запросов
 * и кол-ва документов, т.е. O(M + N), где:
 * – M – кол-во документов (также большая зависимость от кол-ва слов в этих документах),
 * – N – кол-во поисковых запросов (тоже зависит не только от запросов, но и кол-ва слов в запросах)
 * <p>
 * Но такая оценка не отражает необходимости от 1 до 5 раз обходить массив с оценками релевантности каждого документа
 * для поиска наиболее релевантных документов для каждого поискового запроса.
 * <p>
 * Если отразить зависимость каждого запроса от кол-ва документов при выборе наиболее релевантных,
 * то получим O(M + M * N). При этом слагаемое M можно отбросить (будет не значимым в большинстве случаев)
 * и получить O(M * N).
 * <p>
 * -- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
 * Для создания поискового индекса: O(N), где N – кол-во уникальных слов в документах.
 * Для поиска одной строки (сложность всей программы, разумеется, будет линейно зависеть от кол-ва поисков):
 * – O(N), где N – кол-во документов (создаем массив для хранения значений релевантности документов)
 * – O(1), используем массив для хранения индексов 5 наиболее релевантных документов
 * – O(M), где M – кол-во уникальных слов в поисковой строке (используем Set для проверки на уникальность, если
 * уникальных слов много, то Set может расширяться)
 * Обобщая, получается, что сложность поиска так же будет линейной O(N).
 *
 * @see <a href="https://contest.yandex.ru/contest/24414/run-report/69741404/">Run Report. ID 69741404</a>
 */
public final class A {

    public static final int SEARCH_RESULTS_LIMIT = 5;

    /**
     * String – это слово
     * первый Integer – порядковый номер документа (в коде называется ordinal)
     * второй Integer – сколько раз слово встречается в документе
     */
    private static final Map<String, Map<Integer, Integer>> wordsSearchIndex = new HashMap<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int docsAmount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < docsAmount; i++) processDocument(bufferedReader.readLine(), i);

        final StringBuilder result = new StringBuilder();

        final int queriesAmount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < queriesAmount; i++) {
            final String line = bufferedReader.readLine();
            final String searchResult = getSearchResults(line, docsAmount);

            result.append(searchResult);
            result.append('\n');
        }

        System.out.println(result);

        bufferedReader.close();
    }

    /**
     * Обрабатывает документ. Добавляет слова, встречающиеся в документе и его[документа] порядковый номер
     * в {@link #wordsSearchIndex}.
     *
     * @param doc     – добавляемый документ (строка)
     * @param ordinal – порядковый номер документа
     */
    private static void processDocument(final String doc, final int ordinal) {
        final StringTokenizer tokenizer = new StringTokenizer(doc);
        while (tokenizer.hasMoreTokens()) {
            final String token = tokenizer.nextToken();
            wordsSearchIndex.computeIfAbsent(token, s -> new HashMap<>());
            final Map<Integer, Integer> ordinalCountMap = wordsSearchIndex.get(token);
            ordinalCountMap.put(ordinal, ordinalCountMap.getOrDefault(ordinal, 0) + 1);
        }
    }

    /**
     * Получить результаты поиска.
     *
     * @param query           – поисковый запрос
     * @param documentsAmount – кол-во документов
     * @return порядковые номера документов в порядке убывания релевантности, разделенные пробелом
     */
    private static String getSearchResults(final String query, final int documentsAmount) {
        final StringTokenizer tokenizer = new StringTokenizer(query);
        final Set<String> uniqueWordsSet = new HashSet<>();

        final int[] documentsRelevanceArray = new int[documentsAmount];

        while (tokenizer.hasMoreTokens()) {
            final String word = tokenizer.nextToken();

            if (uniqueWordsSet.contains(word)) continue;
            uniqueWordsSet.add(word);

            if (wordsSearchIndex.containsKey(word)) {
                final Map<Integer, Integer> ordinalAmountMap = wordsSearchIndex.get(word);
                for (final Map.Entry<Integer, Integer> entry : ordinalAmountMap.entrySet()) {
                    final int ordinal = entry.getKey();
                    final int score = entry.getValue();
                    documentsRelevanceArray[ordinal] += score;
                }
            }
        }

        return getMostRelevantDocuments(documentsRelevanceArray);
    }

    /**
     * Выбирает {@link #SEARCH_RESULTS_LIMIT} наиболее релевантных документов.
     *
     * @param scores – релевантность документов: порядковый номер элемента массива соответствует порядковому номеру
     *               документа, а значение – релевантность (чем выше, тем релевантнее)
     * @return порядковые номера наиболее релевантных документов, разделенные пробелом, например, "3 4 1"
     */
    private static String getMostRelevantDocuments(final int[] scores) {
        final int[] ordinals = new int[SEARCH_RESULTS_LIMIT];

        for (int i = 0; i < ordinals.length; i++) {
            int maxValue = 0;
            int maxValueIndex = 0;
            for (int j = 0; j < scores.length; j++) {
                final int score = scores[j];
                if (score > maxValue) {
                    maxValue = score;
                    maxValueIndex = j;
                }
            }
            if (maxValue == 0) break;

            ordinals[i] = maxValueIndex + 1;
            scores[maxValueIndex] = 0;
        }

        return Arrays.stream(ordinals)
                .filter(el -> el != 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

}
