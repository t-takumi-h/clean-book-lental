package storage;

import domain.model.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryBook {
    private List<BookDetail> bookList;

    public InMemoryBook() {
        this.bookList = new ArrayList<>();
    }

    public boolean insertBook(BookDetail bookDetail){
        bookList.add(bookDetail);
        return true;
    }

    public List<BookDetail> selectByName(String bookName){
        return this.bookList.stream().filter(book -> book.getBookName().equals(bookName)).collect(Collectors.toList());
    }

    public Optional<BookDetail> selectById(String bookId){
        return this.bookList.stream().filter(book -> book.getBookId().equals(bookId)).findFirst();
    }

    public List<BookDetail> selectAll(){
        return this.bookList;
    }

    public boolean updateBook(BookDetail bookDetail){
        var index = this.bookList.indexOf(bookDetail);
        if(index < 0){
            return false;
        }
        bookList.set(index, bookDetail);
        return true;
    }

    public boolean deleteBook(BookDetail bookDetail){
        var index = this.bookList.indexOf(bookDetail);
        if(index < 0){
            return false;
        }
        bookList.remove(index);
        return true;
    }
}
