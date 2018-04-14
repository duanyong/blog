package com.reaier.code.tk4.p190;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;


public interface Selector {
    boolean end();

    Object current();

    void next();

    @Slf4j
    public class Sequence {
        private Object[] items;
        private int next = 0;

        public Sequence(int size) {
            items = new Object[size];
        }

        public void add(Object x) {
            if (next >= items.length) {
                return;
            }

            items[next ++ ] = x;
        }

        public Selector selector() {
            return new SequenceSelector();
        }

        public static Logger getLog() {
            return log;
        }

        private class SequenceSelector implements Selector {
            private int i = 0;

            @Override
            public boolean end() {
                return i == items.length;
            }

            @Override
            public Object current() {
                return items[i];
            }

            @Override
            public void next() {
                if (end() == false) {
                    ++ i;
                }
            }
        }
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        for (int i=0; i<10; ++ i) {
            sequence.add(Integer.toString(i));
        }

        Selector selector = sequence.selector();

        while (!selector.end()) {
            Sequence.getLog().info(selector.current().toString());

            selector.next();
        }
    }

}
