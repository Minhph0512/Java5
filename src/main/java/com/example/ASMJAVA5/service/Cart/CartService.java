package com.example.ASMJAVA5.service.Cart;

import com.example.ASMJAVA5.entity.Product;
import com.example.ASMJAVA5.service.Product.Productsevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartService implements ICartService{
    @Autowired
    Productsevice productsevice;
    Map<Integer,Product> map=new HashMap<>();

    @Override
    public Product add(int id) {
        Product product = map.get(id);

        if (product != null){
            product.setQuantity(product.getQuantity() + 1);
        } else {
            Product exProduct = productsevice.getById(id);
            if (exProduct != null){
                exProduct.setQuantity(1);
                map.put(id, exProduct);
            }}
        return product;
    }

    @Override
    public Product themGioHang(int id) {
            Product product = map.get(id);

            if (product != null){
                product.setQuantity(product.getQuantity() + 1);
            } else {
                Product exProduct = productsevice.getById(id);
                if (exProduct != null){
                    exProduct.setQuantity(1);
                    map.put(id, exProduct);
                }}
                return product;
    }

    @Override
    public void remove(int id) {
        map.remove(id);
    }

    @Override
    public Product update(int id, int quantity) {
        Product product = map.get(id);
        if(product !=  null){
            product.setQuantity(quantity);
        }
        return product;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Product> getProduct() {
        return map.values();
    }

    @Override
    public int getCount() {
        int count =0;
        for(Product product : map.values()){
            count+=product.getQuantity();
        }

        return count;
    }

    @Override
    public BigDecimal getAmount() {
        BigDecimal amonut=BigDecimal.ZERO ;
        for(Product product : map.values()){
            if(product!=null){
                int quantity = product.getQuantity();
                BigDecimal price = product.getPrice();
                amonut = amonut.add(BigDecimal.valueOf(quantity).multiply(price));
            }
        }
        return amonut;
    }
}
