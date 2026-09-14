public class Biblioteca {
    private String nombre;
    private ListaEnlazada<Libro> libros; //almacena el catalogo de libros.
    private Pila<Prestamo> historialPrestamos; //registra los prestamos

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ListaEnlazada<>(); //listas vacias
        this.historialPrestamos = new Pila<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ListaEnlazada<Libro> getLibros() { return libros; }

    
    //AGREGAR NUEVO LIBRO
    public void agregarLibro(Libro libro) {
        if (libro != null) { 
            libros.agregar(libro);
        }
    }

    //ELIMINAR LIBRO
    public boolean eliminarLibro(Libro libro) {
        if (libro != null) {
            return libros.eliminar(libro);
        } //devuelve true si se pudo eliminar
        return false; //si no existe devuelve false
    }

    //BUSCAR LIBRO POR SU ISBN
    public Libro buscarPorIsbn(String isbn) {
        for (int i = 0; i < libros.obtenerCantidad(); i++) { //recorre la lista, (i) variable cntador del bucle, representa la posicion y lo guardo el libro actual
            Libro libroActual = libros.obtener(i); 
            if (libroActual.getIsbn().equalsIgnoreCase(isbn)) {
                return libroActual;
            }
        }
        return null;
    }

    //BUSCAR POR TITULO
    public ListaEnlazada<Libro> buscarPorTitulo(String titulo) {
        ListaEnlazada<Libro> resultados = new ListaEnlazada<>(); //creo una instancia nueva para guardar los libros
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (libroActual.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.agregar(libroActual);
            }
        }
        return resultados; //devuelve la lista con los titulos
    }


    //BUSCAR POR AUTOR
    public ListaEnlazada<Libro> buscarPorAutor(String autor) {
        ListaEnlazada<Libro> resultados = new ListaEnlazada<>(); //lista vacia
        for (int i = 0; i < libros.obtenerCantidad(); i++) {  
            Libro libroActual = libros.obtener(i); 
            if (libroActual.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.agregar(libroActual);
            }
        }
        return resultados;
    }

    //LIBROS DISPONIBLES
    public ListaEnlazada<Libro> obtenerLibrosDisponibles() {
        ListaEnlazada<Libro> disponibles = new ListaEnlazada<>();
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (libroActual.isDisponible()) { //evalua el estado booleano
                disponibles.agregar(libroActual); //acumula y retorna
            }
        }
        return disponibles;
    }


    //LIBROS PRESTADOS
    public ListaEnlazada<Libro> obtenerLibrosPrestados() {
        ListaEnlazada<Libro> prestados = new ListaEnlazada<>();
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (!libroActual.isDisponible()) { //si no esta disponible
                prestados.agregar(libroActual);
            }
        }
        return prestados;
    }

    //estadisticas, todos los libros, libros disponibles, libros prestados

    public String obtenerEstadisticas() {
        int total = libros.obtenerCantidad(); 
        int disponibles = obtenerLibrosDisponibles().obtenerCantidad();
        int prestados = obtenerLibrosPrestados().obtenerCantidad();

        return String.format(
            "Estadísticas de la biblioteca '%s':\n- Total de libros: %d\n- Libros disponibles: %d\n- Libros prestados: %d",
            nombre, total, disponibles, prestados
        );
    }

    // OPERACIONES DE PRESTAMO PILA

    // registrar prestamo
    public boolean registrarPrestamo(Libro libro, String usuario, String fecha) {
        if (libro != null && libro.isDisponible()) { //verifica que el libro exista y este disponible
            if (libro.prestarLibro()) { //invoca
                Prestamo operacion = new Prestamo(libro, usuario, fecha); //instanciamos el registro prestamo
                historialPrestamos.apilar(operacion);
                return true;
            }
        }
        return false;
    }

    // Ver ultimo prestamo
    public Prestamo verUltimoPrestamo() {
        return historialPrestamos.verCima(); //consulta la cima de la pila
    }

    //deshacer ultimo prestamo (undo)
    public Prestamo deshacerUltimoPrestamo() {
        Prestamo operacion = historialPrestamos.desapilar(); //extrae y remueve el ultimo prestamo registrado
        if (operacion != null) { // verifica q la pila no este vacia, si no devuelve null
            operacion.getLibro().devolverLibro(); //accede al libro, actualiza el estado true disponible
        }
        return operacion; //devuelve el objeto prestamo
    }

    @Override
    public String toString() {
        return "Biblioteca: " + nombre + " | Libros almacenados: " + libros.obtenerCantidad();
    }
}

