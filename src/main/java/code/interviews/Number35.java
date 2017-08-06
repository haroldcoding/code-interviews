package code.interviews;

import java.util.HashMap;

/**
 * 字符串中第一个只出现一次的字符
 * @author haroldcoding
 * @create 2017/08/06/14:35
 */
public class Number35 {
    
    /**
     * 先遍历一遍字符串，将字符串中的每个字符作为key，出现次数作为value保存在一个map中
     * 然后再遍历一遍字符串，对于每个字符在map中取出它出现的次数，返回次数为1 的第一个字符位置即可
     * @param str
     * @return
     */
    public static int solution(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int strLength = str.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < strLength; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 将每个字符第一次出现的位置作为value,保存在一个map中，然后用一个和字符串长度相等的数组，在数组中对应于每个字符
     * 第一次出现的位置保存该字符的出现次数，最后遍历该数组，找到 次数为1时的索引即可
     *
     * @param str
     * @return
     */
    public static int solution1(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int strLength = str.length();
        int[] repeat = new int[strLength];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strLength; i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
                repeat[i] = 1;
            } else {
                repeat[map.get(c)] += 1;
            }
        }
        for (int i = 0; i < strLength; i++) {
            if (repeat[i] == 1) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        String str = "abacbbbbbbb";
        System.out.println(solution(str));
    }
}
