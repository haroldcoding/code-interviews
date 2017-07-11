/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方.
 *
 * @author haroldcoding
 * @create 2017/07/10/8:58
 */
public class Number11 {
    
    /**
     * 递归实现快速幂
     */
    public double power(double base, int exponent) {
        if (equals(base, 0.0) && exponent < 0) {
            throw new IllegalArgumentException("wrong argument");
        }
        
        int absExponent = exponent > 0 ? exponent : (-exponent);
        double result = powerWithUnsignedExponent(base, absExponent);
        return exponent > 0 ? result : (1.0 / result);
    }
    
    /**
     * 循环实现快速幂
     */
    public double power2(double base, int exponent) {
        if (equals(base, 0.0) && exponent < 0) {
            throw new IllegalArgumentException("wrong argument");
        }
        if (exponent == 0) {
            return 1;
        }
        int absExponent = exponent > 0 ? exponent : (-exponent);
        double result = base;
        while (absExponent > 1) {
            result *= result;
            if ((absExponent & 1) == 1) {
                result *= base;
            }
            absExponent = absExponent >> 1;
            
        }
        return exponent > 0 ? result : (1.0 / result);
    }
    
    private double powerWithUnsignedExponent(double base, int unsignedExponent) {
        if (unsignedExponent == 0) {
            return 1;
        }
        if (unsignedExponent == 1) {
            return base;
        }
        double result = powerWithUnsignedExponent(base, unsignedExponent >> 1);
        result *= result;
        if ((unsignedExponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
    
    private boolean equals(double one, double two) {
        if (one - two > -0.0000001 && one - two < 0.0000001) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Number11 n = new Number11();
        System.out.println(n.power2(2.0, 4));
        System.out.println(n.power(2.0, 7));
    }
    
}
