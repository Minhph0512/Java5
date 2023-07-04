package com.example.ASMJAVA5.service.Cart;

import com.example.ASMJAVA5.entity.Product;

import java.math.BigDecimal;
import java.util.Collection;

public interface ICartService {
    Product add(int id);

    Product themGioHang(int id);

    void remove(int id);

    Product update(int id,int quantity);

    void clear();

    Collection<Product> getProduct();

    int getCount();

    BigDecimal getAmount();
}
