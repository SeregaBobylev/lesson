package my_linked_list;

public class MyLinkedList<E> {
    public int size = 0;
    private Node<E> node;
    private static class Node<E> {
        private E value;
        public Node next;
        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList() {
    }
    public void add(E value) {
        if(node==null){
            node = new Node<>(value,null);
        }
        else {
           Node<E> tempNode = node;
           node = new Node<>(value,tempNode);
        }
        size++;
    }

    public boolean remove(E value) {
        return true;
    }
}
