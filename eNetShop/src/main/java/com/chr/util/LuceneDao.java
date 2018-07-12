package com.chr.util;

import com.chr.entity.Product;

import java.util.List;

public interface LuceneDao {

    List<Product> findProductByName(String keywords);

}
