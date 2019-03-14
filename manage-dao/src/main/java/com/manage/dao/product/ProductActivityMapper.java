package com.manage.dao.product;

import com.manage.model.product.ProductActivity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductActivityMapper {

    List<ProductActivity> getProductActivityList(ProductActivity productActivity);

    int insertProductActivity(ProductActivity productActivity);

    ProductActivity selectProductActivityById(Integer productActivityId);

    int updateProductActivity(ProductActivity productActivity);

    int deleteProductActivity(ProductActivity productActivity);
}
