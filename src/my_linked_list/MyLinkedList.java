package my_linked_list;

public class MyLinkedList<E> {
    public int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public void add(E value) {
        Node<E> newNode = new Node<E>(value, null);
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
            if(tempList.next == null) return false;
            tempList = tempList.next;
        }
        return false;
    }

    public E get(int index) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (index == i) return current.value;
            current = current.next;
        }
        return null;
    }

    public boolean remove(E value) {
        Node<E> previous = null, current = head;
        for (int i = 0; i < size; i++) {
            if (current.value == value) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else if (i == size - 1) {
//                    ??????
                } else if (i == 0) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                    head = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    public boolean remove(int index) {
        Node<E> previous = null, current = head;
        if (index < 0 || index >= size) return false;
        for (int i = 0; i < size; i++) {
            if (i==index) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else if (i == size - 1) {
//                    ??????
                } else if (i == 0) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                    head = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }

    private static class Node<E> {
        private E value;
        public Node next;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
