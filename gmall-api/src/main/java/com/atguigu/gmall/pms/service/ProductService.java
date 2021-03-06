package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.vo.product.PmsProductQueryParam;
import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.vo.PageInfoVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author Lfy
 * @since 2019-12-02
 */
public interface ProductService extends IService<Product> {

    PageInfoVo productPageInfo(PmsProductQueryParam productQueryParam);
}
