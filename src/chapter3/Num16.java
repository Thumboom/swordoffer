package chapter3;


/**
 * 求一个数的整数次方
 */
public class Num16 {

    //我的解法：利用平方减少乘法次数
    public double a_Power(double base, int exponent) {

        if( exponent == 0) return 1;
        if( exponent == 1) return base;
        if( exponent == -1) return 1 / base;
        int yu = exponent % 2;
        int n = Math.abs(exponent);//将负数情况当正数情况看待
        double power = base;

        while((n = n /2 ) != 0) { //思路与最优解一样，只是运算不同
            power *= power;
            yu = n % 2;
        }

        //余数等于1则再乘基数
        if( yu == 1){
            power *= base;
        }
        return exponent > 0? power: 1/power;
    }

    /**
     * 最优解法：原理:10^1101 = 10^0001*10^0100*10^1000。
     *  *通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double b_Power(double base, int exponent) {
        int n = Math.abs(exponent);
        double r = 1, temp = base;

        if( n == 0) return 1;

        while( n != 0){
            if( (n & 1) == 1 ){
                r *= temp;
            }

            temp *= temp;
            n = n>>1;
        }
        return exponent > 0? r : 1/r;
    }



}
