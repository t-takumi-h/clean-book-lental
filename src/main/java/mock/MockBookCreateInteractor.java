package mock;

import application.book.BookDto;
import application.book.create.BookCreateInputData;
import application.book.create.IBookCreateInputPort;

public class MockBookCreateInteractor implements IBookCreateInputPort {
    @Override
    public BookDto handle(BookCreateInputData inputData) {
        return new BookDto("1", inputData.getBookName(), false);
    }
}
