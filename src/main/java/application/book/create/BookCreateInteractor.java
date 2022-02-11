package application.book.create;

import application.book.BookDto;
import application.book.IBookRepository;
import domain.model.book.BookName;
import domain.model.book.IBookFactory;

public class BookCreateInteractor implements IBookCreateInputPort{
    private IBookFactory bookFactory;
    private IBookRepository bookRepository;

    public BookCreateInteractor(IBookFactory bookFactory, IBookRepository bookRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto handle(BookCreateInputData inputData) {
        var bookName = new BookName(inputData.getBookName());
        var newBook = bookFactory.create(bookName);
        var bookDto = new BookDto(newBook);
        var isSuccess=bookRepository.save(bookDto);
        if(!isSuccess){
            throw new RuntimeException("本を登録できませんでした。");
        }
        return bookDto;
    }
}
