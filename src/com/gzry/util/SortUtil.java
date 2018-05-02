package com.gzry.util;

/**
 * Created by Huan on 2018/4/28.
 */
public class SortUtil {

    /**
     * 冒泡排序
     * 思路：由大到小排序--相邻两个元素进行比较，大的元素放左边，小的元素放右边，一轮循环后，最小的元素在最右边
     * 分组：待排序前半部分，已排序后半部分
     * @param arr
     * @return
     */
    public static int[] bubbleSort冒泡排序(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 1; j < arr.length - i; j++){
                if(arr[j-1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * 思路：使用索引为0的元素与其他的元素比较，如果有比索引0大的元素，则记录该元素的下标，一轮比较完后，下标值是最大值，交换数据后
     *      最大的元素在最左边，使用索引为1的元素与其他的元素比较。
     * 分组：已排序前半部分，待排序后半部分
     * @param arr
     * @return
     */
    public static int[] selectionSort选择排序(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            int k = i;//记录最小数的下标
            for (int j = i+1; j < arr.length; j++){
                if(arr[k] < arr[j]){
                    k = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
        return arr;
    }

    /**
     * 插入排序
     * 思路：不断地把数据插入已排序的部分数据列中的恰当位置
     * 分组：已排序前半部分，待排序后半部分
     * @param arr
     * @return
     */
    public static int[] insertSort插入排序(int[] arr){
        int j;
        int key;
        for (int i = 1; i < arr.length; i++){
            key = arr[i];//key就是我们每次新摸到的牌，现在需要找到插入位置并空出位置
            j = i-1;
            while (j >= 0 && arr[j]<key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = key;//空出位置后，然后插入
        }
        return arr;
    }

    /**
     * 希尔排序
     * 思路：把数据按照一定间隔分割成不同的组，并且对每个组进行排序
     * @param arr
     * @return
     */
    public static int[] shellSort希尔排序(int[] arr){
        int size = arr.length;
        for (int gap = size/2; gap >= 1; gap /= 2){//分组
            for (int i = gap; i < size; i++){//对每组进行插入排序
                int temp = arr[i];
                int k = i-gap;
                while (k >= 0 && arr[k] < temp){
                    arr[k+gap] = arr[k];
                    k = k - gap;
                }
                arr[k+gap] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args){
        int[] arr = {2, 5, 1, 8, 10};
//        bubbleSort冒泡排序(arr);
//        selectionSort选择排序(arr);
//        insertSort插入排序(arr);
        shellSort希尔排序(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
