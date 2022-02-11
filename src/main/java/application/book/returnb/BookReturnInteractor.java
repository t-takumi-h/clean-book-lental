package application.book.returnb;

import application.book.BookDto;
import application.book.IBookRepository;
import application.book.borrow.BookBorrowInputData;
import application.book.borrow.IBookBorrowInputPort;
import domain.model.book.BookId;
import domain.model.book.IBookFactory;
import domain.service.BookService;

public class BookReturnInteractor implements IBookReturnInputPort {
    private IBookFactory bookFactory;
    private IBookRepository bookRepository;

    public BookReturnInteractor(IBookFactory bookFactory, IBookRepository bookRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto handle(BookReturnInputData inputData) {
        var bookId = new BookId(inputData.getBookId());
        var bookDto = bookRepository.find(bookId);
        if(bookDto.isEmpty()){
            throw new RuntimeException("対象の本が見つかりませんでした。");
        }
        var returnBook = bookDto.get().createBookInstance();
        var bookService = new BookService();
        if(!bookService.returnBook(returnBook)){
            throw new RuntimeException("返却済みのため返却することはできません。");
        }
        var returnBookDto = new BookDto(returnBook);
        var isSuccess = bookRepository.update(returnBookDto);
        if(!isSuccess){
            throw new RuntimeException("返却処理に失敗しました。");
        }
        return returnBookDto;
    }
}
