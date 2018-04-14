package com.reaier.code.tk4.p190;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Parceli {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }


    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }


    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }


    public void ship(String dest) {
        Contents contents = contents();

        Destination destination = to(dest);

        log.info(destination.readLabel());
    }

    public static void main(String[] args) {
        Parceli parceli = new Parceli();

        parceli.ship("Tasmania");
    }
}
