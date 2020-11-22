package com.hoult.hashtable;

import java.util.*;

public class Leet347 {
    public int[] topKFrequent(int[] nums, int k) {
        //建立哈希表（字典），以键值对的形式存储数字和频次
        Map<Integer,Integer> map=new HashMap<>();
        int[] res=new int[k];
        for(int num:nums){
            //如果字典中已经存储了数字，则说明数字不是第一次出现，将其频次加1
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{//否则，其是第一次出现，频次为1
                map.put(num,1);
            }
        }
        //建立优先队列（小根堆），通过Comparator自定义排序算法
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b){//根据数字的频次进行排序
                return map.get(a)-map.get(b);
            }
        });
        for(Integer key:map.keySet()){//遍历字典的键
            if(queue.size()<k){//如果队列的规模小于k，直接入队
                queue.add(key);
            }else if(map.get(key)>map.get(queue.peek())){//否则与队列中频次最小的数进行比较
                queue.poll();//若队列中频次最小的数比该数字的频次小，则将其出队，将当前数字入队
                queue.add(key);
            }
        }
        int i=0;
        while(!queue.isEmpty()){
            res[i++]=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : new Leet347().topKFrequent(new int[]{1, 1, 2, 3, 4, 2}, 2)) {
            System.out.println(i);
        }
    }
}
