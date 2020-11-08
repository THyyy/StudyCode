package algorithm.leetcode.everyday;

import java.util.*;

/**
 * 每日一题——O(1) 时间插入、删除和获取随机元素 - 允许重复
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关
 *
 * @author yuancome
 * @date 2020/10/31
 */

public class Day24 {
    /**
     * 值 - 索引，索引用来提供给列表进行 O(1) 查询
     */
    Map<Integer, Set<Integer>> idx;
    /**
     * 存储数据的列表
     */
    List<Integer> nums;

    /**
     * Initialize your data structure here.
     */
    public Day24() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }
    /**
     * 解题思路：获取随机元素为 O(1) 则使用 ArrayList 列表存储数据
     * 因为 ArrayList 在删除时，时间复杂度为 O(n) 所以要将删除元素移至末尾，然后删除末尾元素
     * 插入本身操作应该是多个 O(1) 综合复杂度也是 O(1)
     */

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<>());
        // 构造索引
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        // 找到该值得索引，然后修改列表中索引值为末尾值，最后移除
        Set<Integer> integers = idx.get(val);
        Iterator<Integer> iterator = integers.iterator();
        int i = iterator.next();
        int lastNumber = nums.get(nums.size() - 1);
        // 替换索引 i 的值为末尾值
        nums.set(i, lastNumber);
        // 删除 set 的 i 值
        idx.get(val).remove(i);
        // 删除 map 的末尾值对应 set 的 末尾索引
        idx.get(lastNumber).remove(nums.size() - 1);
        // 添加 map 的末尾值对应 set 的 i 索引
        if (i < nums.size() - 1) {
            idx.get(lastNumber).add(i);
        }
        // 如果 val 对应索引 set 为空时，移除 set
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        // 删除列表的末尾值
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}
