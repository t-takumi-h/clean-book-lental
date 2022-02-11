package application.book.delete;

import application.book.BookDto;
import application.book.IBookRepository;
import application.book.borrow.BookBorrowInputData;
import application.book.borrow.IBookBorrowInputPort;
import domain.model.book.BookId;
import domain.model.book.IBookFactory;
import domain.service.BookService;

public class BookDeleteInteractor implements IBookDeleteInputPort {
    private IBookFactory bookFactory;
    private IBookRepository bookRepository;

    public BookDeleteInteractor(IBookFactory bookFactory, IBookRepository bookRepository) {
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto handle(BookDeleteInputData inputData) {
        var bookId = new BookId(inputData.getBookId());
        var deleteBookDto = bookRepository.find(bookId);
        if(deleteBookDto.isEmpty()){
            throw new RuntimeException("対象の本が見つかりませんでした。");
        }
        var isSuccess = bookRepository.delete(deleteBookDto.get());
        if(!isSuccess){
            throw new RuntimeException("削除処理に失敗しました。");
        }
        return deleteBookDto.get();
    }
}
