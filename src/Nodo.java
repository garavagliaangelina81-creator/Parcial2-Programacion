public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente; //referenccial hacia el sigueinte nodo

    // Constructor: inicialza
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // Getters y Setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() { //saltar de un nodo a otro
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente; //encadenar un nuevo nodo
    }

    @Override
    public String toString() {
        return dato != null ? dato.toString() : "null";
    }
}