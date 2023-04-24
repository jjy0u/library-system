package src.main.java;

public class Book {
    private String title ;
    private String author;
    private String genre;
    private String subgenre;
    private String publisher;
    private int loanCount;

    public Book(String title, String author, String genre, String subgenre, String publisher,int loanCount) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.subgenre = subgenre;
        this.publisher = publisher;
        this.loanCount = loanCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
