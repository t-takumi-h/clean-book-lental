package domain.model.book;

public class BookName {
    private String bookName;

    public BookName(String bookName) {
        if(bookName == null){
            throw new NullPointerException();
        }
        if(bookName.length() < 1){
            throw new RuntimeException("本の名前がゼロ文字です。");
        }
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }
}
