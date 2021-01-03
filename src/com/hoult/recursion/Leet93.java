package com.hoult.recursion;

import java.util.ArrayList;
import java.util.List;

public class Leet93 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<String>();
            List<String> temp = new ArrayList<String>();

            backtrack(res, temp, s);
            return res;
        }

        private void backtrack(List<String> res, List<String> temp, String next) {
            if(temp.size() > 4) { //否则会超时
                return;
            }
            if (temp.size() == 4 && next.length() == 0) {
                String ip = temp.get(0) + "." + temp.get(1) + "." + temp.get(2) + "." + temp.get(3);
                res.add(ip);
                return;
            }

            for (int i = 0; i < next.length(); i++) {
                String s = next.substring(0, i + 1);
                if (s.length() > 3)
                    continue;

                if (s.length() > 1 && s.charAt(0) == '0')
                    continue;

                if (s.length() == 3 && "255".compareTo(s) < 0)
                    continue;

                temp.add(s);
                backtrack(res, temp, next.substring(i + 1));
                temp.remove(temp.size() - 1);
            }
        }


    }
}
