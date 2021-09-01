package com.example.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ghost1590
 * @date 2021/8/28-4:05 下午
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer, Cartitem> items = new LinkedHashMap<>();


    public void addItem(Cartitem cartitem) {
        Cartitem item = items.get(cartitem.getId());
        if (item == null) {
            items.put(cartitem.getId(), cartitem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    public void deleteItem(Integer id){
        items.remove(id);
    }

    public void clear(){
        items.clear();
    }

    public void updateCount(Integer id, Integer count){
        Cartitem item = items.get(id);
        if(item != null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Cartitem value : items.values()) {
            totalCount += value.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Cartitem value : items.values()) {
            totalPrice = totalPrice.add(value.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, Cartitem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Cartitem> items) {
        this.items = items;
    }

    public Cart() {
    }

    public Cart(Map<Integer, Cartitem> items) {
        this.items = items;
    }
}
