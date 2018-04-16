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
        int base    = list[0];
        int left    = 0;
        int right   = list.length -1;

    }

    private static void quickSort(int[] list, int low, int high) {
        if (low > high) {
            return;
        }

        int base = list[low];

        while (low < high) {
            if (high > low && list[high] >= base) {
                high --;
            }

            if (low < high && list[low] <= base) {
                low ++ ;
            }

            if (low < high) {
                swap(list, low, high);
            }
        }




    }

    //交换i和j的值
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];

        list[i] = list[j];
        list[j] = temp;
    }
}
