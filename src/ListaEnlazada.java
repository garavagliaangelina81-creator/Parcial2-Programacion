public class ListaEnlazada<T> {
    private Nodo<T> cabeza;
    private int cantidad;

    public ListaEnlazada() {
        this.cabeza = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    // Agregar al final recorriendo la lista
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        cantidad++;
    }

    // Obtener por posición
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }

        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    // Eliminar por valor
    public boolean eliminar(T datoEliminar) {
        if (estaVacia()) {
            return false;
        }

        // Caso 1: El elemento está en la cabeza
        if (cabeza.getDato().equals(datoEliminar)) {
            cabeza = cabeza.getSiguiente();
            cantidad--;
            return true;
        }

        // Caso 2: El elemento está en el resto de la lista
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getDato().equals(datoEliminar)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                cantidad--;
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    public void vaciar() {
        cabeza = null;
        cantidad = 0;
    }
}