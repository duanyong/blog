package com.reaier.code.other.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

//快速，来回晃动（鸡尾酒排序）
// 参考文章： https://zh.wikipedia.org/wiki/%E9%B8%A1%E5%B0%BE%E9%85%92%E6%8E%92%E5%BA%8F
@Slf4j
public class QuickSort {

    public static void main(String[] args) {
        int[] list = {2, 3, 6, 1, 5, 9, 0};


        new QuickSort(list);

        for (int i = 0; i < list.length; ++ i) {
            log.info("{}", list[i]);
        }
    }

    QuickSort(int[] list) {
        boolean swapped = true;
        int bottom  = 0;
        int top     = list.length -1;

        while (swapped == true) {
            swapped = false;

            for (int i = bottom; i < top; ++ i) {
                if (list[i] > list[i + 1]) {
                    swap(list, i, i + 1);

                    swapped = true;
                }
            }

            top --;

            for (int j = top; j > bottom; -- j) {
                if (list[j] < list[j -1]) {
                    swap(list, j, j - 1);

                    swapped = true;
                }
            }

            bottom ++;
        }
    }

    //交换i和j的值
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];

        list[i] = list[j];
        list[j] = temp;
    }
}
