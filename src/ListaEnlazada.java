public class ListaEnlazada<T> {
    private Nodo<T> cabeza; 
    private int cantidad; // el total de los elementos

    public ListaEnlazada() {
        this.cabeza = null;
        this.cantidad = 0;
    }
    //consultas del estado de la pila
    public boolean estaVacia() {
        return cabeza == null; //true si la cabeza no tiene ningun nodo
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    // Agregar libro cabeza o reccoriendo la lista
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) { //si esta vacia
            cabeza = nuevoNodo;
        } else { // sino recorre hasta el ultimo nodo
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo); //el anterior se engancha al nuevo nodo
        }
        cantidad++;
    }

    // Obtener por posición, avanza desde cabeza dando daltos
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null; //null si la posicion es es negativa
        }

        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente(); //usan un puntero actual y for para dar con el nodo ubicado 
        }
        return actual.getDato();
    }

    // Eliminar por valor
    public boolean eliminar(T datoEliminar) {
        if (estaVacia()) {
            return false; // si no hay nodos, devuelve false
        }

        // Caso 1: El elemento está en la cabeza
        if (cabeza.getDato().equals(datoEliminar)) {
            cabeza = cabeza.getSiguiente(); // el puntero cabeza apunta al segundo nodo cabeza
            cantidad--;
            return true;
        }

        // Caso 2: El elemento está en el resto de la lista
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) { //este es el nodo que queremos eliminar
            if (actual.getSiguiente().getDato().equals(datoEliminar)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());// el nodo posterior que queremos eliminar
                cantidad--;
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }
//vaciar toda la lista, estado inicual
    public void vaciar() {
        cabeza = null;
        cantidad = 0;
    }
}