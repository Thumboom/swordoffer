package chapter2;


/**
 * ��һ�����Ķ��������е�1�ĸ���
 */
public class Num15 {
    //�ⷨһ��ÿ��������λ����֤һ���Ƿ����1
    public int a_NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n>>i & 1) >= 1){
                count++;
            }
        }
        return count;
    }

    /**
     * �ⷨ����һ������һ����ԭ���������㣬��
     * �õ���ôһ�����������ĵĶ���������ԭ��
     * ���ұߵ�1���0�Ľ��
     */

    public int b_NumberOf1(int n) {
        int count = 0;
        while( n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
