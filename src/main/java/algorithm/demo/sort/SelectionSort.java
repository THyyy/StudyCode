package algorithm.demo.sort;

/**
 * 选择排序算法
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/3/18
 */
public class SelectionSort implements ArraySortInterface{
    @Override
    public int[] sort(int[] arrays) {
        if (arrays.length < 2) {
            return arrays;
        }

        for (int i = 0; i < arrays.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] > arrays[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(arrays, i, minIndex);
            }
        }
        return arrays;
    }

    private void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
