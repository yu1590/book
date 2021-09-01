package com.example.dao.impl;

import com.example.dao.BookDao;
import com.example.pojo.Book;

import java.util.List;

/**
 * @author Ghost1590
 * @create 2021-08-24-16:32
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int update(Book book) {
        String sql = "update t_book set name=?, author=?, price=?, sales=?, stock=?, img_path=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,NAME,author,price,sales,stock,img_path 'imgPath' from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,NAME,author,price,sales,stock,img_path 'imgPath' from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public int queryForpageTotalCount() {
        String sql = "select count(*) from t_book";
        Number num = (Number) queryForSingleValue(sql);
        return num.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize) {
        String sql = "select id,NAME,author,price,sales,stock,img_path 'imgPath' from t_book limit ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public int queryForpageTotalCount(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSingleValue(sql, min, max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForItems(int begin, int pageSize, int min, int max) {
        String sql = "select id,NAME,author,price,sales,stock,img_path 'imgPath' from t_book where price between ? and ? order by price limit ?,? ";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }
}
