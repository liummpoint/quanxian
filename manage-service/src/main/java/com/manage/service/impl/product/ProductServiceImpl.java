package com.manage.service.impl.product;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.model.page.Page;
import com.manage.model.PageInfoResult;
import com.manage.model.ResultMsg;
import com.manage.model.user.UserManager;
import com.manage.service.product.IProductService;
import com.manage.dao.product.ProductMapper;
import com.manage.model.product.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Resource
    private ProductMapper productMapper;

    /**
     * 查询列表
     *
     * @throws Exception
     */
    @Override
    public ResultMsg getProductList(Page page) {
        if (page.getStartIndex() > 0) {
            page.setStartIndex(page.getStartIndex() / page.getPageSize() + 1);
        } else {
            page.setStartIndex(1);
        }
        PageHelper.startPage(page.getStartIndex(), page.getPageSize());
        Product productParam=new Product();
        productParam.setStatus(1);
        List<Product> productList = productMapper.getProductList(productParam);
        PageInfo pageInfo = new PageInfo(productList);
        return PageInfoResult.PageInfoMsg(pageInfo);

    }


    /**
     * 插入新增列表
     *
     * @throws Exception
     */
    @Override
    public ResultMsg insertProduct(Product product) throws Exception {


        ResultMsg<UserManager> resultMsg = new ResultMsg<>();


        product.setStatus(1);
        product.setCreateTime(System.currentTimeMillis());
        product.setUpdateTime(System.currentTimeMillis());
        productMapper.insertProduct(product);
        return resultMsg;

    }

    @Override
    public ResultMsg selectProductById(Integer productId) throws Exception {
        ResultMsg resultMsg = new ResultMsg();
        Product product = productMapper.selectProductById(productId);
        resultMsg.setData(product);
        return resultMsg;
    }

    /**
     * 更新列表
     *
     * @throws Exception
     */
    @Override
    public ResultMsg updateProduct(Product product) throws Exception {
        ResultMsg resultMsg=new ResultMsg();
        product.setUpdateTime(System.currentTimeMillis());
        productMapper.updateProduct(product);
        return resultMsg;
    }


    /**
     * 删除
     *
     * @throws Exception
     */
    @Override
    public ResultMsg deleteProduct(Product product) throws Exception {
        ResultMsg resultMsg=new ResultMsg();
        productMapper.deleteProduct(product);
        return resultMsg;
    }
}
