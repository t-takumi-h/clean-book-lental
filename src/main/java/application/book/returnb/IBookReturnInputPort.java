package application.book.returnb;

import application.book.BookDto;
import application.book.borrow.BookBorrowInputData;

public interface IBookReturnInputPort {
    public BookDto handle(BookReturnInputData inputData);
}
