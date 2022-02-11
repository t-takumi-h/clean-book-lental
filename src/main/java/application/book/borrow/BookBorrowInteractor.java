package application.book.borrow;

import application.book.BookDto;
import application.book.IBookRepository;
import application.book.create.BookCreateInputData;
import application.book.create.IBookCreateInputPort;
import domain.model.book.BookId;
import domain.model.book.BookName;
import domain.model.book.IBookFactory;
import domain.service.BookService;

import java.util.NoSuchElementException;
import java.util.Optional;

public class BookBorrowInteractor implements IBookBorrowInputPort {
    private IBookFactory bookFactory;
    private IBookRepository bookRepository;

    public BookBorrowInteractor(IBookFactory bookFactory, IBookRepository bookRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto handle(BookBorrowInputData inputData) {
        var bookId = new BookId(inputData.getBookId());
        var bookDto = bookRepository.find(bookId);
        if(bookDto.isEmpty()){
            throw new RuntimeException("対象の本が見つかりませんでした。");
        }
        var lentBook = bookDto.get().createBookInstance();
        var bookService = new BookService();
        if(!bookService.borrowBook(lentBook)){
            throw new RuntimeException("貸出中のため借りることはできません。");
        }
        var lentBookDto = new BookDto(lentBook);
        var isSuccess = bookRepository.update(lentBookDto);
        if(!isSuccess){
            throw new RuntimeException("貸出処理に失敗しました。");
        }
        return lentBookDto;
    }
}
