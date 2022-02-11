package application.book;

import domain.model.book.Book;
import domain.model.book.BookId;
import domain.model.book.BookName;

public class BookDto {
    private String bookId;
    private String bookName;
    private boolean isLent;

    public BookDto(String bookId, String bookName, boolean isLent) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isLent = isLent;
    }

    public BookDto(Book book) {
        this.bookId = book.getId().getId();
        this.bookName = book.getBookName().getBookName();
        this.isLent = book.isLent();
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isLent() {
        return isLent;
    }

    public Book createBookInstance(){
        return new Book(new BookId(this.bookId), new BookName(this.bookName), this.isLent);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof BookDto)){
            return false;
        }
        if(this.bookId == ((BookDto) obj).getBookId() &&
        this.bookName == ((BookDto) obj).getBookName() &&
        this.isLent == ((BookDto) obj).isLent()) {
            return true;
        }
        return false;
    }
}
