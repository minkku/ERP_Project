package org.gagu.repository;

import org.gagu.entity.ProductOrder;
import org.gagu.entity.QProductOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductOrderListRepositoryTests {
    @Autowired
    ProductOrderListRepository repo;

    @Test
    public void testSelect() {
        Integer num = 1;
        Optional<ProductOrder> result = repo.findById(num);
        if (result.isPresent()) {
            ProductOrder productOrder = result.get();
            System.out.println(productOrder);
        }
    }
}
