package com.hroac.springbootweb;

import com.hroac.springbootweb.controller.HomeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootWebApplicationTests {

    @Autowired
    private HomeController homeController;

    @Test
    void contextLoads() {
        Assertions.assertThat(homeController).isNotNull();
    }

}
