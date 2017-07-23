package code.interviews;

/**
 * 将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author haroldcoding
 * @create 2017/07/08/10:51
 */
public class Number4 {
    
    public String replaceSpace5(StringBuffer str) {
        char[] source = str.toString().toCharArray();
        int spaceNumber = 0;
        int length = source.length;
        for (int i = 0; i < length; i++) {
            if (' ' == source[i]) {
                spaceNumber++;
            }
        }
        char[] result = new char[length + spaceNumber * 2];
        for (int i = length - 1; i >= 0; i--) {
            if (' ' == source[i]) {
                int index = i + spaceNumber * 2;
                result[index - 2] = '%';
                result[index - 1] = '2';
                result[index] = '0';
                spaceNumber--;
            } else {
                result[i + spaceNumber * 2] = source[i];
            }
        }
        return new String(result);
    }
    
    /**
     * 将参数 str 转换为字符串s，然后新建一个 StringBuffer 对象 resultStr，遍历字符串s，遇到空格字符时
     * resultStr 在末尾追加 ”%20“，否则原样追加就可以啦.
     */
    public String replaceSpace(StringBuffer str) {
        if (null == str || 0 == str.length()) {
            return "";
        }
        String s = str.toString();
        StringBuffer resultStr = new StringBuffer();
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            if (' ' == c) {
                resultStr.append("%20");
            } else {
                resultStr.append(c);
            }
            
        }
        return resultStr.toString();
    }
    
    /**
     * 不允许新建 StringBuffer 对象, 那么在源 StringBuffer 对象上替换空格时注意一下空格的索引就行了.
     */
    public String replaceSpace2(StringBuffer str) {
        if (null == str || 0 == str.length()) {
            return "";
        }
        String s = str.toString();
        int spaceNumber = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            if (' ' == c) {
                int index = i + spaceNumber * 2;
                str.replace(index, index + 1, "%20");
                spaceNumber++;
            }
        }
        
        return str.toString();
    }
    
    /**
     * 利用 StringBuffer 的 indexOf() 和 replace() 方法.
     */
    public String replaceSpace3(StringBuffer str) {
        if (null == str || 0 == str.length()) {
            return "";
        }
        int i = str.indexOf(" ");
        while (-1 != i) {
            str.replace(i, i + 1, "%20");
            i = str.indexOf(" ");
        }
        
        return str.toString();
    }
    
    /**
     * 利用正则表达式替换
     */
    public String replaceSpace4(StringBuffer str) {
        return str.toString().replaceAll("\\s", "%20");
    }
    
    public static void main(String[] args) {
        Number4 r = new Number4();
        System.out.println(r.replaceSpace(new StringBuffer("a b c d ")));
        System.out.println(r.replaceSpace2(new StringBuffer("a b c d ")));
        System.out.println(r.replaceSpace3(new StringBuffer("a b c d ")));
        System.out.println(r.replaceSpace5(new StringBuffer("a b c d ")));
    }
}
