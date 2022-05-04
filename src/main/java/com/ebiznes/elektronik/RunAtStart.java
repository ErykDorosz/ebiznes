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

        Category categoryOdkurzacze = Category.builder().categoryName("Odkurzacze").description("Urządzenie elektryczne służące do oczyszczania przedmiotów lub powierzchni").build();
        Category categoryTelewizory = Category.builder().categoryName("Telewizory").description("Wyświetlacz pozwalający na odbiór sygnału").build();
        Category categoryLodowki = Category.builder().categoryName("Lodówki").description("Urządzenie, którego zadaniem jest obniżenie temperatury środowiska chłodzonego").build();
        Category categoryKomputery = Category.builder().categoryName("Komputery").description("Maszyna przeznaczona do przetwarzania informacji").build();
        Category categorySmartfony = Category.builder().categoryName("Smartfon").description("Przenośne, multimedialne urządzenie, łączące w sobie funkcje telefonu komórkowego i komputera przenośnego").build();
        Category categoryPralki = Category.builder().categoryName("Pralki").description("Urządzenie do czyszczenia ubrań").build();


        categoryRepository.save(categoryOdkurzacze);
        categoryRepository.save(categoryTelewizory);
        categoryRepository.save(categoryLodowki);
        categoryRepository.save(categoryKomputery);
        categoryRepository.save(categorySmartfony);
        categoryRepository.save(categoryPralki);

        Product product = Product.builder().name("Lodówka Siemens X562").category(categoryLodowki).imageFilename("Lodowka-SIEMENS.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product1 = Product.builder().name("Xiaomi Redmi Note 10 Pro").category(categorySmartfony).imageFilename("Smartfon-XIAOMI-Redmi-Note-10-Pro.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product2 = Product.builder().name("Iphone 12").category(categorySmartfony).imageFilename("iphone-12.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product3 = Product.builder().name("MyPhone Pro XD").category(categorySmartfony).imageFilename("my_phone.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product4 = Product.builder().name("Pralka Xiaomi SuperCharge").category(categoryPralki).imageFilename("pralka_frania.jpg").
                unitPrice(new BigDecimal(123)).build();
        Product product5 = Product.builder().name("Pralka Beko SWRE7512XWWE").category(categoryPralki).imageFilename("pralka_beko.jpg").
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
