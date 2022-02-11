package domain.model.book;

public class Book {
    private BookId id;
    private BookName bookName;
    private boolean isLent;

    public Book(BookId id, BookName bookName, boolean isLent) {
        this.id = id;
        this.bookName = bookName;
        this.isLent = isLent;
    }

    public void borrowBook(){
        this.isLent = true;
    }

    public void returnBook(){
        this.isLent = false;
    }

    public BookId getId() {
        return id;
    }

    public BookName getBookName() {
        return bookName;
    }

    public boolean isLent() {
        return isLent;
    }
}
