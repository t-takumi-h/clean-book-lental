package application.book;

import domain.model.book.Book;
import domain.model.book.BookId;
import domain.model.book.BookName;

import java.util.List;
import java.util.Optional;

public interface IBookRepository {
    public boolean save(BookDto book);
    public Optional<BookDto> find(BookId bookId);
    public List<BookDto> find(BookName bookName);
    public List<BookDto> findAll();
    public boolean delete(BookDto book);
    public boolean update(BookDto book);
}
