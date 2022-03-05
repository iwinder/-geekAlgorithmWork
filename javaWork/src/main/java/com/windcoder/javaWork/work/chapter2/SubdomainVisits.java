package com.windcoder.javaWork.work.chapter2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [811. 子域名访问计数](https://leetcode-cn.com/problems/subdomain-visit-count/)
 */
public class SubdomainVisits {
    /**
     * 子域名访问计数 --方式一：字符串切割,通过indexOf始终获取当前数组中第一个"."
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> damainInfo = new HashMap<>(); // 存储子域名及其出现次数
        List<String> result = new ArrayList<>(); // 最终结果集
        for (String cpdomain: cpdomains) {
            String[] strings = cpdomain.split(" ");  // 数字和域名拆分
            String num = strings[0]; // 数字
            String domains = strings[1]; // 域名
            damainInfo.put(domains, damainInfo.getOrDefault(domains,0)+Integer.parseInt(num)); // 增加当前第一个域名
            int index = domains.indexOf("."); // 始终获取当前字符串中 “.” 出现的第一个位置
            while(index>=0) {// 当小于0时，说明不再存在其余域名
                domains = domains.substring(index+1); // 截取当前子域名
                damainInfo.put(domains, damainInfo.getOrDefault(domains,0)+Integer.parseInt(num));
                index = domains.indexOf("."); // 获取新字符串中“.” 出现的第一个位置
            }
        }
        damainInfo.forEach((key,value)->{
            result.add(value+" "+key);
        });

        return result;

    }

    /**
     * 子域名访问计数 --方案二：字符串拆分，通过split拆分成多个数组
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits2(String[] cpdomains) {
        Map<String,Integer> damainInfo = new HashMap<>(); // 存储子域名及其出现次数
        List<String> result = new ArrayList<>(); // 最终结果集
        for (String cpdomain: cpdomains) {
            String[] strings = cpdomain.split(" ");  // 数字和域名拆分
            String num = strings[0]; // 数字
            String domains = strings[1]; // 域名
            String[] domaonArry = domains.split("\\."); // 拆分数组
            int len = domaonArry.length;
            String domain = null;
            for (int i=len-1;i>=0;i++) {
                domain =i==0?domaonArry[i]:domaonArry[i]+"."+domain;
                damainInfo.put(domain, damainInfo.getOrDefault(domain,0)+Integer.parseInt(num));
            }
        }
        damainInfo.forEach((key,value)->{
            result.add(value+" "+key);
        });

        return result;

    }

    public static void main(String[] args) {
        SubdomainVisits visits = new SubdomainVisits();
        String[] cpdomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = visits.subdomainVisits(cpdomains);
        for (String str: list) {
            System.out.println(str);
        }


    }
}
