package com.miracle.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MySpringBootApplicationTests {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final ObjectMapper objectMapper = new ObjectMapper();
    @Test
    public void contextLoads() {
        logger.trace("I am trace log.");
        logger.debug("I am debug log.");
        logger.warn("I am warn log.");
        logger.error("I am error log.");
    }
//private static Logger logger = LogManager.getLogger(MySpringBootApplicationTests.class);
//
//    public static void main(String[] args) {
//        logger.error("log4j2----------------\n");
//        SpringApplication.run(MySpringBootApplicationTests.class, args);
//    }

}