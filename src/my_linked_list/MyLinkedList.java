package my_linked_list;

public class MyLinkedList<E> {
    public int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public boolean contains(E value) {
        Node<E> tempList = head;
        for (int i = 0; i < size; i++) {
            if (tempList.value.equals(value)) return true;
            tempList = tempList.next;
        }
        return false;
    }

    public E get(int index) {
        return getNodeByIndex(index).value;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        E result = head.value;
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> previous = getNodeByIndex(index - 1);
            result = (E) previous.next.value;
            previous.next = previous.next.next;
        }
        size--;
        return result;
    }

    public boolean remove(E value) {
        Node<E> node = head;
        Node<E> previous = null;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(value)) {
                if (i == 0) {
                    head = head.next;
                } else {
                    previous.next = previous.next.next;
                }
                size--;
                return true;
            }
            previous = node;
            node = node.next;
        }
        return false;
    }

    private Node<E> getNodeByIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<E> {
        private E value;
        public Node<E> next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
