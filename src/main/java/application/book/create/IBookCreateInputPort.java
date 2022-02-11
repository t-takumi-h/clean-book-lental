package application.book.create;

import application.book.BookDto;

public interface IBookCreateInputPort {
    public BookDto handle(BookCreateInputData inputData);
}
