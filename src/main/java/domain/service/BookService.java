package domain.service;

import domain.model.book.Book;

public class BookService {
    public boolean borrowBook(Book book){
        if(book.isLent()){
            return false;
        }
        book.borrowBook();
        return true;
    }

    public boolean returnBook(Book book){
        if(!book.isLent()){
            return false;
        }
        book.returnBook();
        return true;
    }
}
