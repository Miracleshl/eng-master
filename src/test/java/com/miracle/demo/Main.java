package com.miracle.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Main {
    @org.junit.Test
    public static void main(String[] args) {
        new Test().test();
    }
//    static class Test {
//        final Logger log = Logger.getLogger(Test.class);
//
//        public void test() {
//            log.info("hello this is log4j info log");
//        }
//    }
    static class Test {
    Logger log = LoggerFactory.getLogger(Test.class);

    public void test() {
        log.info("hello, my name is {}", "chengyi");
    }
}
}
