package com.reaier.code.tk4.p146;


import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
public class A {
    private int i = 9;

    protected int j;

    private int k = printInit("A's property initialized");

    private static int m;

    A() {
        log.info("A's construction initialized");
    }

    static {
        m = printInit("A's static sentence initialized");
    }

    private static int x1 = printInit("A's static property initialized");


    static int printInit(String s) {
        log.info(s);

        return 47;
    }
}
