package repository.inMemory.book;

import application.book.BookDto;
import domain.model.book.BookId;
import domain.model.book.BookName;
import application.book.IBookRepository;
import storage.BookDetail;
import storage.InMemoryBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements IBookRepository {
    private InMemoryBook inMemoryBook;

    public InMemoryBookRepository() {
        this.inMemoryBook = new InMemoryBook();
    }

    @Override
    public boolean save(BookDto bookDto) {
        var bookDetail = transformToBookDetail(bookDto);
        return inMemoryBook.insertBook(bookDetail);
    }

    @Override
    public Optional<BookDto> find(BookId bookId) {
        var foundBook = inMemoryBook.selectById(bookId.getId());
        if(foundBook.isEmpty()){
            return  Optional.empty();
        }
        return Optional.of(transformToBookDto(foundBook.get()));
    }

    @Override
    public List<BookDto> find(BookName bookName) {
        var foundBooks = inMemoryBook.selectByName(bookName.getBookName());
        List<BookDto> bookDtoList = new ArrayList<>();
        transformToBookDtoList(foundBooks, bookDtoList);
        return bookDtoList;
    }

    @Override
    public List<BookDto> findAll() {
        var bookDetailList = inMemoryBook.selectAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        transformToBookDtoList(bookDetailList, bookDtoList);
        return bookDtoList;
    }

    @Override
    public boolean delete(BookDto bookDto) {
        var bookDetail = transformToBookDetail(bookDto);
        return inMemoryBook.deleteBook(bookDetail);
    }

    @Override
    public boolean update(BookDto bookDto) {
        var bookDetail = transformToBookDetail(bookDto);
        return inMemoryBook.updateBook(bookDetail);
    }

    private void transformToBookDtoList(List<BookDetail> bookDetailList, List<BookDto> bookDtoList) {
        for(var book : bookDetailList){
            bookDtoList.add(transformToBookDto(book));
        }
    }

    private BookDto transformToBookDto(BookDetail bookDetail) {
        return new BookDto(bookDetail.getBookId(), bookDetail.getBookName(), bookDetail.isLent());
    }

    private BookDetail transformToBookDetail(BookDto bookDto) {
        return new BookDetail(bookDto.getBookId(), bookDto.getBookName(), bookDto.isLent());
    }
}
