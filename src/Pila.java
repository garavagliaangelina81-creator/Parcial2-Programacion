public class Pila<T> {
    private Nodo<T> cima; //puntero, referencia
    private int cantidad;

    // Constructor
    public Pila() {
        this.cima = null; //ningun nodo
        this.cantidad = 0;
    }
    //pila sin elementos
    public boolean estaVacia() {
        return this.cima == null;
    }

    public int obtenerCantidad() {
        return this.cantidad;
    }

    // Apilar (Push): Agrega un elemento en el tope
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(this.cima); //nuevo nodo apunta hacia abajo
        this.cima = nuevoNodo;
        this.cantidad++;
    }

    // Desapilar (Pop): Elimina y retorna el elemento en el tope
    public T desapilar() {
        if (estaVacia()) { //v que la pila no este vacia
            return null;
        }

        T dato = this.cima.getDato();
        this.cima = this.cima.getSiguiente(); //el nodo de la cima salta al nodo q estaba abajo de el, al cambiar el puntero cima, el nodo que esta arriba de todo queda desconectado
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

/**
 * t dato = this.cima.getDato(), guardas en una variable temporal dato el valor o el objeto
 * prestamo q esta en el nodo de mas arriba, tenes que guardarlo antes de mover los punteros, pq si moves la cima primero, perderias la referencia a este dato
 * 
 */