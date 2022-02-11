package application.book.borrow;

public class BookBorrowInputData {
    private String bookId;

    public BookBorrowInputData(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
