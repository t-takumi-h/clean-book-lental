package application.book.borrow;

import application.book.BookDto;
import application.book.create.BookCreateInputData;

import java.util.Optional;

public interface IBookBorrowInputPort {
    public BookDto handle(BookBorrowInputData inputData);
}
