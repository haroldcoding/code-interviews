

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数.
 *
 * @author UIA
 * @create 2017/07/07/21:09
 */
public class Number3 {
    
    /**
     * 从数组左下角数字开始查起，该数字为行最大，列最小，所以 target 比该值大则往左移动继续查找，否则往上移动查找。
     *
     * @param target 目标整数
     * @param array 待查数组
     */
    public boolean find(int target, int[][] array) {
        if (array == null || array.length < 1) {
            return false;
        }
        
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[row].length) {
            if (target == array[row][col]) {
                return true;
            } else if (target > array[row][col]) {
                ++col;
            } else if (target < array[row][col]) {
                --row;
            }
        }
        return false;
    }
    
    /**
     * 第二种思路 ： 每一行都进行二分查找.
     * 来源于牛客网
     *
     * @param target 目标整数
     * @param array 源数组
     */
    public boolean find2(int target, int[][] array) {
        if (array == null || array.length < 1) {
            return false;
        }
        for (int i = 0, length = array.length; i < length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (target == array[i][middle]) {
                    return true;
                } else if (target > array[i][middle]) {
                    low = middle + 1;
                } else if (target < array[i][middle]) {
                    high = middle - 1;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        int[][] a = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };
        Number3 s = new Number3();
        System.out.println(s.find2(1, a));
        System.out.println(s.find2(141, a));
        System.out.println(s.find2(4, a));
        System.out.println(s.find2(2, a));
    }
}
