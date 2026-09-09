public class Prestamo {
    private Libro libro;
    private String usuario;
    private String fecha;

    // Constructor
    public Prestamo(Libro libro, String usuario, String fecha) {
        this.libro = libro;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format("Préstamo [Libro: '%s' (ISBN: %s) | Usuario: %s | Fecha: %s]", 
                libro != null ? libro.getTitulo() : "N/A",
                libro != null ? libro.getIsbn() : "N/A",
                usuario, 
                fecha);
    }
}
/**
 * creamos la clase prestamo para modelar una transaccion de prestamo completa. guardar splo el libro
 * no era suficiente; necesitabamos asociarlo al usarioy la fecha de la operacion para aplir ese conjunto en nuestra historial lifo
 * faciliada para desahcer operaciones
 * cuando la clase biblioteca ejecuta seshacerUltimoprestamp, extrae un objeto prestamo de la pila
 * gracias a a que este objeto conserva la referencia directa al libro, podemos cambiar inmediadatemnete su esta estado a disponible
 * 
 */