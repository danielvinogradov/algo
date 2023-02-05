package ru.yandex.practicum.sprint5.e;

/**
 * E. Дерево поиска
 */
public final class Solution {

    private static boolean isBST = true;

    public static boolean treeSolution(final Node head) {
        final int value = head.value;

        if (head.left != null) {
            final int leftValue = head.left.value;
            if (leftValue >= value) isBST = false;
            treeSolution(head.left);
        }

        if (head.right != null) {
            final int rightValue = head.right.value;
            if (rightValue <= value) isBST = false;
            treeSolution(head.right);
        }

        return isBST;
    }

    /**
     * Comment it before submitting
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
