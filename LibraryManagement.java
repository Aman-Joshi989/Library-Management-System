public interface LibraryManagement {
    void addBook(Book book);
    void registerUser(User user);
    void searchBook(String title);
    void borrowBook(String userId, String bookId);
    void returnBook(String userId, String bookId);
}
