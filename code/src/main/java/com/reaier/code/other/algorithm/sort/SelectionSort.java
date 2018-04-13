package com.reaier.code.other.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

//选择排序
// 参考文章： https://zh.wikipedia.org/wiki/%E9%B8%A1%E5%B0%BE%E9%85%92%E6%8E%92%E5%BA%8F
//
//  选择最大（小）的数字，放到排序的一边
//
@Slf4j
public class SelectionSort {

    public static void main(String[] args) {
        int[] list = {2, 3, 6, 1, 5, 9, 0};


        new SelectionSort(list);

        for (int i = 0; i < list.length; ++ i) {
            log.info("{}", list[i]);
        }
    }

    SelectionSort(int[] list) {
        int minPos;

        for (int i=0; i<list.length; ++ i) {
            minPos = i;

            for (int j=minPos; j < list.length; ++ j) {
                if (list[j] < list[minPos]) {
                    minPos = j;
                }
            }

            if (minPos != i) {
                swap(list, minPos, i);
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
