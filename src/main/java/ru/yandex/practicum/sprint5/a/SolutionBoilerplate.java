package ru.yandex.practicum.sprint5.a;

/**
 * Это заготовка для задачи.
 */
public class SolutionBoilerplate {
    public static int treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”
        return 0;
    }

    /** Comment it before submitting
    **/
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }
}
