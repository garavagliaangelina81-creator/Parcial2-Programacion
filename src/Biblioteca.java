public class Biblioteca {
    private String nombre;
    private ListaEnlazada<Libro> libros;
    private Pila<Prestamo> historialPrestamos;

    // Constructor
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ListaEnlazada<>();
        this.historialPrestamos = new Pila<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ListaEnlazada<Libro> getLibros() { return libros; }

    // Gestión y Búsquedas de Libros

    public void agregarLibro(Libro libro) {
        if (libro != null) { 
            libros.agregar(libro);
        }
    }
    public boolean eliminarLibro(Libro libro) {
        if (libro != null) {
            return libros.eliminar(libro);
        }
        return false;
    }
    public Libro buscarPorIsbn(String isbn) {
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (libroActual.getIsbn().equalsIgnoreCase(isbn)) {
                return libroActual;
            }
        }
        return null;
    }

    public ListaEnlazada<Libro> buscarPorTitulo(String titulo) {
        ListaEnlazada<Libro> resultados = new ListaEnlazada<>();
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (libroActual.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.agregar(libroActual);
            }
        }
        return resultados;
    }

    public ListaEnlazada<Libro> buscarPorAutor(String autor) {
        ListaEnlazada<Libro> resultados = new ListaEnlazada<>();
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (libroActual.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.agregar(libroActual);
            }
        }
        return resultados;
    }

    public ListaEnlazada<Libro> obtenerLibrosDisponibles() {
        ListaEnlazada<Libro> disponibles = new ListaEnlazada<>();
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (libroActual.isDisponible()) {
                disponibles.agregar(libroActual);
            }
        }
        return disponibles;
    }

    public ListaEnlazada<Libro> obtenerLibrosPrestados() {
        ListaEnlazada<Libro> prestados = new ListaEnlazada<>();
        for (int i = 0; i < libros.obtenerCantidad(); i++) { 
            Libro libroActual = libros.obtener(i); 
            if (!libroActual.isDisponible()) {
                prestados.agregar(libroActual);
            }
        }
        return prestados;
    }

    public String obtenerEstadisticas() {
        int total = libros.obtenerCantidad(); 
        int disponibles = obtenerLibrosDisponibles().obtenerCantidad();
        int prestados = obtenerLibrosPrestados().obtenerCantidad();

        return String.format(
            "Estadísticas de la biblioteca '%s':\n- Total de libros: %d\n- Libros disponibles: %d\n- Libros prestados: %d",
            nombre, total, disponibles, prestados
        );
    }

    // Operaciones de Préstamo con PILA

    public boolean registrarPrestamo(Libro libro, String usuario, String fecha) {
        if (libro != null && libro.isDisponible()) {
            if (libro.prestarLibro()) {
                Prestamo operacion = new Prestamo(libro, usuario, fecha);
                historialPrestamos.apilar(operacion);
                return true;
            }
        }
        return false;
    }

    public Prestamo verUltimoPrestamo() {
        return historialPrestamos.verCima();
    }

    public Prestamo deshacerUltimoPrestamo() {
        Prestamo operacion = historialPrestamos.desapilar();
        if (operacion != null) {
            operacion.getLibro().devolverLibro();
        }
        return operacion;
    }

    @Override
    public String toString() {
        return "Biblioteca: " + nombre + " | Libros almacenados: " + libros.obtenerCantidad();
    }
}

