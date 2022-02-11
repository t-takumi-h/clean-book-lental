package mock;

import application.book.IBookRepository;
import application.book.borrow.IBookBorrowInputPort;
import application.book.create.IBookCreateInputPort;
import application.book.delete.IBookDeleteInputPort;
import application.book.returnb.IBookReturnInputPort;
import application.book.search.IBookSearchInputPort;
import container.IDependencyInjectionContainer;
import domain.model.book.IBookFactory;
import repository.inMemory.book.InMemoryBookFactory;
import repository.inMemory.book.InMemoryBookRepository;

public class MockDependencyInjectionContainer implements IDependencyInjectionContainer {
    private IBookRepository bookRepository;
    private IBookFactory bookFactory;
    private IBookSearchInputPort bookSearchInputPort;
    private IBookCreateInputPort bookCreateInputPort;
    private IBookReturnInputPort bookReturnInputPort;
    private IBookDeleteInputPort bookDeleteInputPort;

    public MockDependencyInjectionContainer() {
        this.bookRepository = new InMemoryBookRepository();
        this.bookFactory = new InMemoryBookFactory();
        this.bookSearchInputPort = new MockBookSearchInteractor();
        this.bookCreateInputPort = new MockBookCreateInteractor();
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
        return null;
    }

    @Override
    public IBookReturnInputPort getBookReturnInputPort() {
        return null;
    }

    @Override
    public IBookDeleteInputPort getBookDeleteInputPort() {
        return null;
    }
}
