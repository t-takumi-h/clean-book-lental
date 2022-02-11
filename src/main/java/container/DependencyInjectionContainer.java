package container;

import application.book.IBookRepository;
import application.book.borrow.BookBorrowInteractor;
import application.book.borrow.IBookBorrowInputPort;
import application.book.create.BookCreateInteractor;
import application.book.create.IBookCreateInputPort;
import application.book.delete.BookDeleteInteractor;
import application.book.delete.IBookDeleteInputPort;
import application.book.returnb.BookReturnInteractor;
import application.book.returnb.IBookReturnInputPort;
import application.book.search.BookSearchInteractor;
import application.book.search.IBookSearchInputPort;
import domain.model.book.IBookFactory;
import repository.inMemory.book.InMemoryBookFactory;
import repository.inMemory.book.InMemoryBookRepository;

public class DependencyInjectionContainer implements IDependencyInjectionContainer {
    private IBookRepository bookRepository;
    private IBookFactory bookFactory;
    private IBookSearchInputPort bookSearchInputPort;
    private IBookCreateInputPort bookCreateInputPort;
    private IBookBorrowInputPort bookBorrowInputPort;
    private IBookReturnInputPort bookReturnInputPort;
    private IBookDeleteInputPort bookDeleteInputPort;

    public DependencyInjectionContainer() {
        this.bookRepository = new InMemoryBookRepository();
        this.bookFactory = new InMemoryBookFactory();
        this.bookSearchInputPort = new BookSearchInteractor(bookFactory, bookRepository);
        this.bookCreateInputPort = new BookCreateInteractor(bookFactory, bookRepository);
        this.bookBorrowInputPort = new BookBorrowInteractor(bookFactory, bookRepository);
        this.bookReturnInputPort = new BookReturnInteractor(bookFactory, bookRepository);
        this.bookDeleteInputPort = new BookDeleteInteractor(bookFactory, bookRepository);
    }

    @Override
    public IBookRepository getBookRepository() {
        return bookRepository;
    }

    @Override
    public IBookFactory getBookFactory() {
        return bookFactory;
    }

    @Override
    public IBookSearchInputPort getBookSearchInputPort() {
        return bookSearchInputPort;
    }

    @Override
    public IBookCreateInputPort getBookCreateInputPort() {
        return bookCreateInputPort;
    }

    @Override
    public IBookBorrowInputPort getBookBorrowInputPort() {
        return bookBorrowInputPort;
    }

    @Override
    public IBookReturnInputPort getBookReturnInputPort() {
        return bookReturnInputPort;
    }

    @Override
    public IBookDeleteInputPort getBookDeleteInputPort() {
        return bookDeleteInputPort;
    }
}
