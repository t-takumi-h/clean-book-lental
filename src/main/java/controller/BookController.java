package controller;

import application.book.BookDto;
import application.book.borrow.BookBorrowInputData;
import application.book.borrow.IBookBorrowInputPort;
import application.book.create.BookCreateInputData;
import application.book.create.IBookCreateInputPort;
import application.book.delete.BookDeleteInputData;
import application.book.delete.IBookDeleteInputPort;
import application.book.returnb.BookReturnInputData;
import application.book.returnb.IBookReturnInputPort;
import application.book.search.BookAllSearchInputData;
import application.book.search.BookSearchByIdInputData;
import application.book.search.BookSearchByNameInputData;
import application.book.search.IBookSearchInputPort;
import domain.model.book.Book;
import storage.BookDetail;

import java.util.List;
import java.util.Optional;

public class BookController {
    private IBookCreateInputPort bookCreateInputPort;
    private IBookSearchInputPort bookSearchInputPort;
    private IBookBorrowInputPort bookBorrowInputPort;
    private IBookReturnInputPort bookReturnInputPort;
    private IBookDeleteInputPort bookDeleteInputPort;

    public BookController(IBookCreateInputPort bookCreateInputPort,
                          IBookSearchInputPort bookSearchInputPort,
                          IBookBorrowInputPort bookBorrowInputPort,
                          IBookReturnInputPort bookReturnInputPort,
                          IBookDeleteInputPort bookDeleteInputPort) {
        this.bookCreateInputPort = bookCreateInputPort;
        this.bookSearchInputPort = bookSearchInputPort;
        this.bookBorrowInputPort = bookBorrowInputPort;
        this.bookReturnInputPort = bookReturnInputPort;
        this.bookDeleteInputPort = bookDeleteInputPort;
    }

    public BookDto createBook(String bookName){
        var createBookInput = new BookCreateInputData(bookName);
        return bookCreateInputPort.handle(createBookInput);
    }

    public List<BookDto> searchBook(String bookName){
        var searchBookInput = new BookSearchByNameInputData(bookName);
        return bookSearchInputPort.handle(searchBookInput);
    }

    public Optional<BookDto> searchBookById(String bookId){
        var bookSearchByIdInputData = new BookSearchByIdInputData(bookId);
        return bookSearchInputPort.handle(bookSearchByIdInputData);
    }

    public List<BookDto> searchAllBook(){
        var searchAllBookInput = new BookAllSearchInputData();
        return bookSearchInputPort.handle(searchAllBookInput);
    }

    public BookDto borrowBook(String bookId){
        var bookBorrowInputData = new BookBorrowInputData(bookId);
        return bookBorrowInputPort.handle(bookBorrowInputData);
    }

    public BookDto returnBook(String bookId){
        var bookReturnInputData = new BookReturnInputData(bookId);
        return bookReturnInputPort.handle(bookReturnInputData);
    }

    public BookDto deleteBook(String bookId){
        var bookDeleteInputData = new BookDeleteInputData(bookId);
        return bookDeleteInputPort.handle(bookDeleteInputData);
    }


}
