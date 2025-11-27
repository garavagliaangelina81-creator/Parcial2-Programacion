public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===\n");

    //Crea biblioteca
        Library library = new Library("Biblioteca de la Universidad");

        
        Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Cien años de soledad", "978-84-376-0495-4", "Gabriel García Márquez", 1967);
        Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book book4 = new Book("El amor en los tiempos del cólera", "978-84-376-0497-8", "Gabriel García Márquez", 1985);

        // Agrega libros
        System.out.println("📚 AGREGANDO LIBROS A LA BIBLIOTECA...");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("   ✔ Libros agregados.\n");

        // Mostrar estado de la biblioteca
        System.out.println(library);
        System.out.println(library.getStatistics());

        // Busqueda por titulo
        System.out.println("\n🔍 BÚSQUEDA POR TÍTULO ('amor'):");
        LinkedList<Book> titleSearch = library.findBooksByTitle("amor");
        for (int i = 0; i < titleSearch.size(); i++) {
            System.out.println("  - " + titleSearch.get(i));
        }

        // Busqueda por autor
        System.out.println("\n🔍 BÚSQUEDA POR AUTOR ('García Márquez'):");
        LinkedList<Book> authorSearch = library.findBooksByAuthor("Gabriel García Márquez");
        for (int i = 0; i < authorSearch.size(); i++) {
            System.out.println("  - " + authorSearch.get(i));
        }

        // Búsqueda por ISBN
        System.out.println("\n🔍 BUSCANDO ISBN '978-84-376-0496-1':");
        Book encontrado = library.findBookByIsbn("978-84-376-0496-1");
        if (encontrado != null) {
            System.out.println("   ✔ Encontrado: " + encontrado);
        } else {
            System.out.println("   ✖ No encontrado.");
        }


        // prestamos
        System.out.println("\n --- LIBROS PRESTADOS ---");

        if (book1.lend()) System.out.println("   ✔ Se prestó: " + book1.getTitle());
        if (book3.lend()) System.out.println("   ✔ Se prestó: " + book3.getTitle());

        // Intento de préstamo repetido
        if (!book1.lend()) {
            System.out.println("   ✖ Error: '" + book1.getTitle() + "' ya está prestado.");
        }

        // Estadísticas luego de prestar
        System.out.println("\n📊 ESTADÍSTICAS DESPUÉS DE PRÉSTAMOS:");
        System.out.println(library.getStatistics());
    

         System.out.println("\n🎉 Demostración completada.");


    }
}
