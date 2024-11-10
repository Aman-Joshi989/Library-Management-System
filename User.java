import java.util.ArrayList;
import java.util.List;


public class User {
    private final String userId;
    private final String name;
    private final List<Book> borrowedBooks;

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();

    }

    public String getUserId(){
        return userId;
    }   

    public String getName(){
        return name;
    }

    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void BorrowBook(Book book){
        borrowedBooks.add(book);
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    @Override
    public String toString(){
        return "User ID: " + userId + ", Name: " + name + ", Borrowed Books: " + borrowedBooks.size();
    }

    public void borrowBook(Book book) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrowBook'");
    }

    
}
