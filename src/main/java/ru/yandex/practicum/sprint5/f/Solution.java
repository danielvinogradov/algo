package ru.yandex.practicum.sprint5.f;

public class Solution {
    public static int treeSolution(Node head) {
        final int[] max = new int[]{0};
        goDeep(head, max, 1);
        return max[0];
    }

    private static void goDeep(Node node, int[] data, int v) {
        if (node == null) return;

        int max = data[0];
        if (max < v) data[0] = v;

        goDeep(node.left, data, v + 1);
        goDeep(node.right, data, v + 1);
    }

    /** Comment it before submitting */
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
    /* **/

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5) == 3;
        System.out.println(treeSolution(node5) == 3); // true
    }
}
