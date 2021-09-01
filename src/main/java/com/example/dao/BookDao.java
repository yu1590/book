package com.example.dao;

import com.example.pojo.Book;

import java.util.List;

/**
 * @author Ghost1590
 * @create 2021-08-24-16:30
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int update(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    int queryForpageTotalCount();

    List<Book> queryForItems(int begin, int pageSize);

    int queryForpageTotalCount(int min, int max);

    List<Book> queryForItems(int begin, int pageSize, int min, int max);
}
