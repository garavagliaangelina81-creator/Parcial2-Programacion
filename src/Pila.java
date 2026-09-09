public class Pila<T> {
    private Nodo<T> cima;
    private int cantidad;

    // Constructor
    public Pila() {
        this.cima = null;
        this.cantidad = 0;
    }

    public boolean estaVacia() {
        return this.cima == null;
    }

    public int obtenerCantidad() {
        return this.cantidad;
    }

    // Apilar (Push): Agrega un elemento en el tope O(1)
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(this.cima);
        this.cima = nuevoNodo;
        this.cantidad++;
    }

    // Desapilar (Pop): Elimina y retorna el elemento en el tope O(1)
    public T desapilar() {
        if (estaVacia()) {
            return null;
        }

        T dato = this.cima.getDato();
        this.cima = this.cima.getSiguiente(); // La nueva cima es el nodo inferior
        this.cantidad--;
        return dato;
    }

    // Ver Cima (Peek): Consulta el elemento en el tope sin removerlo
    public T verCima() {
        if (estaVacia()) {
            return null;
        }
        return this.cima.getDato();
    }
}

/**
 * la pila lifo. el ultimo elemento en entrar es es ingresado mediante apilar queda
 * refererenciado por la cima, garantizando que sea el primero en salir al ejectar desapilar
 */
/**
 * al no tener que recorrer elementos intermedios ni realizar bucles, todas
 * las operaciones principales (aplilar, desapilar y vercima ) se ejecutan en tiempo constante.
 * 
 */