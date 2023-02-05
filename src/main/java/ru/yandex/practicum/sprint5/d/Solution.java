package ru.yandex.practicum.sprint5.d;

public class Solution {
    public static void main(String[] args) {
        test();
    }

    public static boolean treeSolution(Node head1, Node head2) {
       try {
           compare(head1, head2);
           return true;
       } catch (Exception e) {
           return false;
       }
    }

    private static void compare(Node n1, Node n2) throws Exception {
        if (n1 == null || n2 == null) {
            if (n1 == n2) return;
            else throw new Exception();
        }

        if (n1.value != n2.value) throw new Exception();

        compare(n1.left, n2.left);
        compare(n1.right, n2.right);
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
        Node node1 = new Node(1,  null,  null);
        Node node2 = new Node(2,  null,  null);
        Node node3 = new Node(3,  node1,  node2);
        Node node4 = new Node(1,  null,  null);
        Node node5 = new Node(2,  null,  null);
        Node node6 = new Node(3,  node4,  node5);
        assert treeSolution(node3, node6);
        System.out.println(treeSolution(node3, node6)); // true
    }
}
