package container;

import application.book.IBookRepository;
import application.book.borrow.IBookBorrowInputPort;
import application.book.create.IBookCreateInputPort;
import application.book.delete.IBookDeleteInputPort;
import application.book.returnb.IBookReturnInputPort;
import application.book.search.IBookSearchInputPort;
import domain.model.book.IBookFactory;

public interface IDependencyInjectionContainer {
    public IBookRepository getBookRepository();
    public IBookFactory getBookFactory();
    public IBookSearchInputPort getBookSearchInputPort();
    public IBookCreateInputPort getBookCreateInputPort();
    public IBookBorrowInputPort getBookBorrowInputPort();
    public IBookReturnInputPort getBookReturnInputPort();
    public IBookDeleteInputPort getBookDeleteInputPort();
}
