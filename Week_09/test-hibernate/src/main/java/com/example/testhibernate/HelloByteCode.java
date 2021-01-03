package com.example.testhibernate;

import java.util.*;

/**
 * @author Winter
 * @Project exSQL_all
 * @Package cn.com.atlasdata
 * @Title HelloByteCode.java
 * @Email yanwt@vastdata.com.cn
 * @modified
 * @date 2020年10月17 10:59:02
 * @Copyright 广州云图数据技术有限公司
 * @Description 此处添加该类的详细说明
 */
public class HelloByteCode {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) {
             this.val = val;
         }
         ListNode(int val, ListNode next) {
             this.val = val; this.next = next;
         }
     }

    public static void main(String[] args) {
        System.out.println(foo(" "));
    }

    public static int foo(String s){
        if(s==null||"".equals(s)){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        // 指针1记录第一个字符位置，指针2记录下一个字符位置
        // 判断指针2所在字符与前n-1个字符是否重复
        // 如果不重复，移动指针2；如果下一个字符为空，则返回整个字符串长度，并比较记录的长度返回最大值并结束
        // 如果重复，记录前n-1的长度，记录被重复的位置，将指针1移动到被重复位置+1，指针2重置为指针1+1
        int result = 0;
        int i = 0;
        int j = 1;

        int last = s.length()-1;
        while (i<=last){
            String substring = s.substring(i, j);
            char c = s.charAt(j);
            if(!substring.contains(String.valueOf(c))){
                j++;
            }else{
                result = substring.length()>result?substring.length():result;
                i = substring.indexOf(c)+i+1;
                j = i+1;
            }

            if(j>last){
                int current = j-i;
                return current>result?current:result;
            }
            continue;
        }
        return result;
    }
}
