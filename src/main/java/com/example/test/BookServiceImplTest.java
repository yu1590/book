package com.example.test;

import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import org.junit.Test;

/**
 * @author Ghost1590
 * @date 2021/8/26-5:03 下午
 */
public class BookServiceImplTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void test(){
        Page page = bookService.page(2, 6);
        System.out.println(page);
    }

    @Test
    public void test1(){
        Page page = bookService.pageByPrice(4, 4, 0, 30);
        System.out.println(page);
    }
}
