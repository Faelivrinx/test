package com.bookstore.service.impl;

import com.bookstore.domain.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominik on 01.05.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();

        List<Book> activeBooks = new ArrayList<>();

        for(Book book: bookList){
            if(book.isActive()){
                activeBooks.add(book);
            }
        }
        return activeBooks;
    }

    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> blurrySearch(String keyword) {
        List<Book> bookList = bookRepository.findByTitleContaining(keyword);

        List<Book> activeBooks = new ArrayList<>();

        for(Book book: bookList){
            if(book.isActive()){
                activeBooks.add(book);
            }
        }
        return activeBooks;
    }

    @Override
    public void Remove(Long id) {
        bookRepository.delete(id);
    }
}
