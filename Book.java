public class Book {
    private final String bookId;
    private final String title;
    private final String author;
    private final String isbn;
    private Boolean isAvailable;


    public Book(String bookId, String title, String author, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override 
    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author + "ISBN: " + isbn + ", Available: " + isAvailable;
    }
}



