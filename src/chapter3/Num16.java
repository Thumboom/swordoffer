package chapter3;


/**
 * ��һ�����������η�
 */
public class Num16 {

    //�ҵĽⷨ������ƽ�����ٳ˷�����
    public double a_Power(double base, int exponent) {

        if( exponent == 0) return 1;
        if( exponent == 1) return base;
        if( exponent == -1) return 1 / base;
        int yu = exponent % 2;
        int n = Math.abs(exponent);//����������������������
        double power = base;

        while((n = n /2 ) != 0) { //˼·�����Ž�һ����ֻ�����㲻ͬ
            power *= power;
            yu = n % 2;
        }

        //��������1���ٳ˻���
        if( yu == 1){
            power *= base;
        }
        return exponent > 0? power: 1/power;
    }

    /**
     * ���Žⷨ��ԭ��:10^1101 = 10^0001*10^0100*10^1000��
     *  *ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
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
