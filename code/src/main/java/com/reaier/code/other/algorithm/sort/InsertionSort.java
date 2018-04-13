package com.reaier.code.other.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

//插入排序
// 参考文章： https://www.cnblogs.com/eniac12/p/5329396.html
//
//  先获取一张牌
//  再从余下的牌与排序好的牌，从左往左检查，比牌要小的，插入
//  后序的牌者往后移动
//
//
@Slf4j
public class InsertionSort {

    public static void main(String[] args) {
        int[] list = {2, 3, 6, 1, 5, 9, 0};


        new InsertionSort(list);

        for (int i = 0; i < list.length; ++ i) {
            log.info("{}", list[i]);
        }
    }

    InsertionSort(int[] list) {
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
