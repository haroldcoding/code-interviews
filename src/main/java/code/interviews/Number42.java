package code.interviews;

/**
 * @author haroldcoding
 * @create 2017/08/07/12:57
 */
public class Number42 {
    
    /**
     * 翻转字符串顺序解法1
     */
    public static String converse(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] strArray = str.split("\\s");
        StringBuilder res = new StringBuilder(str.length());
        int len = strArray.length;
        for (int i = len - 1; i >= 0; i--) {
            res.append(strArray[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
    
    /**
     * 解法2 先翻转整个句子，然后在分别翻转整个单词
     */
    public static String solution2(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        converseWords(chars, 0, len - 1);
        int p1 = 0;
        int p2 = 0;
        while (p2 != len) {
            if (chars[p2] == ' ') {
                converseWords(chars, p1, p2 - 1);
                ++p2;
                p1 = p2;
            } else if (p2 == len - 1) {
                converseWords(chars, p1, p2);
                break;
            } else {
                ++p2;
            }
        }
        return String.valueOf(chars);
    }
    
    public static void converseWords(char[] strChars, int start, int end) {
        for (int i = start, k = end; i <= k; i++, k--) {
            swap(strChars, i, k);
        }
    }
    
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
    /**
     * 将字符串循环左移 n 位
     */
    public static String leftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return str;
        }
        int len = str.length();
        if (n > len && n % len == 0) {
            return str;
        }
        int rotateLen = n > len ? n % len : n;
        return str.substring(rotateLen) + str.substring(0, rotateLen);
    }
    
    public static void main(String[] args) {
        String s = "i am a student.";
        System.out.println(solution2(s));
        String s1 = "xyzabc";
        System.out.println(leftRotateString(s1, 17));
    }
}
