public class Libro {
    // Atributos (Encapsulamiento)
    private String titulo;
    private String isbn;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    private int vecesPrestado;

    // Constructor
    public Libro(String titulo, String isbn, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;      // Al crearse,libro nace disponible
        this.vecesPrestado = 0;     // Nace sin préstamos previos
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public boolean isDisponible() { return disponible; }
    public int getVecesPrestado() { return vecesPrestado; }

    // Setters para modificar los atributos
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

// metodo lend (prestar Libro)
    public boolean prestarLibro() {
        if (this.disponible) {
            this.disponible = false;
            this.vecesPrestado++;
            return true;
        }
        return false;
    }

    // metodo remove(devolver libro)
    public void devolverLibro() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + 
               ", ISBN: " + isbn + 
               ", Autor: " + autor + 
               ", Año: " + anioPublicacion + 
               ", Estado: " + (disponible ? "Disponible" : "Prestado") + 
               ", Veces prestado: " + vecesPrestado;
    }
}





