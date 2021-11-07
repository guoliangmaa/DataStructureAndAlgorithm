package leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序算法如下
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        SortAlgorithm object = new SortAlgorithm();

        int[] arr = new int[]{1, 8, 5, 4, 6, 2, 4, 7, 10, 6};
//        object.bubbleSort(arr);
//        object.selectionSort(arr);
//        object.insertionSort(arr);
//        System.out.println(Arrays.toString(object.mergeSort(arr)));
//        object.quickSort(arr, 0, arr.length - 1);
//        object.heapSort(arr);
//        object.countingSort(arr,10);
        object.bucketSort(arr,3);

        System.out.println(Arrays.toString(arr));
    }

    //冒泡算法
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) { //第二层循环的简化
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
    }

    public void selectionSort(int[] array) {
        int temp, min, index;
        for (int i = 0; i < array.length - 1; i++) {
            min = array[i];
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }

            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    public void insertionSort(int[] array) {

        int current, index;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            index = i - 1;

            while (index >= 0 && current < array[index]) {
                array[index + 1] = array[index];
                index--;
            }

            array[index + 1] = current;
        }


    }

    //希尔排序
    public void shellSort(int[] array) {

    }

    //归并排序
    public int[] mergeSort(int[] array) {
        if (array.length < 2) return array;

        //Arrays.copyOfRange方法是 左闭右开 区间，类似substring
        int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    //归并排序 工具方法
    private int[] merge(int[] left, int[] right) {

        int[] arr = new int[left.length + right.length];
        int index = 0;

        int index1 = 0, index2 = 0;

        while (index1 < left.length && index2 < right.length) {
            if (left[index1] < right[index2]) arr[index++] = left[index1++];
            else arr[index++] = right[index2++];
        }

        while (index1 < left.length) arr[index++] = left[index1++];

        while (index2 < right.length) arr[index++] = right[index2++];

        return arr;
    }

    //快速排序
    public void quickSort(int[] array, int left, int right) {

        if (left < right) {
            int partition = partition(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {

        int pivot = left, index = left + 1;

        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, index, i);
                index++;
            }
        }

        swap(array, pivot, index - 1);

        return index - 1;
    }

    public void heapSort(int[] array) {
        int len = array.length;

        for (int i = len / 2 -1; i >= 0; i--) {
            makeHeap(array, array.length, i);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(array, i, 0);
            makeHeap(array, i, 0);
        }
    }

    /**
     * 把堆修改为大顶堆
     *
     * @param array  数组
     * @param length 长度，注意这个长度不能通过 array.length 获取
     * @param i      需要修改的索引下标
     */
    private void makeHeap(int[] array, int length, int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < length && array[max] < array[left]) max = left;

        if (right < length && array[max] < array[right]) max = right;

        if (max != i) {
            swap(array, max, i);

            makeHeap(array, length, max);
        }
    }

    //计数排序，数据大小0-maxValue，需要maxValue不是很大并且序列比较集中
    public void countingSort(int[] array,int maxValue){
        int[] bucket = new int[maxValue + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]] ++;
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    public void bucketSort(int[] array, int bucketCount) {
        int maxValue = array[0];
        int minValue = array[0];
        int index = 0;
        int bucketSize = array.length / bucketCount + 1;

        List<List<Integer>> list = new ArrayList<>();

        for (int i : array) {
            if (i > maxValue) maxValue = i;
            if (i < minValue) minValue = i;
        }

        for (int i = 0; i < bucketCount; i++) {
            List<Integer> lst = new ArrayList<>();

            list.add(lst);
        }

        for (int j : array) {
            list.get((j - minValue) / bucketSize).add(j);
        }

        for (int i = 0; i < bucketCount; i++) {

            int[] arr = list.get(i).stream().mapToInt(Integer::intValue).toArray();
            insertionSort(arr);

            for (int k : arr) {
                array[index++] = k;
            }
        }
    }




    private int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
