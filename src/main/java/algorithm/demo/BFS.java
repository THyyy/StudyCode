package algorithm.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先算法
 * from https://www.jianshu.com/p/2d6812a7b868
 *
 * @author yuancome
 * @date 2020/10/17
 */

public class BFS {

    public static void main(String[] args) {
        //构造各顶点
        LinkedList<Character> list_s = new LinkedList<Character>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<Character>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<Character>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<Character>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<Character>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<Character>();
        list_y.add('u');
        list_y.add('x');

        //构造图
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        //记录每个顶点离起始点的距离，也即最短距离
        HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
        //遍历的起始点
        char start = 's';
        //调用广度优先方法
        bfs(graph, dist, start);
    }

    private static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist,
                            char start) {
        Queue<Character> q = new LinkedList<>();
        // 将s作为起始顶点加入队列
        q.add(start);
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty()) {
            // 取出队首元素
            char top = q.poll();
            i++;
            System.out.println("第 " + i + "个元素:" + top + " 距离头元素的距离为: " + dist.get(top));
            // 得出其周边还未被访问的节点的距离
            int d = dist.get(top) + 1;
            for (Character c : graph.get(top)) {
                // 如果dist中还没有该元素说明还没有被访问
                if (!dist.containsKey(c)) {
                    dist.put(c, d);
                    q.add(c);
                }
            }
        }
    }

}
