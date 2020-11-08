package algorithm.leetcode.everyday;

import java.util.*;

/**
 * 每日一题——单词拆分 II
 *
 * @author yuancome
 * @date 2020/11/1
 */

public class Day25 {
    private List<String> wordBreak(String s, List<String> wordDict) {
        // 本题难度在于自顶向下进行记忆搜索，而且字底向上的 dp 无法实现
        Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();
        // 拆分结果集，单词之间不加空格
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<String>(wordDict), 0, map);
        // 最终结果集
        List<String> breakList = new LinkedList<String>();
        for (List<String> wordBreak : wordBreaks) {
            // 每个单词之间添加空格
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    private List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<List<String>>();
            // 已经递归到末尾，无匹配，不会走下面的 for 循环
            if (index == length) {
                wordBreaks.add(new LinkedList<String>());
            }
            for (int i = index + 1; i <= length; i++) {
                // 从字符串 0 索引开始截取到 i 判断是否在字典中存在
                String word = s.substring(index, i);
                // 如果字典中包含这个单词，则进行后续的字符串匹配
                if (wordSet.contains(word)) {
                    // 从 i 索引开始遍历后续的字符串
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        // 将开头的单词加入到列表开头，然后把后续单词加入到列表
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            // 将获得的句子加入到 map 中
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }
}
