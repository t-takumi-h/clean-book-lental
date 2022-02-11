package storage;

import application.book.BookDto;

public class BookDetail {
    private String bookId;
    private String bookName;
    private boolean isLent;

    public BookDetail(String bookId, String bookName, boolean isLent) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isLent = isLent;
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

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof BookDetail)){
            return false;
        }
        if(this.bookId == ((BookDetail) obj).getBookId()){
            return true;
        }
        return false;
    }
}
