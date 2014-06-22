package com.sort.heap;

/**
 * 堆排序
 * 
 * @project Test
 * @module Test
 * @comments
 * @nameSpace com.sort.heap
 * @author chen
 * @since 2013-11-29
 * @see
 * @modifier
 * @date
 * @reason
 * @version
 */
public class HeapSortTest
{
    private static int[] sortArr = { 8, 7, 6, 5, 1, 2, 3, 4, 5, 6, 7, 9, 8, 1 };

    public static void main(String[] argus)
    {
        mxHeapSort(sortArr, 0);
        
        for (int temp : sortArr)
        {
            System.out.print(temp +" ");
        }
        System.out.println();
    }
    
    public static void mxHeapSort(int[] sortArr, int i)
    {
        int l = (i+1) * 2 - 1;
        int r = (i+1) * 2;
        
        int largest = i;
        if (l < sortArr.length && sortArr[largest] < sortArr[l])
        {
            largest = l;
        }
        if (r < sortArr.length && sortArr[largest] < sortArr[r])
        {
            largest = r;
        }
        
        if (largest != i)
        {
            int temp = sortArr[i];
            sortArr[i] = sortArr[largest];
            sortArr[largest] = temp;
            mxHeapSort(sortArr, largest);
        }
    }
}
