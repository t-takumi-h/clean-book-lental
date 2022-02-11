package application.book.search;

import application.book.BookDto;

import java.util.List;
import java.util.Optional;

public interface IBookSearchInputPort {
    public List<BookDto> handle(BookSearchByNameInputData inputData);
    public List<BookDto> handle(BookAllSearchInputData inputData);
    public Optional<BookDto> handle(BookSearchByIdInputData inputData);
}
