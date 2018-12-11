package chapter4;


/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 */
public class Num33 {

    /**
     * �ҵ�˼·������������ĺ��������У����һ��Ԫ�������ĸ��ڵ㣬ǰ�������
     * ��Ϊ��������������������������<��<���������ֽ��ߵ�ȷ�������ַ�������һ
     * ���Ǵ����ұ������������ĵ�һ�����ڸ��ڵ��Ԫ�ؾ��Ƿֽ��ߣ��ڶ�����
     * �Ӹ��ڵ��ұ߿�ʼ�������У������ĵ�һ��С�ڸ��ڵ��Ԫ�ؾ��Ƿֽ��ߡ�
     * �ҵ��뷨�ǲ��õĵڶ��֡�
     * �ڵڶ��ֵķֽ��ߵ���ߣ������ֽ��ߣ������������ұ�ֱ�����ڵ�ǰһ��
     * Ԫ�����������������ж����������Ƿ��д��ڸ��ڵ��Ԫ�أ����򷵻�false��
     * �ٲ��÷���˼��ݹ��ж��������������е������
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return a_judge(sequence, 0, sequence.length - 1);
    }

    public boolean a_judge(int[] a, int start, int end){
        if(start >= end)
            return true;

        int i = end - 1;

        //�ҵ���һ���ȸ��ڵ�С��Ԫ��
        while( i >= start &&  a[i] > a[end] ){
            -- i;
        }
        //������������бȸ��ڵ��Ľڵ����ܹ��ɺ�������
        for( int cur = start; cur <= i; cur ++){
            if( a[cur] > a[end]) return false;
        }


        boolean left = a_judge(a, start, i);
        if( !left ) return false;//���ٵݹ����
        return  a_judge(a, i + 1, end - 1);

    }


    /**
     * ţ�����𰸣����ҵ��뷨һ����ֻ��ѡȡ�˲�һ���ķֽ��ߡ�
     * ѡȡ�������ĵ�һ�ַֽ��ߣ���ʱ��Ҫ�����������ж��Ƿ�
     * ��С�ڸ��ڵ�Ľڵ㣬���򷵻�false��
     *
     */
    public boolean b_judge(int[] a, int start, int end){

        if(start >= end){
            return true;
        }
        int i = start;
        while(a[i] < a[end]){
            ++i;
        }
        for(int j=i;j<end;j++){
            if(a[j] < a[end]){
                return false;
            }
        }
        boolean left = b_judge(a,start,i-1);
        if(!left) return false;

        return  b_judge(a,i,end-1);
    }

}
