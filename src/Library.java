public class Library {
    private String name;
    private LinkedList<Book> books;

    private Stack<LoanOperation> loanHistory = new Stack<>();


    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean addBook(Book book) {
        if (book != null) {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        if (book != null) {
            return books.remove(book);
        }
        return false;
    }

    // busquedas

    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getIsbn().equalsIgnoreCase(isbn)) {
                return b;
            }
        }
        return null;
    }

    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> found = new LinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                found.add(b);
            }
        }

        return found;
    }

    public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> found = new LinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                found.add(b);
            }
        }

        return found;
    }

    //  Consultas 

    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> available = new LinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isAvailable()) {
                available.add(b);
            }
        }

        return available;
    }

    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> loaned = new LinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (!b.isAvailable()) {
                loaned.add(b);
            }
        }

        return loaned;
    }

    //  Estadísticas 

    public String getStatistics() {
        int totalBooks = books.size();
        int availableBooks = getAvailableBooks().size();
        int loanedBooks = getLoanedBooks().size();

        return String.format(
            "Estadísticas de la Biblioteca:\n" +
            "- Total de Libros: %d\n" +
            "- Libros Disponibles: %d\n" +
            "- Libros Prestados: %d\n",
            totalBooks, availableBooks, loanedBooks
        );
    }

    @Override
    public String toString() {
        return "Biblioteca: " + name + " | Libros almacenados: " + books.size();
    }

    // Préstamos

    public void registrarPrestamo(Book book, String user, String date) {
        if (book != null && book.isAvailable()) {
            book.lend();
            LoanOperation op = new LoanOperation(book, user, date);
            loanHistory.push(op);
        }
    }

    public LoanOperation verUltimoPrestamo() {
        return loanHistory.peek();
    }

    public LoanOperation deshacerUltimoPrestamo() {
        LoanOperation op = loanHistory.pop();

        if (op != null) {
            op.getBook().returnBook();
        }

        return op;
    }
}

