/* Comment package name before submitting */
package ru.yandex.practicum.sprint2.d;

import java.util.Objects;

/* Comment Node class definition before submitting */
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {

    private static final int NOT_FOUNT_IDENTIFIER = -1;

    public static int solution(Node<String> head, String elem) {
        Node<String> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (Objects.equals(elem, currentNode.value)) return index;

            currentNode = currentNode.next;
            index++;
        }

        return NOT_FOUNT_IDENTIFIER;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        assert idx == 2;
    }

}
