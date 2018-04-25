package com.reaier.code.jvm.clz;

public class AddImpl implements Add {
    public static final int TOP = 100;

    private String point;

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
