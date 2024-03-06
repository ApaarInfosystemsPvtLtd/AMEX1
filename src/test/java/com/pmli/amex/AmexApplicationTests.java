package com.pmli.amex;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
class AmexApplicationTests {

    @Test
    void contextLoads() {
        assertNull(null);
    }

}
