package application.book.delete;

import application.book.BookDto;
import application.book.borrow.BookBorrowInputData;

public interface IBookDeleteInputPort {
    public BookDto handle(BookDeleteInputData inputData);
}
