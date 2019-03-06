package com.manage.dao.product;

import com.manage.model.product.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProductMapper {

    List<Product> getProductList(Product product);

    int insertProduct(Product product);

    Product selectProductById(Integer productId);

    int updateProduct(Product product);

    int deleteProduct(Product product);
}
