package stack;

public class MyStack<E> {
    public int size = 0;
    private Node<E> top = null;

    public E push(E value) {
        if(size==0){
            top =new Node<>(value,null);
        }
        else{
            top = new Node<>(value, top);
        }
        size++;
        return value;
    }
    public E pop(){
//        delete top element
        E result = top.value;
        size--;
        top = size!=0?top.lastNodes:null;
        return result;
    }
    public E peek(){
        return size==0?null:top.value;
    }

    private static class Node<E>{
        private E value;
        private Node<E> lastNodes;

        public Node(E value, Node<E> lastNodes) {
            this.value = value;
            this.lastNodes = lastNodes;
        }
    }
}
