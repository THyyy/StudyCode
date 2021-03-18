package algorithm.demo.sort;

/**
 * 冒泡排序算法
 *
 * @author tanheyuan
 * @version 1.0
 * @since 2021/3/18
 */
public class BubbleSort implements ArraySortInterface {

    @Override
    public int[] sort(int[] arrays) {
        if (arrays.length < 2) {
            return arrays;
        }
        for (int i = 1; i < arrays.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[i] > arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arrays;
    }
}
