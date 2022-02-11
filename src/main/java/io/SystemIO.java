package io;

import application.book.BookDto;
import container.IDependencyInjectionContainer;
import controller.BookController;

import java.util.List;
import java.util.Scanner;

public class SystemIO {
    private IDependencyInjectionContainer dependencyInjectionContainer;

    public SystemIO(IDependencyInjectionContainer dependencyInjectionContainer) {
        this.dependencyInjectionContainer = dependencyInjectionContainer;
    }

    public void process() {
        var bookController = new BookController(
                dependencyInjectionContainer.getBookCreateInputPort(),
                dependencyInjectionContainer.getBookSearchInputPort(),
                dependencyInjectionContainer.getBookBorrowInputPort(),
                dependencyInjectionContainer.getBookReturnInputPort(),
                dependencyInjectionContainer.getBookDeleteInputPort()
        );
        while (true) {
            try{
                System.out.println("書籍管理システムです。");
                System.out.println("実施する処理No.を入力してください。");
                System.out.println("1:登録　2:検索 3:貸出 4:返却 5:削除");
                var proccessNumber = inputConsole();
                switch (proccessNumber) {
                    case "1":
                        createBookProcess(bookController);
                        break;
                    case "2":
                        searchBookProcess(bookController);
                        break;
                    case "3":
                        borrowBookProcess(bookController);
                        break;
                    case "4":
                        returnBookProcess(bookController);
                        break;
                    case "5":
                        deleteBookProcess(bookController);
                        break;
                    default:
                        undefinedBookProcess();
                        break;
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("もういちどやり直してください");
                outputTerminal();
            }
        }
    }

    private static void deleteBookProcess(BookController bookController) {
        System.out.println("削除する本のIDを入力してください。");
        var deleteBookId = inputConsole();
        var deleteBook = bookController.deleteBook(deleteBookId);
        System.out.println("本を削除ました。");
        outputBook(deleteBook);
        outputTerminal();
    }

    private static void returnBookProcess(BookController bookController) {
        System.out.println("返却する本のIDを入力してください。");
        var returnBookId = inputConsole();
        var returnBook = bookController.returnBook(returnBookId);
        System.out.println("本を返却ました。");
        outputBook(returnBook);
        outputTerminal();
    }

    private static void borrowBookProcess(BookController bookController) {
        System.out.println("貸出する本のIDを入力してください。");
        var borrowBookId = inputConsole();
        var borrowBook = bookController.borrowBook(borrowBookId);
        System.out.println("本を貸出ました。");
        outputBook(borrowBook);
        outputTerminal();
    }

    private static void undefinedBookProcess() {
        System.out.println("入力した値が不正です。");
        outputTerminal();
    }

    private static void searchBookProcess(BookController bookController) {
        System.out.println("検索方法のNo.を入力してください。");
        System.out.println("1:本の名前で検索　2:本のIDで検索 3:すべての本を検索");
        var searchNumber = inputConsole();
        switch (searchNumber){
            case "1":
                System.out.println("検索する本の名前を入力してください。");
                var searchBookName = inputConsole();
                var searchBooks = bookController.searchBook(searchBookName);
                if (searchBooks.isEmpty()) {
                    System.out.println("検索した本は見つかりませんでした。");
                    outputTerminal();
                    return;
                }
                System.out.println("検索した本が見つかりました。");
                outputBookList(searchBooks);
                int count;
                break;
            case "2":
                System.out.println("検索する本のIDを入力してください。");
                var searchBooId = inputConsole();
                var searchBook = bookController.searchBookById(searchBooId);
                if (searchBook.isEmpty()) {
                    System.out.println("検索した本は見つかりませんでした。");
                    outputTerminal();
                    return;
                }
                System.out.println("検索した本が見つかりました。");
                outputBook(searchBook.get());
                outputTerminal();
                break;
            case "3":
                var searchAllBook = bookController.searchAllBook();
                if (searchAllBook.isEmpty()) {
                    System.out.println("本は登録されていません。");
                    outputTerminal();
                    return;
                }
                outputBookList(searchAllBook);
                break;
            default:
                undefinedBookProcess();
                break;
        }

    }

    private static void outputBook(BookDto bookDto) {
        System.out.println("ID:" + bookDto.getBookId());
        System.out.println("Name:" + bookDto.getBookName());
        System.out.println("貸出:" + (bookDto.isLent() ? "不可" : "可"));
    }

    private static void outputBookList(List<BookDto> searchBooks) {
        int count = 1;
        for (var searchBook : searchBooks) {
            System.out.println("No:" + count);
            outputBook(searchBook);
            outputTerminal();
            count++;
        }
    }


    private static void createBookProcess(BookController bookController) {
        System.out.println("登録する本の名前を入力してください。");
        var createBookName = inputConsole();
        var createdBook = bookController.createBook(createBookName);
        System.out.println("本を登録しました。");
        outputBook(createdBook);
        outputTerminal();
    }

    private static String inputConsole(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void outputTerminal(){
        System.out.println("-----------------------------------");
    }
}
