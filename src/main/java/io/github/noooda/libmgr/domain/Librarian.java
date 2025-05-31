package io.github.noooda.libmgr.domain;

import java.util.List;
import java.util.ArrayList;

public class Librarian {
    List<Book> booklist = new ArrayList<>();

    public List<Book> showBookList() {
        return this.booklist;
    }

    public List<Book> findBooksByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : booklist) {
            if (book.getTitle().contains(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> findBooksByAuthor(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : booklist) {
            if (book.getAuthor().contains(keyword)) {
                results.add(book);
            }
        }
        return results;
    }

    public void registerBook(String title, String author) {
        Book book = new Book(title, author);
        this.booklist.add(book);
    }

}
