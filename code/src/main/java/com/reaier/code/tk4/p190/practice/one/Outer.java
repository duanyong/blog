package com.reaier.code.tk4.p190.practice.one;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Outer {

    class Inner {
        String test = "Inner";

        public String getTest() {
            return test;
        }
    }


    Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        log.info(outer.getInner().getTest());
    }
}
