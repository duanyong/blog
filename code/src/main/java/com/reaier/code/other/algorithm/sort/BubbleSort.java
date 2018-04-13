package com.reaier.code.other.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

//冒泡算法
// O(n^2)
@Slf4j
public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {2, 3, 6, 1, 5, 9, 0};

        new BubbleSort(list);

        for (int i = 0; i < list.length; ++ i) {
            log.info("{}", list[i]);
        }
    }

    BubbleSort(int[] list) {
        for (int i=0; i < list.length; ++ i) {
            for (int j = i + 1; j < list.length; ++ j) {
                if (j == i) {
                    return;
                }

                if (list[i] > list[j]) {
                    swap(list, i, j);
                }
            }
        }
    }


    //交换i和j的值
    void swap(int[] list, int i, int j) {
        int temp = list[i];

        list[i] = list[j];
        list[j] = temp;
    }
}
