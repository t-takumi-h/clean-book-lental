package repository.inMemory.book;

import domain.model.book.Book;
import domain.model.book.BookId;
import domain.model.book.BookName;
import domain.model.book.IBookFactory;

import java.util.UUID;

public class InMemoryBookFactory implements IBookFactory {
    @Override
    public Book create(BookName name) {

        return new Book(
                new BookId(UUID.randomUUID().toString()),
                name,
                false
        );
    }
}
