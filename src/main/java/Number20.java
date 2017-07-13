import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 *
 * @author haroldcoding
 * @create 2017/07/13/10:07
 */
public class Number20 {
    
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        while (rows > start * 2 && columns > start * 2) {
            printMatrixInCircle(result, matrix, start);
            ++start;
        }
        return result;
    }
    
    private static void printMatrixInCircle(ArrayList<Integer> result, int[][] matrix, int start) {
        int endRow = matrix.length - 1 - start;
        int endCol = matrix[0].length - 1 - start;
        // 从左到右添加一行
        for (int i = start; i <= endCol; i++) {
            result.add(matrix[start][i]);
        }
        // 从上到下添加一列
        if (start < endRow) {
            for (int i = start + 1; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            
            
        }
        // 从右到左添加一行
        if (start < endRow && start <= endCol - 1) {
            for (int i = endCol - 1; i >= start; i--) {
                result.add(matrix[endRow][i]);
            }
        }
        //从下到上添加一列
        if (start <= endCol - 1 && start < endRow - 1) {
            for (int i = endRow - 1; i > start; i--) {
                result.add(matrix[i][start]);
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {4, 5},{6,7}};
        int[][] matrix2 = {{1}, {2}, {3}};
        ArrayList<Integer> result = printMatrix(matrix);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
