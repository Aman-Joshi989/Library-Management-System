import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library implements LibraryManagement {
    private final List<Book> books;
    private final List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to library.");
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
        System.out.println("User '" + user.getUserId() + "' registered.");
    }

    @Override
    public void searchBook(String title) {
        books.stream()
             .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
             .forEach(System.out::println);
    }

    @Override
    public void borrowBook(String userId, String bookId) {
        Optional<User> user = users.stream().filter(u -> u.getUserId().equals(userId)).findFirst();
        Optional<Book> book = books.stream().filter(b -> b.getBookId().equals(bookId)).findFirst();

        if (user.isPresent() && book.isPresent()) {
            if (book.get().isAvailable()) {
                book.get().setAvailable(false);
                user.get().borrowBook(book.get());
                System.out.println("Book '" + book.get().getTitle() + "' borrowed by '" + user.get().getUserId() + "'.");
            } else {
                System.out.println("Error: Book is already borrowed.");
            }
        } else {
            System.out.println("Error: User or book not found.");
        }
    }

    @Override
    public void returnBook(String userId, String bookId) {
        Optional<User> user = users.stream().filter(u -> u.getUserId().equals(userId)).findFirst();

        if (user.isPresent()) {
            Optional<Book> book = user.get().getBorrowedBooks().stream().filter(b -> b.getBookId().equals(bookId)).findFirst();
            if (book.isPresent()) {
                book.get().setAvailable(true);
                user.get().returnBook(book.get());
                System.out.println("Book '" + book.get().getTitle() + "' returned by '" + user.get().getUserId() + "'.");
            } else {
                System.out.println("Error: Book not borrowed by this user.");
            }
        } else {
            System.out.println("Error: User not found.");
        }
    }
}
