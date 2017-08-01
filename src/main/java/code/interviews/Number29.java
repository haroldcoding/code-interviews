package code.interviews;

import java.util.HashMap;

/**
 * 数组中出现次数超过数组长度一半的数
 *
 * @author haroldcoding
 * @create 2017/07/31/23:39
 */
public class Number29 {
    
    public static int moreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int arrLength = array.length;
        // key 为数组中第一次出现的数， value 为 该数在随后出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 1) + 1);
            if (map.get(i) > (arrLength >> 1)) {
                return i;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(moreThanHalfNum_Solution(arr));
    }
}
