package application.book.delete;

public class BookDeleteInputData {
    private String bookId;

    public BookDeleteInputData(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
