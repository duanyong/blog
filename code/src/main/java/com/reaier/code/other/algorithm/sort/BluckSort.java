package com.reaier.code.other.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BluckSort {


    BluckSort(int[] list) {
        int[] blucks = new int[list.length];

        for (int v : list) {
            if (blucks[v] == 0) {
                blucks[v] = 1;
            } else {
                blucks[v] ++;
            }
        }

        list = new int[list.length];

        for (int i=0; i < blucks.length; ++ i) {
            for (int j=0; j < blucks[i]; ++ j) {
                list[list.length] = i;
            }
        }
    }


    public static void main(String[] args) {
        int[] list = {2, 3, 6, 1, 5, 9, 0};


        new SelectionSort(list);

        for (int i = 0; i < list.length; ++ i) {
            log.info("{}", list[i]);
        }
    }
}
