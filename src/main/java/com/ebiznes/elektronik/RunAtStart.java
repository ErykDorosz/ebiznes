package com.ebiznes.elektronik;

import com.ebiznes.elektronik.entity.Category;
import com.ebiznes.elektronik.entity.Order;
import com.ebiznes.elektronik.entity.Product;
import com.ebiznes.elektronik.entity.User;
import com.ebiznes.elektronik.repository.CategoryRepository;
import com.ebiznes.elektronik.repository.OrderRepository;
import com.ebiznes.elektronik.repository.ProductRepository;
import com.ebiznes.elektronik.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Component
public class RunAtStart {
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public RunAtStart(CategoryRepository categoryRepository,
                      OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        super();
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void runAtStart() {

        User user1 = User.builder().name("Marek").surname("Kowalski").email("marekkowalski@gmail.com").
                password("lulPassword").admin(false).build();
        userRepository.save(user1);

        Category category = Category.builder().categoryName("AGD").description("No AGD no").build();

        categoryRepository.save(category);

        Product product = Product.builder().name("Samsung Pro XD").category(category).imageFilename("46288474-e423-45b6-be2c-0b83b4f5a01b.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product1 = Product.builder().name("Xiaomi Pro XD").category(category).imageFilename("46288474-e423-45b6-be2c-0b83b4f5a01b.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product2 = Product.builder().name("Iphone Pro XD").category(category).imageFilename("46288474-e423-45b6-be2c-0b83b4f5a01b.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product3 = Product.builder().name("MyPhone Pro XD").category(category).imageFilename("46288474-e423-45b6-be2c-0b83b4f5a01b.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product4 = Product.builder().name("Xiaomi lols").category(category).imageFilename("46288474-e423-45b6-be2c-0b83b4f5a01b.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product5 = Product.builder().name("HannSpree").category(category).imageFilename("46288474-e423-45b6-be2c-0b83b4f5a01b.jpg").
                unitPrice(new BigDecimal(356)).build();

        productRepository.save(product);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        Date data = new Date();
        Order order = Order.builder().shipEmail("exampleemail@gmail.com").shipCountry("Poland").
                shipPhoneNo("123456789").shipCity("Lodz").shipPostalCode("95-040").
                orderDate(data).shipTo("Radom").user(user1).build();

        orderRepository.save(order);

        val user = User.builder()
                .admin(true)
                .name("admin")
                .surname("admin")
                .email("admin")
                .password("$2a$12$zm8p0155jRI4Y.AhS6ItIu/pkb1bTJnZYS5/uVqDmBUJFOmv7iqWG") // password
                .build();
        userRepository.save(user);
    }
}
