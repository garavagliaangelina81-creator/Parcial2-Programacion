public class LoanOperation {
    private Book book;
    private String user;
    private String date;

    public LoanOperation(Book book, String user, String date) {
        this.book = book;
        this.user = user;
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public String getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Préstamo -> Libro: " + book.getTitle() +
               ", Usuario: " + user +
               ", Fecha: " + date;
    }
}
