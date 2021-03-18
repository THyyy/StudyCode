package algorithm.demo.sort;

/**
 * 快速排序算法
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/3/18
 */
public class QuickSort implements ArraySortInterface{
    @Override
    public int[] sort(int[] arrays) {
        if (arrays.length < 2) {
            return arrays;
        }

        return quickSort(arrays, 0, arrays.length - 1);
    }

    private int[] quickSort(int[] arrays, int left, int right) {
        if (left < right) {
            int partitionIndex = baseValue(arrays, left, right);
            quickSort(arrays, left, partitionIndex - 1);
            quickSort(arrays, partitionIndex + 1, right);
        }
        return arrays;
    }

    private int baseValue(int[] arrays, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arrays[pivot] > arrays[i]) {
                swap(arrays, i, index);
                index++;
            }
        }
        // 交换基准值位置
        swap(arrays, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
