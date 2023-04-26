import java.time.LocalDate;

public class LoanedBook {
    private Book book;
    private LibraryUser loaner;
    private LocalDate dateLoaned;
    private LocalDate dueDate;

    public LoanedBook(Book book, LibraryUser loaner) {
        this.book = book;
        this.dateLoaned = LocalDate.now();
        this.dueDate = LocalDate.now().plusMonths(1);
        this.loaner = loaner;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LibraryUser getLoaner() {
        return loaner;
    }

    public void setLoaner(LibraryUser loaner) {
        this.loaner = loaner;
    }

    public LocalDate getDateLoaned() {
        return dateLoaned;
    }

    public void setDateLoaned(LocalDate dateLoaned) {
        this.dateLoaned = dateLoaned;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return  book +
                " was loaned by " + loaner +
                " on " + dateLoaned +
                " and is due " + dueDate
                ;

    }
}
