package algorithm.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 每日一题——杨辉三角
 *
 * @author yuancome
 * @date 2020/12/6
 */

public class Day60 {
    private List<List<Integer>> generate(int numRows) {
        //构建返回结果集
        List<List<Integer>> result = new ArrayList(numRows);
        //按行遍历，从第一行到最后一行
        for (int i = 0; i < numRows; ++i) {
            //构建每行的结果
            List<Integer> perResult = new ArrayList(i + 1);
            //按下标遍历行，从 0 到最后
            for (int j = 0; j <= i; ++j) {
                //一行的第一个下标和最后一个下标为 1
                if (j == 0 || j == i) {
                    perResult.add(1);
                } else {
                    //中间下标的值为上一行的左上方和右上方的数的和
                    perResult.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(perResult);
        }
        return result;
    }
}
