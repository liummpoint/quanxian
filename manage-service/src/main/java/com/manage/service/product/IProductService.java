package com.manage.service.product;

import com.manage.model.page.Page;
import com.manage.model.ResultMsg;
import com.manage.model.product.Product;

public interface IProductService {

    ResultMsg getProductList( Page page) throws Exception;


    ResultMsg insertProduct(Product product)  throws Exception;

    ResultMsg selectProductById(Integer productId) throws Exception;

    ResultMsg updateProduct(Product product)  throws Exception;

    ResultMsg deleteProduct(Product product)  throws Exception;
}
