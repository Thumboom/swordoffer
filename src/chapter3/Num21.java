package chapter3;


/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 */
public class Num21 {

    //Ϊ��ά��������ż�������������λ�ò��䣬ʹ�ò��������㷨��
    public void reOrderArray(int [] array) {
        int temp;
        int length = array.length;
        int j;
        for(int i = 1; i < length; i ++){
            if( array[i] % 2 == 1){
                j = i;
                temp = array[i];
                while( j > 0 && array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    --j;
                }
                array[j] = temp;
            }
        }
        for(int t: array)
            System.out.print(t + ",");

    }

    public static void main(String[] args) {
        Num21 t = new Num21();
        int[] a = new int[]{1,2,3,4,7};
        t.reOrderArray(a);
        for(int i: a){
            System.out.print(i + ",");
        }
    }
}
