package application.book.search;

import application.book.BookDto;
import application.book.IBookRepository;
import domain.model.book.BookId;
import domain.model.book.BookName;
import domain.model.book.IBookFactory;

import java.util.List;
import java.util.Optional;

public class BookSearchInteractor implements IBookSearchInputPort {
    private IBookFactory bookFactory;
    private IBookRepository bookRepository;

    public BookSearchInteractor(IBookFactory bookFactory, IBookRepository bookRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> handle(BookSearchByNameInputData inputData) {
        var bookName = new BookName(inputData.getBookName());
        return bookRepository.find(bookName);
    }

    @Override
    public Optional<BookDto> handle(BookSearchByIdInputData inputData){
        var bookId = new BookId(inputData.getId());
        return bookRepository.find(bookId);
    }

    @Override
    public List<BookDto> handle(BookAllSearchInputData inputData) {
        return bookRepository.findAll();
    }
}
