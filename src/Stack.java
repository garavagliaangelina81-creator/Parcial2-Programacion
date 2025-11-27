public class Stack<T> {

    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    // Push para agregar arriba de la pila
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(list.getHead()); 
        list.setHead(newNode);          
    }

    // Pop para quitar elemento arriba de la pila
    public T pop() {
        if (isEmpty()) return null;

        Node<T> head = list.getHead();
        T data = head.getData();

        list.setHead(head.getNext());
        list.decrementSize();

        return data;
    }

    // Peek ver el tope sin quitar
    public T peek() {
        if (isEmpty()) return null;
        return list.getHead().getData();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
