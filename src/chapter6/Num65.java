package chapter6;

/**
 * 写一个函数，求两个整数之和，要求在
 * 函数体内不得使用+、-、*、/四则运算符号。
 */
public class Num65 {
    /**
     * 牛客思路：两个数按位与得到的结果就该为位需要向前进一位的结果，
     * 按位或得到的结果就是没有进位的部分。然后不断重复上面两个步骤，
     * 直到再没有进位为止。
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int temp;

        while(num2 != 0){
            temp = num1^num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }

        return num1;
    }

}
