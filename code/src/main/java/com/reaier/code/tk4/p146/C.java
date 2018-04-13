package com.reaier.code.tk4.p146;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class C extends B {
    private static int cs1 = printInit("C's static property initialized");

    static {
        cs1 = printInit("C's static sentence initialized");
    }

    public static void main(String[] args) {
        log.info("begin c1");
        C c1 = new C();

        log.info("=================>");
        log.info("begin c2");
        C c2 = new C();

        log.info("=================>");
        log.info("begin a1");
        A a1 = new A();

    }

    public static void test1() {
        log.info("begin c1");
        C c1 = new C();
    }

}
