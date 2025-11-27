public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

     protected Node<T> getHead() {
    return head;
}

protected void setHead(Node<T> newHead) {
    this.head = newHead;
}

protected void incrementSize() {
    size++;
}

protected void decrementSize() {
    size--;
}

    // Agregar elemento al final
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Obtener elemento por índice
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> current = head;
        int count = 0;

        while (count < index) {
            current = current.getNext();
            count++;
        }

        return current.getData();
    }

    // Eliminar un elemento por valor
    public boolean remove(T data) {
        if (head == null) return false;

        // Caso especial: primer elemento
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    // Buscar si existe
    public boolean contains(T data) {
        Node<T> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    // Verificar si está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Eliminar todos los elementos
    public void clear() {
        head = null;
        size = 0;
    }

    // Obtener número de elementos
    public int size() {
        return size;
    }
}

   
