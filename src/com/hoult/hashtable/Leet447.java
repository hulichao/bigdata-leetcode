package com.hoult.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Leet447 {
    public int numberOfBoomerangs(int[][] points) {
        //1.首先遍历点
        //2.计算除本身外其他点到此点的距离
        //3.保存距离，values，如果大于1，利用公式n(n-1)来计算，回旋镖个数，比如与a距离相同的有三个点，那么有n(n-1)个回旋镖
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            //存储点到其他点的距离，key为距离，value为频次
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = dis(points[i], points[j]);
                    if (!map.containsKey(d))
                        map.put(d, 1);
                    else
                        map.put(d, map.get(d) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> set : map.entrySet()) {
                if (set.getValue() > 1)
                    result += set.getValue() * (set.getValue() - 1);
            }
        }

        return result;
    }

    //计算两点距离
    public int dis(int[] l, int[] r) {
        return (int)(Math.pow(l[0] - r[0], 2) + Math.pow(l[1] - r[1], 2));
    }

    public static void main(String[] args) {
        System.out.println(new Leet447().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
