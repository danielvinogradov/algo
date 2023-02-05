//package ru.yandex.practicum.sprint5.c;

public class Solution {
    public static boolean treeSolution(Node head) {
        try {
            check(head.left, head.right);
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    private static void check(final Node n1, final Node n2) throws Exception {
        if (n1 == null && n2 == null) return;
        if (n1 == null || n2 == null) throw new Exception();

        if (n1.value != n2.value) throw new Exception();
        check(n1.left, n2.right);
        check(n1.right, n2.left);
    }

    /** Comment it before submitting
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
     **/


    private static void test() {
        Node node1 = new Node(3,  null,  null);
        Node node2 = new Node(4,  null,  null);
        Node node3 = new Node(4,  null,  null);
        Node node4 = new Node(3,  null,  null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);
        assert treeSolution(node7);
    }
}
