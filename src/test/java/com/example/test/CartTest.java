package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.Cartitem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Ghost1590
 * @date 2021/8/28-4:25 下午
 */
public class CartTest {
    Cart cart = new Cart();
    @Test
    public void addItem() {


        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(2, "bbb", 2, new BigDecimal(44), new BigDecimal(44)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(2, "bbb", 1, new BigDecimal(44), new BigDecimal(44)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(2, "bbb", 1, new BigDecimal(44), new BigDecimal(44)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(1, "aaa", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new Cartitem(2, "bbb", 1, new BigDecimal(44), new BigDecimal(44)));

        cart.updateCount(2, 4);
        System.out.println(cart);
    }
}