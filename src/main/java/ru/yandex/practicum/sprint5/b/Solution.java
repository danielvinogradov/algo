package ru.yandex.practicum.sprint5.b;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static boolean treeSolution(Node head) {
        final String leftMapKey = "left";
        final String rightMapKey = "right";
        Map<String, Integer> m = new HashMap<>();
        m.put(leftMapKey, 0);
        m.put(rightMapKey, 0);

        goDeep(head.left, m, leftMapKey, 0);
        goDeep(head.right, m, rightMapKey, 0);

        final int leftMax = m.get(leftMapKey);
        final int rightMax = m.get(rightMapKey);

        final int maxDiff = 1;

        System.out.println(leftMax);
        System.out.println(rightMax);

        return Math.abs(leftMax - rightMax) <= maxDiff;
    }

    private static void goDeep(Node node, Map<String, Integer> m, String mKey, int v) {
        if (node == null) return;

        final int currentMax = m.get(mKey);
        final int currentV = v + 1;
        if (currentMax < currentV) m.put(mKey, currentV);
        goDeep(node.left, m, mKey, currentV);
        goDeep(node.right, m, mKey, currentV);
    }

    /**
     * Comment it before submitting
     */
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
    /* **/

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);

        System.out.println(treeSolution(node5)); // true

        var n1 = new Node(1);
        var n2 = new Node(1);
        var n3 = new Node(1);
        var n4 = new Node(1);
        var n5 = new Node(1);
        var n6 = new Node(1);
        var n7 = new Node(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n4.left = n5;

        System.out.println(treeSolution(n1));
    }
}
