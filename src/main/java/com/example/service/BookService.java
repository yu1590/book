package com.example.service;

import com.example.pojo.Book;
import com.example.pojo.Page;

import java.util.List;

/**
 * @author Ghost1590
 * @create 2021-08-24-17:11
 */
public interface BookService {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int update(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page page(int pageNo, int pageSize);

    Page pageByPrice(int pageNo, int pageSize, int min, int max);
}
