package com.windcoder.javaWork.everyDay.day9;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str: strs) {
            String copy = new String(str);
            char[] chars =  copy.toCharArray();
            Arrays.sort(chars);
            copy =   String.valueOf(chars);
            if (map.containsKey(copy)) {
                map.get(copy).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(copy,list);
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        g.groupAnagrams(s);
    }
}
