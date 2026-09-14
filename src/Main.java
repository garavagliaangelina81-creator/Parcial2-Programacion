public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===\n");

        // 1. Instanciamos laclase biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca UNVIME");

        // 2. Creación de libros

        Libro libro1 = new Libro("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Libro libro2 = new Libro("Cien años de soledad", "978-84-376-0495-4", "Gabriel García Márquez", 1967);
        Libro libro3 = new Libro("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Libro libro4 = new Libro("El amor en los tiempos del cólera", "978-84-376-0497-8", "Gabriel García Márquez", 1985);

        // 3. Agregar libros al catálogo (Prueba de ListaEnlazada)
        System.out.println("📚 AGREGANDO LIBROS A LA BIBLIOTECA...");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        System.out.println("   ✔ Libros agregados. Total en catálogo: " + biblioteca.getLibros().obtenerCantidad() + "\n");

       // 4. Búsqueda por título usando la lógica de la Biblioteca, busca todas las coincidencias del texto enviado e imprime el resultado
        System.out.println("🔍 BÚSQUEDA POR TÍTULO ('El Quijote'):");
        ListaEnlazada<Libro> resultadosTitulo = biblioteca.buscarPorTitulo("El Quijote");
        for (int i = 0; i < resultadosTitulo.obtenerCantidad(); i++) {
            System.out.println("   - " + resultadosTitulo.obtener(i));
        }

        // 5. Búsqueda por ISBN
        System.out.println("\n🔍 BUSCANDO ISBN '978-84-376-0496-1':");
        Libro encontrado = biblioteca.buscarPorIsbn("978-84-376-0496-1");

        if (encontrado != null) {
            System.out.println("   ✔ Encontrado: " + encontrado);
        } else {
            System.out.println("   ✖ No encontrado.");
        }

        // 6. Registro de Préstamos (Prueba de Pila a través de registrarPrestamo)
        System.out.println("\n📋 REGISTRANDO PRÉSTAMOS EN EL HISTORIAL (PILA)...");
        
        boolean exito1 = biblioteca.registrarPrestamo(libro1, "Juan Pérez", "10/05/2026");
        if (exito1) {
            System.out.println("   ✔ Se prestó: " + libro1.getTitulo() + " a Juan Pérez");
        }

        boolean exito2 = biblioteca.registrarPrestamo(libro3, "María Gómez", "11/05/2026");
        if (exito2) {
            System.out.println("   ✔ Se prestó: " + libro3.getTitulo() + " a María Gómez");
        }

        System.out.println("\n📊 " + biblioteca.obtenerEstadisticas());
        System.out.println("🔝 Último préstamo realizado (Cima/Tope): " + biblioteca.verUltimoPrestamo());

        // 7. Deshacer el último préstamo (Prueba de Pila - Desapilar / Pop)
        System.out.println("\n↩️ DESHACIENDO ÚLTIMO PRÉSTAMO (DESAPILAR)...");
        Prestamo deshecho = biblioteca.deshacerUltimoPrestamo();
        
        if (deshecho != null) {
            System.out.println("   ✔ Se revirtió el préstamo de: " + deshecho.getLibro().getTitulo());
            System.out.println("   📖 El libro vuelve a estar disponible.");
        }

        System.out.println("\n📊 " + biblioteca.obtenerEstadisticas());
        System.out.println("🔝 Nueva Cima de la Pila: " + biblioteca.verUltimoPrestamo());

        System.out.println("\n🎉 Demostración completada con éxito.");
    }
}
/**
 * main muestra un solo archivo el control total sobre las dos estructuras requeridas:
 * listaenlazada: carga elementos, recorridos iterativos y filtrados por atributos (titulo e isbn)
 */
/**
 * pila: funcionameinto estricto del compartamiento apilar agregar al historial y desapilar para revertir la ultima transaccion reaqlizada
 */