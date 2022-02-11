package mock;

import application.book.BookDto;
import application.book.search.BookAllSearchInputData;
import application.book.search.BookSearchByIdInputData;
import application.book.search.BookSearchByNameInputData;
import application.book.search.IBookSearchInputPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockBookSearchInteractor implements IBookSearchInputPort {
    @Override
    public List<BookDto> handle(BookSearchByNameInputData inputData) {
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto("1", inputData.getBookName(), false));
        bookDtoList.add(new BookDto("2", inputData.getBookName(), false));
        bookDtoList.add(new BookDto("3", inputData.getBookName(), true));
        return bookDtoList;
    }

    @Override
    public Optional<BookDto> handle(BookSearchByIdInputData inputData) {
        return Optional.of(new BookDto("1", inputData.getId(), false));
    }

    @Override
    public List<BookDto> handle(BookAllSearchInputData inputData) {
        List<BookDto> bookDtoList = new ArrayList<>();
        bookDtoList.add(new BookDto("1", "test1", false));
        bookDtoList.add(new BookDto("2", "test2", false));
        bookDtoList.add(new BookDto("3", "test3", true));
        return bookDtoList;
    }
}
