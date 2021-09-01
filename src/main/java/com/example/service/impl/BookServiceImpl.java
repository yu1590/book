package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;

import java.util.List;

/**
 * @author Ghost1590
 * @create 2021-08-24-17:12
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);

        int pageTotalCount = bookDao.queryForpageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNO(pageNo);
        int begin = (page.getPageNO() - 1) * pageSize;
        List<Book> items = bookDao.queryForItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);

        int pageTotalCount = bookDao.queryForpageTotalCount(min, max);
        page.setPageTotalCount(pageTotalCount);

        int pageTotal = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize != 0) {
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        page.setPageNO(pageNo);
        int begin = (page.getPageNO() - 1) * pageSize;
        List<Book> items = bookDao.queryForItems(begin, pageSize, min, max);
        page.setItems(items);
        return page;
    }
}
