package com.example.test;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Ghost1590
 * @create 2021-08-24-16:45
 */
public class BookDaoImplTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void test(){
        bookDao.addBook(new Book(null, "你好", "yuyingjie", new BigDecimal(123.1), 12, 13, ""));
    }

    @Test
    public void test1(){
        bookDao.deleteBookById(21);
    }

    @Test
    public void test2(){
        bookDao.update(new Book(20, "你好", "yuyingjie", new BigDecimal(123.1), 12, 13, ""));
    }

    @Test
    public void test3(){
        Book book = bookDao.queryBookById(1);
        System.out.println(book);

        List<Book> books = bookDao.queryBooks();
        System.out.println(books);
    }

    @Test
    public void test4(){
        System.out.println(bookDao.queryForpageTotalCount());
    }

    @Test
    public void test5(){
        List<Book> books = bookDao.queryForItems(5, 5);

        for(Book b: books)
            System.out.println(b);
    }

    @Test
    public void test6(){
        System.out.println(bookDao.queryForpageTotalCount(0, 500));
    }

    @Test
    public void test7(){
        List<Book> books = bookDao.queryForItems(5, 5, 0, 100);

        for(Book book: books)
            System.out.println(book);
    }
}
