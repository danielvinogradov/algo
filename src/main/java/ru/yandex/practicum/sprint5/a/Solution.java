package ru.yandex.practicum.sprint5.a;

/**
 * A. Лампочки
 */
public final class Solution {

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

    private static int max = 0;

    public static int treeSolution(final Node head) {
        if (head.value > max) max = head.value;
        if (head.left != null) treeSolution(head.left);
        if (head.right != null) treeSolution(head.right);
        return max;
    }

}
