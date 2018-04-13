package com.reaier.code.tk4.p146;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class B extends A {
    private int k = printInit("B's property initialized");

    static {
        bs1 = printInit("B's static sentence for bs1 initialized");
    }

    private static int bs1 = printInit("B's static property for bs1 initialized");;

    public B() {
        log.info("k = {}", k);
        log.info("j = {}", j);
    }

    private static int x2 = printInit("B's static property initialized");
}
