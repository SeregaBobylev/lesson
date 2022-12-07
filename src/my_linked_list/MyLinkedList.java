package my_linked_list;

public class MyLinkedList<E> {
    public int size = 0;
    private Node<E> nodeList;

    public MyLinkedList() {
    }

    public void add(E value) {
        nodeList = nodeList == null ? new Node<>(value, null) : new Node<>(value, nodeList);
        size++;
    }

    public boolean contains(E value) {
        Node<E> tempList = nodeList;
        while (tempList != null){
            if (tempList.value == value) return true;
            else tempList = tempList.nextNode;
        }
        return false;
    }

    public E get(int index) {
        Node<E> tempList = nodeList;
        int tempPosition = size;
        if (index >= size || index < 0) return null;
        while (tempList != null) {
            tempPosition--;
            if (index == tempPosition) return tempList.value;
            tempList = tempList.nextNode;
        }
        return null;
    }

    public boolean remove(E value) {
        Node<E> lastList = null, tempList = nodeList;

        while (tempList != null){
            if (tempList.value == value) {
                lastList.nextNode = tempList.nextNode;
                nodeList = lastList;
                size--;
                return true;
            }
            lastList = tempList;
            tempList = tempList.nextNode;
        }
        return false;
    }
    public boolean remove(int index){
        return false;
    }
    private static class Node<E> {
        private E value;
        public Node nextNode;

        private Node(E value, Node<E> next) {
            this.value = value;
            this.nextNode = next;
        }
    }
}
