package code.interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 字符串全排列
 * @author haroldcoding
 * @create 2017/07/23/16:49
 */
public class Number28 {
    
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return result;
        }
        char[] strChars = str.toCharArray();
        
        HashSet<String> resSet = new HashSet<>();
        
        for (int i = 0, size = strChars.length; i < size; i++) {
            swap(strChars, i, 0);
            permutation(strChars, 0, resSet);
        }
        result.addAll(resSet);
        Collections.sort(result);
        return result;
    }
    
    /**
     * 在第i位已经确定的情况下求出剩余几位字符的排列情况
     * @param chars 给定字符串字符数组
     * @param i 已经确定字符的索引位置
     * @param result 字符串保存在result中
     */
    private static void permutation(char[] chars, int i, HashSet<String> result) {
        if (i == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }
        for (int j = i + 1; j < chars.length; j++) {
            swap(chars, j, i + 1);
            permutation(chars, i + 1, result);
            swap(chars, j, i + 1);
        }
    }
    
    private static void swap(char[] chars, int i, int j) {
        if (j != i) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        
    }
    
    public static void main(String[] args) {
        String str = "aabc";
        ArrayList<String> res = permutation(str);
        
        Collections.sort(res);
        for (String i : res) {
            System.out.println(i);
        }
    }
}
