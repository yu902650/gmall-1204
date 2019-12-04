package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.entity.Product;
import com.atguigu.gmall.pms.service.BrandService;
import com.atguigu.gmall.pms.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallPmsApplicationTests {

    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;

    @Test
    public void contextLoads() {
//        Product product = productService.getById(1);
//        System.out.println(product.getName());

//   测试增删改在主库，查在从库
//        Brand brand = new Brand();
//        brand.setName("哈哈哈");
//        brandService.save(brand);
//        System.out.println("保存成功");

        //查询在从库
        Brand byId = brandService.getById(53);
        System.out.println(byId.getName());


    }

}
