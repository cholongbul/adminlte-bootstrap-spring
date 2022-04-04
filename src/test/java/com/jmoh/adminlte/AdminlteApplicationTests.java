package com.jmoh.adminlte;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootTest
class AdminlteApplicationTests {

    @Autowired
    ResourceLoader resourceLoader;

    @Test
    void contextLoads() {
        Resource resource = resourceLoader.getResource("classpath:data2/");
        System.out.println(resource.getFilename());
        resource.exists();
    }

}
